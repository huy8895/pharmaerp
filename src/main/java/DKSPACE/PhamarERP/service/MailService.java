package DKSPACE.PhamarERP.service;

import DKSPACE.PhamarERP.auth.model.User;

public interface MailService {
	void sendMailResetPassword(String email);
	
	void sendMailChangedPassword(String email, String newPassword);
	
	
	void sendActivationEmail(User user);
	
	
	void sendCreationEmail(User user, String password);
	
	
	void sendPasswordResetMail(User user);
}
