package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import Utility.HibernateUtil;
import model.TaiKhoan;
import dao.TaiKhoanDAO;

public class TaiKhoanDAOImpl implements TaiKhoanDAO {

    @Override
    public TaiKhoan login(String tenDangNhap) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM TaiKhoan WHERE tenDangNhap = :tenDangNhap";
            Query<TaiKhoan> query = session.createQuery(hql, TaiKhoan.class);
            query.setParameter("tenDangNhap", tenDangNhap);
            TaiKhoan taiKhoan = query.uniqueResult();
            return taiKhoan;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
//    @Override
//    public void saveTaiKhoan(TaiKhoan taiKhoan) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            session.save(taiKhoan);
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }

}
