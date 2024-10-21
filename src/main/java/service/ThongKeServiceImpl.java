package service;
import java.util.List;

import bean.KhoaHocBean;
import bean.LopHocBean;
import dao.ThongKeDAO;
import dao.ThongKeDAOImpl;

public class ThongKeServiceImpl implements ThongKeService {

    private ThongKeDAO thongKeDAO = null;

    public ThongKeServiceImpl() {
        this.thongKeDAO = new ThongKeDAOImpl();
    }

    @Override
    public List<LopHocBean> getListByLopHoc() {
        return thongKeDAO.getListByLopHoc();
    }

    @Override
    public List<KhoaHocBean> getListByKhoaHoc() {
        return thongKeDAO.getListByKhoaHoc();
    }

}