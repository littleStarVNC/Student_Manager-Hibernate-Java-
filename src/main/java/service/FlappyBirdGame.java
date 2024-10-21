package service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FlappyBirdGame extends JPanel implements ActionListener, Runnable {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 540;
    private static final int GROUND_HEIGHT = 1;
    private static final int BIRD_SIZE = 16;
    private static final int PIPE_WIDTH = 90;
    private static final int PIPE_HEIGHT = 350;
    private static final int PIPE_DISTANCE = 250;
    private static final int PIPE_SPEED = 3;
    private static final int GRAVITY = 1;

    private int birdY = HEIGHT / 2;
    private int birdVelocity = 0;
    private int score = 0;
    private BirdIcon birdIcon; 

    private boolean isGameOver = false;
    private Rectangle bird;
    private Rectangle[] pipes;

    public FlappyBirdGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.CYAN);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (!isGameOver) {
                        birdVelocity = -10;
                    } else {
                        resetGame();
                    }
                }
            }
        });

        bird = new Rectangle(WIDTH / 2, birdY, BIRD_SIZE, BIRD_SIZE);
        pipes = new Rectangle[3];
        pipes[0] = new Rectangle(WIDTH, HEIGHT - PIPE_HEIGHT - GROUND_HEIGHT, PIPE_WIDTH, PIPE_HEIGHT);
        pipes[1] = new Rectangle(WIDTH + PIPE_DISTANCE, HEIGHT - PIPE_HEIGHT - GROUND_HEIGHT, PIPE_WIDTH, PIPE_HEIGHT);
        pipes[2] = new Rectangle(WIDTH + PIPE_DISTANCE * 2, HEIGHT - PIPE_HEIGHT - GROUND_HEIGHT, PIPE_WIDTH, PIPE_HEIGHT);
        
        birdIcon = new BirdIcon(); // Khởi tạo birdIcon
  

        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        birdIcon.paintIcon(this, g2d, bird.x, bird.y);


        // Draw pipes
        g2d.setColor(Color.GREEN);
        for (Rectangle pipe : pipes) {
            g2d.fill(pipe);
        }

        // Draw bird
        g2d.setColor(Color.RED);
        g2d.fill(bird);

        // Draw score
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("Score: " + score, 20, 30);

        // Display game over message
        if (isGameOver) {
            g2d.setFont(new Font("Arial", Font.BOLD, 40));
            g2d.drawString("Game Over!", WIDTH / 2 - 120, HEIGHT / 2 - 20);
            g2d.drawString("Press SPACE to play again", WIDTH / 2 - 240, HEIGHT / 2 + 40);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
            update();
            checkCollisions();
            repaint();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(20);
                if (!isGameOver) {
                    update();
                    checkCollisions();
                    repaint();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        for (Rectangle pipe : pipes) {
            pipe.x -= PIPE_SPEED;
            if (pipe.x + PIPE_WIDTH < 0) {
                pipe.x = WIDTH;
                pipe.y = (int) (Math.random() * (HEIGHT - GROUND_HEIGHT - PIPE_HEIGHT));
                score++;
            }
        }

        birdVelocity += GRAVITY;
        bird.y += birdVelocity;

        if (bird.y >= HEIGHT - GROUND_HEIGHT || bird.y <= 0) {
            gameOver();
        }
    }

    private void checkCollisions() {
        for (Rectangle pipe : pipes) {
            if (bird.intersects(pipe)) {
                gameOver();
                return;
            }
        }
    }

    private void gameOver() {
        isGameOver = true;
    }

    private void resetGame() {
        isGameOver = false;
        birdY = HEIGHT / 2;
        birdVelocity = 0;
        score = 0;
        bird.y = birdY;
        for (int i = 0; i < pipes.length; i++) {
            pipes[i].x = WIDTH + i * PIPE_DISTANCE;
            pipes[i].y = (int) (Math.random() * (HEIGHT - GROUND_HEIGHT - PIPE_HEIGHT));
        }
    }
}
