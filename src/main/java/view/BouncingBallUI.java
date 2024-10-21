package view;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import service.BouncingBallGame;

public class BouncingBallUI extends JPanel {

    private static final long serialVersionUID = 1L;
    private BouncingBallGame game;

    public BouncingBallUI() {
        setLayout(null);
        setBackground(new Color(64, 128, 128));

        game = new BouncingBallGame();
        game.setBounds(0, 0, 500, 335);
        add(game);

        JButton btnRestart = new JButton("Restart");
        btnRestart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.resetGame();
            }
        });
        btnRestart.setFont(new Font("Arial", Font.BOLD, 13));
        btnRestart.setBounds(200, 350, 100, 30);
        add(btnRestart);
    }
}
