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

import tn.com.healthcare.core.model.Bloc;
import tn.com.healthcare.core.model.Patient;
import tn.com.healthcare.core.service.BlocService;
import tn.com.healthcare.core.service.PatientService;
import tn.rnu.healthcare.web.data.binder.PatientFormData;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class PatientViewModel extends PatientFormData {

	private static final long serialVersionUID = 1L;

	private String dateFormat;

	private int memoHeight = 6;

	private String foregroundColour = "#000000";

	private String backgroundColour = "#FDC966";

	@WireVariable
	private PatientService patientService;

	@WireVariable
	private BlocService blocService;

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

	@Command(value = "addPatient")
	public void addPatient() {
		Patient patient = new Patient();
		Bloc bloc = null;
		BeanUtils.copyProperties(patientDto, patient);
		System.out.println(patient.getIdentityCardNumber());
		patient.setIdentityCardNumber(Integer.parseInt(patientDto
				.getIdentityCardNumber()));
		patient.setBedNumber(Integer.parseInt(patientDto.getBedNumber()));
		System.out.println(patientDto.getBloc());
		if (patientDto.getBloc().equals("B")) {
			bloc = blocService.searchBloc(1L);
		} else if (patientDto.getBloc().equals("A")) {
			bloc = blocService.searchBloc(2L);
		} else {

			Messagebox.show("this is errer");
		}

		patient.setBloc(bloc);
		patient.setState(true);
		patientService.saveAndFlush(patient);

		Messagebox.show("Add Patient successful");
	}
}
