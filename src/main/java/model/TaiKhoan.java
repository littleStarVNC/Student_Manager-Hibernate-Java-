package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tai_khoan")
public class TaiKhoan {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ma_tai_khoan")
	    private int maTaiKhoan;
	    
	    @Column(name = "ten_dang_nhap")
	    private String tenDangNhap;
	    
	    @Column(name = "mat_khau")
	    private String matKhau;
	    
	    @Column(name = "tinh_trang")
	    private boolean tinhTrang;
		public int getMaTaiKhoan() {
			return maTaiKhoan;
		}

		public void setMaTaiKhoan(int maTaiKhoan) {
			this.maTaiKhoan = maTaiKhoan;
		}

		public String getTenDangNhap() {
			return tenDangNhap;
		}

		public void setTenDangNhap(String tenDangNhap) {
			this.tenDangNhap = tenDangNhap;
		}

		public String getMatKhau() {
			return matKhau;
		}

		public void setMatKhau(String matKhau) {
			this.matKhau = matKhau;
		}

		public boolean isTinhTrang() {
			return tinhTrang;
		}

		public void setTinhTrang(boolean tinhTrang) {
			this.tinhTrang = tinhTrang;
		}

    
}