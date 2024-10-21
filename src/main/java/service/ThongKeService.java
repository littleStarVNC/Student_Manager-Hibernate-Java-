package service;
import java.util.List;

import bean.KhoaHocBean;
import bean.LopHocBean;

public interface ThongKeService {
    
     List<LopHocBean> getListByLopHoc();
    
     List<KhoaHocBean> getListByKhoaHoc();
    
}