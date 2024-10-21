package service;

import dao.HocVienDAO;
import dao.HocVienDAOImpl;
import model.HocVien;
import java.util.List;

public class HocVienServiceImpl implements HocVienService {

    private HocVienDAO hocVienDAO;

    public HocVienServiceImpl() {
        hocVienDAO = new HocVienDAOImpl();
    }

    @Override
    public List<HocVien> getList() {
        return hocVienDAO.getList();
    }

    @Override
    public int createOrUpdate(HocVien hocVien) {
        return hocVienDAO.createOrUpdate(hocVien);
    }

    @Override
    public int delete(int id) {
        return hocVienDAO.delete(id);
    }
}
