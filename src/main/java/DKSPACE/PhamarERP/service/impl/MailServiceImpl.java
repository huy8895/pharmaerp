package DKSPACE.PhamarERP.service.impl;

import DKSPACE.PhamarERP.auth.model.User;
import DKSPACE.PhamarERP.service.MailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;


/**
 * Service for sending emails.
 * <p>
 * We use the {@link Async} annotation to send emails asynchronously.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
	
	private static final String USER = "user";
	
	private static final String BASE_URL = "baseUrl";
	
	private final JavaMailSender javaMailSender;
	
	private final MessageSource messageSource;
	
	private final SpringTemplateEngine templateEngine;
	private final LocaleResolver localeResolver;
	private final Executor taskExecutor;
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	public void sendSimpleEmail(String toEmail,
	                            String subject,
	                            String body
	) {
		log.info("start sendSimpleEmail: ");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromEmail);
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		javaMailSender.send(message);
		log.info("Mail Send...");
	}
	
	@Override
	public void sendMailResetPassword(String email) {
	
	}
	
	public void sendEmail(String to, String subject, String content, boolean isMultipart, boolean isHtml) {
		log.debug(
				"Send email[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
				isMultipart,
				isHtml,
				to,
				subject,
				content
		);
		
		// Prepare message using a Spring helper
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, StandardCharsets.UTF_8.name());
			message.setTo(to);
			message.setFrom("PhamarERPProperties.getMail().getFrom()");
			message.setSubject(subject);
			message.setText(content, isHtml);
			this.sentAsync(to, mimeMessage);
		} catch (MailException | MessagingException e) {
			log.warn("Email could not be sent to user '{}'", to, e);
		}
	}
	
	private void sentAsync(String to, MimeMessage mimeMessage) {
		CompletableFuture.runAsync(() -> javaMailSender.send(mimeMessage),
		                           taskExecutor)
				.handle((unused, throwable) -> {
					if (throwable != null){
						log.error("sendEmail error to: {}", to);
						return unused;
					}
					log.debug("Sent email to User '{}'", to);
					return unused;
				});
	}
	
	private void sendEmailFromTemplate(User user, String templateName, String titleKey) {
		if (user.getEmail() == null) {
			log.debug("Email doesn't exist for user '{}'", "user.getLogin()");
			return;
		}
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		Locale locale = localeResolver.resolveLocale(request);
		Context context = new Context(locale);
		context.setVariable(USER, user);
		context.setVariable(BASE_URL, "getBaseUrl()");
		String content = templateEngine.process(templateName, context);
		String subject = messageSource.getMessage(titleKey, null, locale);
		this.sendEmail(user.getEmail(), subject, content, false, true);
	}
	
	@Override
	public void sendActivationEmail(User user) {
		log.debug("Sending activation email to '{}'", user.getEmail());
		this.sendEmailFromTemplate(user, "mail/activationEmail", "email.activation.title");
	}
	
	@Override
	public void sendCreationEmail(User user, String password) {
		log.debug("Sending creation email to '{}'", user.getEmail());
		user.setPassword(password);
		this.sendEmailFromTemplate(user, "mail/creationEmail", "email.activation.title");
	}
	
	@Override
	public void sendPasswordResetMail(User user) {
		log.debug("Sending password reset email to '{}'", user.getEmail());
		this.sendEmailFromTemplate(user, "mail/passwordResetEmail", "email.reset.title");
	}
	
	@Override
	public void sendMailChangedPassword(User user, String newPassword) {
		log.debug("Sending ChangedPassword email to '{}'", user.getEmail());
		user.setPassword(newPassword);
		this.sendEmailFromTemplate(user, "mail/successResetPasswordEmail", "email.reset.title2");
	}
}
