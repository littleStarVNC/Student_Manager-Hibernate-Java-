package service;

import model.HocVien;
import java.util.List;

public interface HocVienService {
    List<HocVien> getList();
    int createOrUpdate(HocVien hocVien);
    int delete(int id); // Thêm phương thức delete
}
