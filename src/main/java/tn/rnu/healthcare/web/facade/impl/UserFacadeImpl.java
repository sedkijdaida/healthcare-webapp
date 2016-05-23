package tn.rnu.healthcare.web.facade.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tn.com.healthcare.core.model.MaleNurse;
import tn.com.healthcare.core.service.UserService;
import tn.rnu.healthcare.web.data.binder.UserData;
import tn.rnu.healthcare.web.facade.UserFacade;

@Component
public class UserFacadeImpl implements UserFacade {

	@Autowired
	private UserService userService;

	public void saveMaleNurse(UserData user) {
		MaleNurse maleNurse = new MaleNurse();
		String[] ignoreProperties = { "memo" };
		BeanUtils.copyProperties(user, maleNurse, ignoreProperties);
		System.out.println(maleNurse.getIdentityCardNumber());
		maleNurse.setIdentityCardNumber(Integer.parseInt(user
				.getIdentityCardNumber()));
		maleNurse.setPostalCode(Integer.parseInt(user.getPostalCode()));
		maleNurse.setMobilePhoneNumber(Integer.parseInt(user
				.getMobilePhoneNumber()));

		userService.saveAndFlush(maleNurse);
	}

}
