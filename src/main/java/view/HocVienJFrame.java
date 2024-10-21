package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import Controller.HocVienController;
import model.HocVien;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;

public class HocVienJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfMaHocVien;
	private JTextField jtfHoTen;
	private JTextField jtfSoDienThoai;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public HocVienJFrame(HocVien hocVien) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 751, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 765, 438);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSubmit = new JButton("Lưu dữ liệu");
		btnSubmit.setIcon(new ImageIcon(HocVienJFrame.class.getResource("/Image/save_icon.png")));
		btnSubmit.setBounds(597, 11, 122, 27);
		panel.add(btnSubmit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin h\u1ECDc vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 44, 709, 384);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Sinh Viên:");
		lblNewLabel.setBounds(84, 74, 81, 20);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ Và Tên:");
		lblNewLabel_1.setBounds(84, 124, 67, 20);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ngày Sinh:");
		lblNewLabel_2.setBounds(84, 176, 67, 20);
		panel_1.add(lblNewLabel_2);
		
		 JDateChooser jdcNgaySinh = new JDateChooser();
		 jdcNgaySinh.setDateFormatString("d / MM / y");
	        jdcNgaySinh.setBounds(188, 176, 150, 20);
	        panel_1.add(jdcNgaySinh);

		
		JLabel lblNewLabel_3 = new JLabel("Giới Tính:");
		lblNewLabel_3.setBounds(84, 227, 67, 20);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tình Trạng:");
		lblNewLabel_4.setBounds(84, 276, 67, 20);
		panel_1.add(lblNewLabel_4);
		
		jtfMaHocVien = new JTextField();
		jtfMaHocVien.setBounds(188, 75, 150, 19);
		panel_1.add(jtfMaHocVien);
		jtfMaHocVien.setColumns(10);
		
		jtfHoTen = new JTextField();
		jtfHoTen.setBounds(188, 125, 150, 19);
		panel_1.add(jtfHoTen);
		jtfHoTen.setColumns(10);
		
		JRadioButton jrdNam = new JRadioButton("Nam");
		jrdNam.setBounds(188, 227, 55, 21);
		panel_1.add(jrdNam);
		
		JRadioButton jrdNu = new JRadioButton("Nữ");
		jrdNu.setBounds(258, 227, 55, 21);
		panel_1.add(jrdNu);
		
		  ButtonGroup genderGroup = new ButtonGroup();
	        genderGroup.add(jrdNam);
	        genderGroup.add(jrdNu);
		
		JCheckBox jcbTinhTrang = new JCheckBox("Kích hoạt");
		jcbTinhTrang.setBounds(188, 276, 93, 21);
		panel_1.add(jcbTinhTrang);
		
		JLabel lblNewLabel_5 = new JLabel("Số điện thoại:");
		lblNewLabel_5.setBounds(415, 74, 93, 20);
		panel_1.add(lblNewLabel_5);
		
		jtfSoDienThoai = new JTextField();
		jtfSoDienThoai.setBounds(504, 75, 150, 19);
		panel_1.add(jtfSoDienThoai);
		jtfSoDienThoai.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Địa chỉ:");
		lblNewLabel_6.setBounds(415, 128, 45, 13);
		panel_1.add(lblNewLabel_6);
		
		JTextArea jtaDiaChi = new JTextArea();
		jtaDiaChi.setBackground(new Color(192, 192, 192));
		jtaDiaChi.setFont(new Font("Monospaced", Font.PLAIN, 13));
		jtaDiaChi.setBounds(504, 122, 198, 148);
		panel_1.add(jtaDiaChi);
		
		JLabel jlbMsg = new JLabel("...");
		jlbMsg.setForeground(new Color(255, 0, 0));
		jlbMsg.setFont(new Font("Arial", Font.BOLD, 14));
		jlbMsg.setBounds(10, 17, 296, 13);
		panel.add(jlbMsg);
		
		
		HocVienController controller = new HocVienController(btnSubmit, jtfMaHocVien, jtfHoTen, jdcNgaySinh, jrdNam, jrdNu, jtfSoDienThoai, jtaDiaChi, jcbTinhTrang, jlbMsg);
		controller.setView(hocVien);
		controller.setEvent();
	}



}
