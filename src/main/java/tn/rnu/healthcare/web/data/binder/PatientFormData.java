package tn.rnu.healthcare.web.data.binder;

import java.io.Serializable;

import tn.rnu.healthcare.web.utils.RandomStringGenerator;

public class PatientFormData implements Serializable {

	private static final long serialVersionUID = 1L;

	private RandomStringGenerator rsg = new RandomStringGenerator(4);

	protected PatientData patientDto = new PatientData();

	private String retypedPassword;

	private String captcha = rsg.getRandomString(), captchaInput;

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
	 * @return the patientDto
	 */
	public PatientData getPatientDto() {
		return patientDto;
	}

	/**
	 * @param patientDto
	 *            the patientDto to set
	 */
	public void setPatientDto(PatientData patientDto) {
		this.patientDto = patientDto;
	}

	public String getRetypedPassword() {
		return retypedPassword;
	}

	public void setRetypedPassword(String retypedPassword) {
		this.retypedPassword = retypedPassword;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getCaptchaInput() {
		return captchaInput;
	}

	public void setCaptchaInput(String captchaInput) {
		this.captchaInput = captchaInput;
	}

	public void regenerateCaptcha() {
		this.captcha = rsg.getRandomString();
	}

}
