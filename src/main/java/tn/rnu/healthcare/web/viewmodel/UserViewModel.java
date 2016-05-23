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

import tn.com.healthcare.core.model.Doctor;
import tn.com.healthcare.core.service.PatientService;
import tn.com.healthcare.core.service.UserService;
import tn.rnu.healthcare.web.data.binder.UserData;
import tn.rnu.healthcare.web.facade.UserFacade;
import tn.rnu.healthcare.web.utils.RandomStringGenerator;

/**
 * 
 * @author sedki
 * 
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class UserViewModel {

	private String dateFormat;

	private int memoHeight = 6;

	private String foregroundColour = "#000000";

	private String backgroundColour = "#FDC966";

	protected UserData user = new UserData();

	private RandomStringGenerator rsg = new RandomStringGenerator(4);

	private String retypedPassword;

	private String captcha = rsg.getRandomString();

	private String captchaInput;

	@WireVariable
	private UserService userService;

	@WireVariable
	private UserFacade userFacade;

	@WireVariable
	private PatientService patientService;

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

	@Command(value = "submit")
	public void submit() {
		userFacade.saveMaleNurse(user);
		Messagebox.show("Add successful");

	}

	@Command(value = "add")
	public void add() {

		Doctor doctor = new Doctor();
		String[] ignoreProperties = { "memo" };
		BeanUtils.copyProperties(user, doctor, ignoreProperties);
		System.out.println(doctor.getIdentityCardNumber());
		doctor.setIdentityCardNumber(Integer.parseInt(user
				.getIdentityCardNumber()));
		doctor.setPostalCode(Integer.parseInt(user.getPostalCode()));
		doctor.setMobilePhoneNumber(Integer.parseInt(user
				.getMobilePhoneNumber()));

		userService.saveAndFlush(doctor);

		Messagebox.show("Add Docotor successful");

	}

	public void regenerateCaptcha() {
		this.captcha = rsg.getRandomString();
	}

	/**
	 * @return the user
	 */
	public UserData getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserData user) {
		this.user = user;
	}

	/**
	 * @return the rsg
	 */
	public RandomStringGenerator getRsg() {
		return rsg;
	}

	/**
	 * @param rsg
	 *            the rsg to set
	 */
	public void setRsg(RandomStringGenerator rsg) {
		this.rsg = rsg;
	}

	/**
	 * @return the retypedPassword
	 */
	public String getRetypedPassword() {
		return retypedPassword;
	}

	/**
	 * @param retypedPassword
	 *            the retypedPassword to set
	 */
	public void setRetypedPassword(String retypedPassword) {
		this.retypedPassword = retypedPassword;
	}

	/**
	 * @return the captcha
	 */
	public String getCaptcha() {
		return captcha;
	}

	/**
	 * @param captcha
	 *            the captcha to set
	 */
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	/**
	 * @return the captchaInput
	 */
	public String getCaptchaInput() {
		return captchaInput;
	}

	/**
	 * @param captchaInput
	 *            the captchaInput to set
	 */
	public void setCaptchaInput(String captchaInput) {
		this.captchaInput = captchaInput;
	}

}
