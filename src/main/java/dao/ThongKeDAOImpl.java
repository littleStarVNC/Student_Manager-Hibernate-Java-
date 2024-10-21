package dao;

import bean.KhoaHocBean;
import bean.LopHocBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import Utility.HibernateUtil;

import java.util.List;

public class ThongKeDAOImpl implements ThongKeDAO {
    private SessionFactory sessionFactory;

    public ThongKeDAOImpl() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<LopHocBean> getListByLopHoc() {
        List<LopHocBean> list = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT new bean.LopHocBean(l.ngayDangKy, COUNT(l.maLopHoc)) " +
                    "FROM model.LopHoc l GROUP BY l.ngayDangKy";

            Query<LopHocBean> query = session.createQuery(hql, LopHocBean.class);
            list = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<KhoaHocBean> getListByKhoaHoc() {
        List<KhoaHocBean> list = null;
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT new bean.KhoaHocBean(k.tenKhoaHoc, k.ngayBatDau, k.ngayKetThuc) " +
                    "FROM model.KhoaHoc k WHERE k.tinhTrang = true ORDER BY k.ngayBatDau ASC";

            Query<KhoaHocBean> query = session.createQuery(hql, KhoaHocBean.class);
            list = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}
