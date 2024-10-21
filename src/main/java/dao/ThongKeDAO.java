package dao;

import bean.KhoaHocBean;
import bean.LopHocBean;
import java.util.List;

public interface ThongKeDAO {
    
    List<LopHocBean> getListByLopHoc();
    
    List<KhoaHocBean> getListByKhoaHoc();
}
