package Main;

import view.DangNhapJDialog;

public class Run {
    public static void main(String[] args) {
        DangNhapJDialog dialog = new DangNhapJDialog(null, true);
        dialog.setTitle("ĐĂNG NHẬP HỆ THỐNG");
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
