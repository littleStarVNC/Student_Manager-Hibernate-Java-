package view;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.EmailSender;
import java.awt.Color;

public class SentEmail extends JPanel {
    private JTextArea txtrNhpNiDung;
    private JTextField recipientField;

    public SentEmail() {
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 876, 603);
        add(panel);
        panel.setLayout(null);

        JLabel lblRecipients = new JLabel("Học Viên (@a,@b, @c,...)");
        lblRecipients.setFont(new Font("Arial", Font.BOLD, 14));
        lblRecipients.setBounds(24, 9, 200, 25);
        panel.add(lblRecipients);

        recipientField = new JTextField();
        recipientField.setText("Nhập email");
        recipientField.setBounds(220, 10, 634, 25);
        panel.add(recipientField);

        txtrNhpNiDung = new JTextArea();
        txtrNhpNiDung.setText("Nhập nội dung cần gửi");
        txtrNhpNiDung.setBounds(10, 50, 844, 458);
        panel.add(txtrNhpNiDung);

        JButton btnSend = new JButton("Send");
        btnSend.setBackground(new Color(128, 255, 128));
        btnSend.setFont(new Font("Arial", Font.BOLD, 16));
        btnSend.setBounds(10, 538, 844, 55);
        panel.add(btnSend);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = txtrNhpNiDung.getText();
                String recipientsText = recipientField.getText();
                String[] recipients = recipientsText.split(",\\s*"); // Split by comma and optional spaces
                String subject = "Course Details";

                // Use your email and the generated app password here
                EmailSender emailSender = new EmailSender("managerlearner123@gmail.com", "jxza wvhz slqz dbil");
                emailSender.sendEmail(recipients, subject, message);
                
            }
        });
    }


}
