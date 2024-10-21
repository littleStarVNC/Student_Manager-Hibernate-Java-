package view;

import javax.swing.*;

import service.FlappyBirdGame;

import java.awt.*;
import java.net.URL;

public class FlappyBirdGUI extends JPanel {
    private static final long serialVersionUID = 1L;
    private FlappyBirdGame game;

    public FlappyBirdGUI() {
    	
        
        setPreferredSize(new Dimension(FlappyBirdGame.WIDTH, FlappyBirdGame.HEIGHT));
        setBackground(Color.CYAN);

        game = new FlappyBirdGame();
        add(game);
    }

    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame = new JFrame("Flappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    
  
        // Tạo một đối tượng FlappyBirdGUI và thêm vào JFrame
        FlappyBirdGUI flappyBirdGUI = new FlappyBirdGUI();
        frame.getContentPane().add(flappyBirdGUI);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
