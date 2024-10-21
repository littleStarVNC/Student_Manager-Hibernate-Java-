package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.DangNhapController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;

public class DangNhapJDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField jtfTenDangNhap;
	private JPasswordField jtfMatKhau;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * @param b 
	 * @param object 
	 */
	public DangNhapJDialog(Object object, boolean b) {
		setBounds(100, 100, 822, 475);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		panel.setBounds(0, 0, 808, 438);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(DangNhapJDialog.class.getResource("/Image/login2.png")));
		lblNewLabel.setBounds(0, 0, 455, 438);
		panel.add(lblNewLabel);
		
		JLabel jlbTenDangNhap = new JLabel("Tên Đăng Nhập:");
		jlbTenDangNhap.setFont(new Font("Arial", Font.BOLD, 14));
		jlbTenDangNhap.setBounds(546, 74, 196, 29);
		panel.add(jlbTenDangNhap);
		
		jtfTenDangNhap = new JTextField();
		jtfTenDangNhap.setBounds(546, 113, 208, 37);
		panel.add(jtfTenDangNhap);
		jtfTenDangNhap.setColumns(10);
		
		JButton btnSubmit = new JButton("Đăng Nhập");
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 13));
		btnSubmit.setBackground(new Color(0, 164, 41));
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnSubmit.setBounds(546, 261, 206, 43);
		panel.add(btnSubmit);
		
		jtfMatKhau = new JPasswordField();
		jtfMatKhau.setBounds(546, 185, 208, 37);
		panel.add(jtfMatKhau);
		jtfMatKhau.setColumns(10);
		
		JLabel jlbMatKhau = new JLabel("Mật Khẩu:");
		jlbMatKhau.setFont(new Font("Arial", Font.BOLD, 14));
		jlbMatKhau.setBounds(546, 160, 152, 29);
		panel.add(jlbMatKhau);
		
		JLabel jlbMsg = new JLabel("Vui lòng nhập thông tin đăng nhập!!!");
		jlbMsg.setForeground(new Color(219, 0, 0));
		jlbMsg.setFont(new Font("Tahoma", Font.BOLD, 12));
		jlbMsg.setBounds(546, 314, 247, 22);
		panel.add(jlbMsg);
		
		DangNhapController controller = new DangNhapController(this, btnSubmit, 
                jtfTenDangNhap, jtfMatKhau, jlbMsg);
        controller.setEvent();
        
//        JLabel lblNewLabel_1 = new JLabel("Chưa có tài khoản ?");
//		lblNewLabel_1.setBounds(546, 376, 115, 13);
//		panel.add(lblNewLabel_1);
//        
//    	JButton btnRegister = new JButton("Đăng ký ngay!");
//		btnRegister.setBackground(new Color(0, 255, 64));
//		btnRegister.setFont(new Font("Arial", Font.BOLD, 13));
//		btnRegister.setBounds(546, 399, 214, 29);
//		panel.add(btnRegister);
//
//		btnRegister.addActionListener(new ActionListener() {
//		    public void actionPerformed(ActionEvent e) {
//		        DangKyJDialog dangKyJDialog = new DangKyJDialog();
//		       dangKyJDialog.setLocationRelativeTo(null);
//		        dangKyJDialog.setVisible(true);
//		    }
//		});
		
	}
}
