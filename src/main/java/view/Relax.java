package view;

import javax.swing.JPanel;

import service.BouncingBallGame;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FlappyBirdGUI;
import javax.swing.JLabel;

public class Relax extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public Relax() {
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(64, 128, 128));
        panel.setBounds(0, 0, 1126, 747);
        add(panel);
        panel.setLayout(null);

        JButton btnFlappyBird = new JButton("Play FLAPPYBIRD");
        btnFlappyBird.setBackground(new Color(128, 255, 128));
        btnFlappyBird.setFont(new Font("Arial", Font.BOLD, 13));
        btnFlappyBird.setBounds(518, 234, 250, 39);
        panel.add(btnFlappyBird);
        
        JButton btnBouncingBall = new JButton("Play  BOUNCING BALL");
        btnBouncingBall.setBackground(new Color(128, 255, 128));
        btnBouncingBall.setFont(new Font("Arial", Font.BOLD, 14));
        btnBouncingBall.setBounds(79, 233, 250, 39);
        panel.add(btnBouncingBall);
        
        JLabel lblNewLabel = new JLabel("Đôi khi làm việc qua nhiều khiến chúng ta mệt mỏi , dưới đây , bạn có thể chơi một vài trò chơi  và có thể nó sẽ giúp bạn cảm thấy đỡ chán hơn");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(53, 93, 849, 61);
        panel.add(lblNewLabel);

        btnFlappyBird.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Tạo một đối tượng FlappyBirdGUI và hiển thị nó
                FlappyBirdGUI flappyBirdGUI = new FlappyBirdGUI();
                JFrame frame = new JFrame("Flappy Bird");
                frame.setResizable(false);
                frame.getContentPane().add(flappyBirdGUI);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        
        btnBouncingBall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BouncingBallGame bouncingBall = new BouncingBallGame();
                JFrame frame1 = new JFrame("Bouncing Ball");
                frame1.setResizable(false);
                frame1.setSize(500, 335);
                frame1.getContentPane().add(bouncingBall);
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
            }
        });

    }
}
