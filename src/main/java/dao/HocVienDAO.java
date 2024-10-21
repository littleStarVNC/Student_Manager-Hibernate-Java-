package dao;

import java.util.List;

import model.HocVien;

public interface HocVienDAO {
    List<HocVien> getList();
    int createOrUpdate(HocVien hocVien);
    int delete(int id);
}
