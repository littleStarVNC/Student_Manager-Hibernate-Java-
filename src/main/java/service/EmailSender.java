package service;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.swing.*;

public class EmailSender {
    private final String from;
    private final String password;

    public EmailSender(String from, String password) {
        this.from = from;
        this.password = password;
    }

    public void sendEmail(String[] to, String subject, String messageContent) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(from));
            
            // Set recipients
            Address[] recipients = new Address[to.length];
            for (int i = 0; i < to.length; i++) {
                recipients[i] = new InternetAddress(to[i]);
            }
            mimeMessage.setRecipients(Message.RecipientType.TO, recipients);
            
            mimeMessage.setSubject(subject);
            mimeMessage.setText(messageContent);

            Transport.send(mimeMessage);
           JOptionPane.showMessageDialog(null, "Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to send email.");
        }
    }
}
