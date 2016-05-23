package tn.rnu.healthcare.web.viewmodel;

import org.springframework.beans.BeanUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;

import tn.com.healthcare.core.model.PerformanceReport;
import tn.com.healthcare.core.service.PerformanceReportService;
import tn.rnu.healthcare.web.data.binder.PerformanceReportFormData;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ReportViewModel extends PerformanceReportFormData {

	private static final long serialVersionUID = 1L;

	private String dateFormat;
	private int memoHeight = 6;
	private String foregroundColour = "#000000", backgroundColour = "#FDC966";

	@WireVariable
	private PerformanceReportService performanceReportService;

	public String getForegroundColour() {
		return foregroundColour;
	}

	public void setForegroundColour(String foregroundColor) {
		this.foregroundColour = foregroundColor;
	}

	public String getBackgroundColour() {
		return backgroundColour;
	}

	public void setBackgroundColour(String backgroundColor) {
		this.backgroundColour = backgroundColor;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public int getMemoHeight() {
		return memoHeight;
	}

	public void setMemoHeight(int memoHeight) {
		this.memoHeight = memoHeight;
	}

	@Command
	@NotifyChange("memoHeight")
	public void changeMemoHeight(
			@ContextParam(ContextType.TRIGGER_EVENT) InputEvent change) {
		try {
			int parsed = Integer.parseInt(change.getValue());
			if (parsed > 0) {
				this.memoHeight = parsed;
			}
		} catch (NumberFormatException nfe) {
			// nothing that we can do here, the validation should pick it up
		}
	}

	@Command
	@NotifyChange("captcha")
	public void regenerate() {
		this.regenerateCaptcha();
	}

	@Command(value = "addReport")
	public void addReport() {

		PerformanceReport report = new PerformanceReport();
		BeanUtils.copyProperties(performanceReportDto, report);
		/* formating String to java.util.Date */
		// Date stringDateFormat = performanceReportDto.getDate();
		// System.out.println(stringDateFormat);
		// DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		// Date convertedDate = null;
		// try {
		// convertedDate = (Date) formatter.parse(stringDateFormat);
		// System.out.println("Date from dd/MM/yyyy String in Java : "
		// + convertedDate);
		//
		// } catch (ParseException e) {
		// System.out.println(e.getMessage());
		// e.printStackTrace();
		// }
		//
		// report.setDate(convertedDate);

		performanceReportService.saveAndFlush(report);

		Messagebox.show("Add Rapport successful");

	}

}
