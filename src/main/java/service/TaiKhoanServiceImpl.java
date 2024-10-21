package service;

import dao.TaiKhoanDAO;
import dao.TaiKhoanDAOImpl;
import model.TaiKhoan;
import org.mindrot.jbcrypt.BCrypt;
import service.TaiKhoanService;

public class TaiKhoanServiceImpl implements TaiKhoanService {
    private TaiKhoanDAO taiKhoanDAO;

    public TaiKhoanServiceImpl() {
        taiKhoanDAO = new TaiKhoanDAOImpl();
    }

    @Override
    public TaiKhoan login(String tenDangNhap, String matKhau) {
        TaiKhoan taiKhoan = taiKhoanDAO.login(tenDangNhap);
        if (taiKhoan != null && BCrypt.checkpw(matKhau, taiKhoan.getMatKhau())) {
            return taiKhoan;
        }
        return null;
    }
    
//    public TaiKhoan register(String tenDangNhap, String matKhau) {
//        TaiKhoan newTaiKhoan = new TaiKhoan();
//        newTaiKhoan.setTenDangNhap(tenDangNhap);
//        newTaiKhoan.setMatKhau(BCrypt.hashpw(matKhau, BCrypt.gensalt()));
//        newTaiKhoan.setTinhTrang(true); // Set default status to active
//
//        taiKhoanDAO.saveTaiKhoan(newTaiKhoan);
//		return newTaiKhoan;
//    }

}
