package DKSPACE.PhamarERP.service;

public interface MailService {
	void sendMailResetPassword(String email) ;
	void sendMailChangedPassword(String email) ;
}
