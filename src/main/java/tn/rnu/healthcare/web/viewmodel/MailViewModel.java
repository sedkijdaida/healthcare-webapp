package tn.rnu.healthcare.web.viewmodel;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

import tn.rnu.healthcare.web.data.binder.InboxData;
import tn.rnu.healthcare.web.data.binder.MailData;

public class MailViewModel {
	
	InboxData mailData = new InboxData();
	
	public InboxData getMailData() {
		return mailData;
	}

	@Command
	@NotifyChange("mailData")
	public void revertMail() {
		mailData.revertDeletedMails();
	}
	
	@Command
	@NotifyChange("mailData")
	public void deleteAllMail() {
		mailData.deleteAllMails();
	}
	
	@Command
	@NotifyChange("mailData")
	public void removeMail(@BindingParam("mail") MailData myMail) {
		mailData.deleteMail(myMail);
	}
}
