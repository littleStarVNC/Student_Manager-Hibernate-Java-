package bean;

import java.util.Date;

public class LopHocBean {
    private Date ngay_dang_ky;
    private long so_luong_hoc_vien;

    public LopHocBean() {
    }

    public LopHocBean(Date ngay_dang_ky, long so_luong_hoc_vien) {
        this.ngay_dang_ky = ngay_dang_ky;
        this.so_luong_hoc_vien = so_luong_hoc_vien;
    }

    public Date getNgay_dang_ky() {
        return ngay_dang_ky;
    }

    public void setNgay_dang_ky(Date ngay_dang_ky) {
        this.ngay_dang_ky = ngay_dang_ky;
    }

    public long getSo_luong_hoc_vien() {
        return so_luong_hoc_vien;
    }

    public void setSo_luong_hoc_vien(long so_luong_hoc_vien) {
        this.so_luong_hoc_vien = so_luong_hoc_vien;
    }
}
