package Controller;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.TaiKhoan;
import service.TaiKhoanService;
import service.TaiKhoanServiceImpl;

public class DangKyController {

    private Dialog dialog;
    private JButton btnSubmit;
    private JTextField jtfTenDangNhap;
    private JTextField jtfMatKhau;
    private JLabel jlbMsg;

    private TaiKhoanService taiKhoanService = null;

    public DangKyController(Dialog dialog, JButton btnSubmit,
            JTextField jtfTenDangNhap, JTextField jtfMatKhau, JLabel jlbMsg) {
        this.dialog = dialog;
        this.btnSubmit = btnSubmit;
        this.jtfTenDangNhap = jtfTenDangNhap;
        this.jtfMatKhau = jtfMatKhau;
        this.jlbMsg = jlbMsg;

        taiKhoanService = new TaiKhoanServiceImpl();
    }

//    public void setEvent() {
//        btnSubmit.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                try {
//                    if (jtfTenDangNhap.getText().length() == 0 || jtfMatKhau.getText().length() == 0) {
//                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
//                    } else {
//                    	 TaiKhoan taiKhoan = ((TaiKhoanServiceImpl) taiKhoanService).register(jtfTenDangNhap.getText(), jtfMatKhau.getText());
//                         if (taiKhoan != null) {
//                             jlbMsg.setText("Đăng ký thành công!");
//                         } else {
//                             jlbMsg.setText("Đăng ký thất bại!");
//                         }
//                    }
//                } catch (Exception ex) {
//                    jlbMsg.setText("Đăng ký thất bại: " + ex.toString());
//                }
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                btnSubmit.setBackground(new Color(0, 200, 83));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                btnSubmit.setBackground(new Color(100, 221, 23));
//            }
//        });
//    }
}
