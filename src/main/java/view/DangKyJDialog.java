package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import Controller.DangKyController;

public class DangKyJDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    private JTextField jtfTenDangNhap;
    private JPasswordField jtfMatKhau;

    public DangKyJDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/Image/top-phan-mem-quan-ly-hoc-sinh.jpg")));

        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 255));
        panel.setBounds(0, 0, 450, 300);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel jlbTenDangNhap = new JLabel("Tên Đăng Nhập:");
        jlbTenDangNhap.setFont(new Font("Arial", Font.BOLD, 14));
        jlbTenDangNhap.setBounds(46, 60, 130, 29);
        panel.add(jlbTenDangNhap);

        jtfTenDangNhap = new JTextField();
        jtfTenDangNhap.setBounds(186, 60, 208, 37);
        panel.add(jtfTenDangNhap);
        jtfTenDangNhap.setColumns(10);

        JLabel jlbMatKhau = new JLabel("Mật Khẩu:");
        jlbMatKhau.setFont(new Font("Arial", Font.BOLD, 14));
        jlbMatKhau.setBounds(46, 120, 130, 29);
        panel.add(jlbMatKhau);

        jtfMatKhau = new JPasswordField();
        jtfMatKhau.setBounds(186, 120, 208, 37);
        panel.add(jtfMatKhau);

        JLabel jlbMsg = new JLabel("Vui lòng nhập thông tin đăng ký!!!");
        jlbMsg.setForeground(new Color(219, 0, 0));
        jlbMsg.setFont(new Font("Tahoma", Font.BOLD, 12));
        jlbMsg.setBounds(46, 210, 348, 22);
        panel.add(jlbMsg);

        JButton btnSubmit = new JButton("Đăng Ký");
        btnSubmit.setForeground(new Color(255, 255, 255));
        btnSubmit.setFont(new Font("Arial", Font.BOLD, 13));
        btnSubmit.setBackground(new Color(0, 164, 41));
        btnSubmit.setBounds(186, 170, 206, 43);
        panel.add(btnSubmit);

        DangKyController controller = new DangKyController(this, btnSubmit, jtfTenDangNhap, jtfMatKhau, jlbMsg);
//        controller.setEvent();
    }
}
