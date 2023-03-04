package DKSPACE.PhamarERP.service;

import DKSPACE.PhamarERP.auth.model.User;
import org.springframework.scheduling.annotation.Async;

public interface MailService {
	void sendMailResetPassword(String email) ;
	void sendMailChangedPassword(String email, String newPassword) ;
	
	@Async
	void sendActivationEmail(User user);
	
	@Async
	void sendCreationEmail(User user);
	
	@Async
	void sendPasswordResetMail(User user);
}
