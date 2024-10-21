package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.SessionFactory;

import Controller.ChuyenManHinhController;
import bean.DanhMucBean;
import model.TaiKhoan;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.List;
import java.awt.Toolkit;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jpnRoot;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param sessionFactory 
	 */
	public MainFrame(TaiKhoan taiKhoan) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/Image/top-phan-mem-quan-ly-hoc-sinh.jpg")));
		
	        setTitle("QUẢN LÝ HỌC VIÊN");
	        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 1266, 669);
		jpnRoot = new JPanel();
		jpnRoot.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(jpnRoot);
		jpnRoot.setLayout(null);
		
		
		JPanel jpnView = new JPanel();
		jpnView.setForeground(new Color(0, 0, 0));
		jpnView.setBounds(334, 10, 920, 625);
		jpnRoot.add(jpnView);
		
		JPanel jpnMenu = new JPanel();
		jpnMenu.setBackground(new Color(192, 192, 192));
		jpnMenu.setBounds(10, 10, 321, 625);
		jpnMenu.setLayout(null);
		jpnRoot.add(jpnMenu);
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("");
		panel_2.setBackground(new Color(255, 0, 0));
		panel_2.setBounds(0, 0, 321, 106);
		jpnMenu.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản lý học viên");
		lblNewLabel.setBounds(0, 10, 290, 96);
		panel_2.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(0, 191, 0));
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/Image/manage_accounts_24dp.png")));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		
		JPanel jpnTrangChu = new JPanel();
		jpnTrangChu.setBackground(new Color(0, 191, 0));
		jpnTrangChu.setForeground(new Color(0, 255, 0));
		jpnTrangChu.setBounds(10, 116, 301, 70);
		jpnMenu.add(jpnTrangChu);
		jpnTrangChu.setLayout(null);
		
		JLabel jlbTrangChu = new JLabel("Màn Hình Chính");
		jlbTrangChu.setIcon(new ImageIcon(MainFrame.class.getResource("/Image/main display.png")));
		jlbTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		jlbTrangChu.setFont(new Font("Arial", Font.PLAIN, 23));
		jlbTrangChu.setBounds(-14, 10, 281, 50);
		jpnTrangChu.add(jlbTrangChu);
		
		JPanel jpnHocVien = new JPanel();
		jpnHocVien.setBackground(new Color(0, 191, 0));
		jpnHocVien.setBounds(10, 196, 301, 70);
		jpnMenu.add(jpnHocVien);
		jpnHocVien.setLayout(null);
		
		JLabel jlbHocVien = new JLabel("Quản lý học viên");
		jlbHocVien.setIcon(new ImageIcon(MainFrame.class.getResource("/Image/groups_20dp.png")));
		jlbHocVien.setFont(new Font("Arial", Font.PLAIN, 24));
		jlbHocVien.setBounds(10, 10, 281, 50);
		jpnHocVien.add(jlbHocVien);
		
		JPanel jpnKhoaHoc = new JPanel();
		jpnKhoaHoc.setBackground(new Color(0, 191, 0));
		jpnKhoaHoc.setBounds(10, 276, 301, 70);
		jpnMenu.add(jpnKhoaHoc);
		jpnKhoaHoc.setLayout(null);
		
		JLabel jlbKhoaHoc = new JLabel("Gửi Thông Báo");
		jlbKhoaHoc.setIcon(new ImageIcon(MainFrame.class.getResource("/Image/COURSE.png")));
		jlbKhoaHoc.setFont(new Font("Arial", Font.PLAIN, 24));
		jlbKhoaHoc.setBounds(10, 10, 274, 50);
		jpnKhoaHoc.add(jlbKhoaHoc);
		
		JPanel jpnLopHoc = new JPanel();
		jpnLopHoc.setBackground(new Color(0, 191, 0));
		jpnLopHoc.setBounds(10, 436, 301, 70);
		jpnMenu.add(jpnLopHoc);
		jpnLopHoc.setLayout(null);
		
		JLabel jlbLopHoc = new JLabel("Giải Trí");
		jlbLopHoc.setIcon(new ImageIcon(MainFrame.class.getResource("/Image/class_20dp.png")));
		jlbLopHoc.setFont(new Font("Arial", Font.PLAIN, 24));
		jlbLopHoc.setBounds(10, 10, 276, 50);
		jpnLopHoc.add(jlbLopHoc);
		
		JPanel jpnThongKe = new JPanel();
		jpnThongKe.setBackground(new Color(0, 191, 0));
		jpnThongKe.setBounds(10, 356, 301, 70);
		jpnMenu.add(jpnThongKe);
		jpnThongKe.setLayout(null);
		
		JLabel jlbThongKe = new JLabel("Thống kê dữ liệu");
		jlbThongKe.setIcon(new ImageIcon(MainFrame.class.getResource("/Image/statictis.png")));
		jlbThongKe.setFont(new Font("Arial", Font.PLAIN, 24));
		jlbThongKe.setBounds(10, 10, 264, 50);
		jpnThongKe.add(jlbThongKe);
		
		JLabel lblNewLabel_1 = new JLabel("CườngVn-23CE009");
		lblNewLabel_1.setIcon(new ImageIcon(MainFrame.class.getResource("/Image/logo vku.png")));
		lblNewLabel_1.setForeground(new Color(221, 141, 70));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 23));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(24, 593, 269, 22);
		jpnMenu.add(lblNewLabel_1);
		
				 ChuyenManHinhController controller = new ChuyenManHinhController(jpnView);
	             controller.setView(jpnTrangChu, jlbTrangChu);
	             
	             List <DanhMucBean> listItem = new ArrayList<>();
	             listItem.add(new DanhMucBean("TrangChu", jpnTrangChu , jlbTrangChu));
	             listItem.add(new DanhMucBean("HocVien", jpnHocVien , jlbHocVien));
	             listItem.add(new DanhMucBean("KhoaHoc", jpnKhoaHoc , jlbKhoaHoc));
	             listItem.add(new DanhMucBean("LopHoc", jpnLopHoc , jlbLopHoc));
	             listItem.add(new DanhMucBean("ThongKe", jpnThongKe , jlbThongKe ));
	             
	             controller.setEvent(listItem);

	}
}
