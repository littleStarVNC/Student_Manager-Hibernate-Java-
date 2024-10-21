package service;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BouncingBallGame extends JPanel implements KeyListener, Runnable {
    private int x = 0;
    private int y = 0;
    private int xSpeed = 2;
    private int ySpeed = 2;
    private int ballSize = 20;
    private int paddleWidth = 80;
    private int paddleHeight = 10;
    private int paddleX = 210; // Paddle's x coordinate
    private boolean gameOver = false;
    private int score = 0;
    private int highScore = 0;

    public BouncingBallGame() {
        Thread gameThread = new Thread(this);
        gameThread.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    private void moveBall() {
        Dimension size = getSize();
        x += xSpeed;
        y += ySpeed;

        if (x <= 0 || x >= size.width - ballSize) {
            xSpeed = -xSpeed;
        }

        if (y <= 0) {
            ySpeed = -ySpeed;
        }

        if (y >= size.height - ballSize - paddleHeight) {
            if (x + ballSize >= paddleX && x <= paddleX + paddleWidth) {
                // Reverse ball direction upon paddle hit
                ySpeed = -ySpeed;
                score++; // Increase score upon paddle hit
                if (score > highScore) {
                    highScore = score; // Update high score
                }
            } else {
                // End game if ball misses paddle
                gameOver = true;
                if (score > highScore) {
                    highScore = score; // Update high score if it exceeds previous high score
                }
            }
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw ball
        g.setColor(Color.RED);
        g.fillOval(x, y, ballSize, ballSize);

        // Draw paddle
        g.setColor(Color.BLUE);
        g.fillRect(paddleX, 280, paddleWidth, paddleHeight);

        // Draw score and high score
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Score: " + score, 10, 20);
        g.drawString("High Score: " + highScore, 10, 40);

        // Display game over message
        if (gameOver) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Game Over! Press any key to play again.", 50, 150);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver) {
            // Reset game if game over
            resetGame();
        } else {
            // Move paddle on arrow key press
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT && paddleX > 0) {
                paddleX -= 10;
            } else if (keyCode == KeyEvent.VK_RIGHT && paddleX < getWidth() - paddleWidth) {
                paddleX += 10;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public void resetGame() {
        x = 0;
        y = 0;
        xSpeed = 2;
        ySpeed = 2;
        paddleX = 210;
        gameOver = false;
        score = 0; // Reset score on game reset
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(7);
                if (!gameOver) {
                    moveBall();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
