package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class HomePagePanel extends JPanel {


	public HomePagePanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(0, 10, 1126, 747);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 255));
		panel_1.setBounds(10, -4, 281, 219);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HomePagePanel.class.getResource("/Image/dns_24dp.png")));
		lblNewLabel.setBounds(24, 24, 117, 155);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("3");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(203, 43, 45, 28);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Khóa học");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(160, 135, 100, 28);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(255, 128, 128));
		panel_1_1.setBounds(301, -4, 281, 219);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(HomePagePanel.class.getResource("/Image/groups_2_24dp.png")));
		lblNewLabel_3.setBounds(21, 22, 111, 155);
		panel_1_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("3");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(203, 43, 45, 28);
		panel_1_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Học Viên");
		lblNewLabel_2_1.setBackground(new Color(255, 128, 128));
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel_2_1.setBounds(160, 135, 100, 28);
		panel_1_1.add(lblNewLabel_2_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(128, 255, 128));
		panel_1_2.setBounds(592, -4, 281, 219);
		panel.add(panel_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(HomePagePanel.class.getResource("/Image/email_24dp.png")));
		lblNewLabel_4.setBounds(10, 28, 124, 155);
		panel_1_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("3");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel_1_2.setBounds(203, 43, 45, 28);
		panel_1_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Thông Báo");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 24));
		lblNewLabel_2_2.setBounds(130, 136, 141, 28);
		panel_1_2.add(lblNewLabel_2_2);
		
		

	}
}
