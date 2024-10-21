package Controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import model.HocVien;
import service.HocVienService;
import service.HocVienServiceImpl;

public class HocVienController {

    private JButton btnSubmit;
    private JTextField jtfMaHocVien;
    private JTextField jtfHoTen;
    private JDateChooser jdcNgaySinh;
    private JRadioButton jrdNam;
    private JRadioButton jrdNu;
    private JTextField jtfSoDienThoai;
    private JTextArea jtaDiaChi;
    private JCheckBox jcbTinhTrang;
    private HocVien hocVien = null;
    private HocVienService hocVienService = null;
    private JLabel jlbMsg;

    public HocVienController(JButton btnSubmit, JTextField jtfMaHocVien, JTextField jtfHoTen, JDateChooser jdcNgaySinh,
                             JRadioButton jrdNam, JRadioButton jrdNu, JTextField jtfSoDienThoai, JTextArea jtaDiaChi,
                             JCheckBox jcbTinhTrang, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfMaHocVien = jtfMaHocVien;
        this.jtfHoTen = jtfHoTen;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jrdNam = jrdNam;
        this.jrdNu = jrdNu;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtaDiaChi = jtaDiaChi;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbMsg = jlbMsg;
        this.hocVienService = new HocVienServiceImpl();
    }

    public void setView(HocVien hocVien) {
        this.hocVien = hocVien;
        jtfMaHocVien.setText("#" + hocVien.getMaHocVien());
        jtfHoTen.setText(hocVien.getHoTen());
        jdcNgaySinh.setDate(hocVien.getNgaySinh());
        if (hocVien.isGioiTinh()) {
            jrdNam.setSelected(true);
            jrdNu.setSelected(false);
        } else {
            jrdNam.setSelected(false);
            jrdNu.setSelected(true);
        }
        jtfSoDienThoai.setText(hocVien.getSoDienThoai());
        jtaDiaChi.setText(hocVien.getDiaChi());
        jcbTinhTrang.setSelected(hocVien.isTinhTrang());
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfHoTen.getText().length() == 0 || jdcNgaySinh.getDate() == null) {
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                } else {
                    hocVien.setHoTen(jtfHoTen.getText());
                    Date utilDate = jdcNgaySinh.getDate();
                    if (utilDate != null) {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        hocVien.setNgaySinh(sqlDate);
                    }
                    hocVien.setGioiTinh(jrdNam.isSelected());
                    hocVien.setSoDienThoai(jtfSoDienThoai.getText());
                    hocVien.setDiaChi(jtaDiaChi.getText());
                    hocVien.setTinhTrang(jcbTinhTrang.isSelected());
                    int lastId = hocVienService.createOrUpdate(hocVien);
                    if (lastId > 0) {
                        hocVien.setMaHocVien(lastId);
                        jtfMaHocVien.setText("#" + lastId);
                        jlbMsg.setText("Cập nhật dữ liệu thành công!");
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }
        });
    }
}
