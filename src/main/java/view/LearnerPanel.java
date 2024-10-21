package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

import Controller.QuanLyHocVienController;

import java.awt.Font;
import javax.swing.ImageIcon;

public class LearnerPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfSearch;

	/**
	 * Create the panel.
	 */
	public LearnerPanel() {
		setLayout(null);
		
		JPanel jpnRoot = new JPanel();
		jpnRoot.setBackground(new Color(240,240,240));
		jpnRoot.setBounds(0, 0, 912, 747);
		add(jpnRoot);
		jpnRoot.setLayout(null);
		
		JButton btnAdd = new JButton("Thêm học viên");
		btnAdd.setIcon(new ImageIcon(LearnerPanel.class.getResource("/Image/add_icon1.png")));
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 20));
		btnAdd.setBackground(new Color(128, 255, 128));
		btnAdd.setBounds(396, 23, 206, 48);
		jpnRoot.add(btnAdd);
		
		jtfSearch = new JTextField();
		jtfSearch.setBounds(41, 34, 335, 34);
		jpnRoot.add(jtfSearch);
		jtfSearch.setColumns(10);
		
		JPanel jpnView = new JPanel();
		jpnView.setBounds(10, 84, 893, 610);
		jpnRoot.add(jpnView);
		
		 JButton btnDelete = new JButton("Xóa ");
		 btnDelete.setBackground(new Color(219, 78, 36));
		 btnDelete.setIcon(new ImageIcon(LearnerPanel.class.getResource("/Image/Icon_Delete2.png")));
		 btnDelete.setFont(new Font("Arial", Font.BOLD, 16));
		 btnDelete.setBounds(612, 24, 122, 48);
		 jpnRoot.add(btnDelete);
		 
		 JButton btnPrint = new JButton("Xuất Báo Cáo");
		 btnPrint.setFont(new Font("Arial", Font.BOLD, 14));
		 btnPrint.setBounds(754, 23, 148, 48);
		 jpnRoot.add(btnPrint);
		 

		 QuanLyHocVienController controller = new QuanLyHocVienController(
	                jpnView, btnAdd, btnDelete,btnPrint, jtfSearch);
		 
	
	                 controller.setDataToTable();
	                 controller.setEvent();
	}
}
