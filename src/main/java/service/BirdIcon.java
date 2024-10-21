package service;
import javax.swing.*;
import java.awt.*;

public class BirdIcon implements Icon {
    private static final int WIDTH = 30;
    private static final int HEIGHT = 20;
    private static final Color BODY_COLOR = Color.ORANGE;
    private static final Color EYE_COLOR = Color.BLACK;
    private static final Color BEAK_COLOR = Color.RED;

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
    	
        
        // Vẽ thân chim
        g.setColor(BODY_COLOR);
        g.fillRect(x, y, WIDTH, HEIGHT);

        // Vẽ mắt chim
        g.setColor(EYE_COLOR);
        g.fillOval(x + WIDTH - 12, y + 5, 8, 8);

        // Vẽ mỏ chim
        g.setColor(BEAK_COLOR);
        g.fillOval(x + 5, y + 7, 10, 5);
    }

    @Override
    public int getIconWidth() {
        return WIDTH;
    }

    @Override
    public int getIconHeight() {
        return HEIGHT;
    }

    public static void main(String[] args) {
        // Tạo một biểu tượng con chim
        BirdIcon birdIcon = new BirdIcon();

        // Hiển thị biểu tượng trong một JLabel
        JLabel label = new JLabel(birdIcon);

        // Tạo JFrame để hiển thị
        JFrame frame = new JFrame("Bird Icon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(100, 100));
        frame.getContentPane().add(label);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
