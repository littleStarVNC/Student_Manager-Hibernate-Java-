package model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "lop_hoc")
public class LopHoc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_lop_hoc")
    private int maLopHoc;

    @ManyToOne
    @JoinColumn(name = "ma_khoa_hoc")
    private KhoaHoc khoaHoc;

    @ManyToOne
    @JoinColumn(name = "ma_hoc_vien")
    private HocVien hocVien;

    @Column(name = "ngay_dang_ky")
    private Date ngayDangKy;

    @Column(name = "tinh_trang")
    private boolean tinhTrang;

    // Getters và Setters

    public int getMaLopHoc() {
        return maLopHoc;
    }

    public void setMaLopHoc(int maLopHoc) {
        this.maLopHoc = maLopHoc;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public HocVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
