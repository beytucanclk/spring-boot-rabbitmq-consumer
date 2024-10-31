package tech.flap.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setFrom("info@kodbilimi.com");

        try {
            mailSender.send(message);
            System.out.println("Mail sent successfully");
        } catch (Exception e) {
            System.out.println("Error while sending mail: " + e.getMessage());
        }
    }
}
