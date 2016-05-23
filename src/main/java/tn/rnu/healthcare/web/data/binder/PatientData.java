package tn.rnu.healthcare.web.data.binder;

import java.io.Serializable;

import javax.persistence.Lob;

public class PatientData implements Serializable {

	private static final long serialVersionUID = 1L;

	private String lastName;

	private String firstName;

	private String identityCardNumber;

	private String bedNumber;

	@Lob
	private byte[] photo;

	private boolean state;

	private String bloc;

	/**
	 * @return the bloc
	 */
	public String getBloc() {
		return bloc;
	}

	/**
	 * @param bloc
	 *            the bloc to set
	 */
	public void setBloc(String bloc) {
		this.bloc = bloc;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the identityCardNumber
	 */
	public String getIdentityCardNumber() {
		return identityCardNumber;
	}

	/**
	 * @param identityCardNumber
	 *            the identityCardNumber to set
	 */
	public void setIdentityCardNumber(String identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
	}

	/**
	 * @return the bedNumber
	 */
	public String getBedNumber() {
		return bedNumber;
	}

	/**
	 * @param bedNumber
	 *            the bedNumber to set
	 */
	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}

	/**
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	/**
	 * @return the state
	 */
	public boolean isState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(boolean state) {
		this.state = state;
	}

}
