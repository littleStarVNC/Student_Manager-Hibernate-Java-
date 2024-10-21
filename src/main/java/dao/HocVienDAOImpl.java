package dao;

import model.HocVien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HocVienDAOImpl implements HocVienDAO {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public List<HocVien> getList() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM HocVien", HocVien.class).list();
        }
    }

    @Override
    public int createOrUpdate(HocVien hocVien) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            if (hocVien.getMaHocVien() != 0) {
                session.update(hocVien);
            } else {
                session.save(hocVien);
            }
            transaction.commit();
            return hocVien.getMaHocVien();
        } catch (Exception ex) {
            if (transaction != null) transaction.rollback();
            ex.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            HocVien hocVien = session.get(HocVien.class, id);
            if (hocVien != null) {
                session.delete(hocVien);
                transaction.commit();
                return 1; // Xóa thành công
            } else {
                return 0; // Không tìm thấy học viên để xóa
            }
        } catch (Exception ex) {
            if (transaction != null) transaction.rollback();
            ex.printStackTrace();
            return -1; // Lỗi xóa
        }
    }
}
