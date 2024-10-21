package Utility;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;
import Utility.HibernateUtil;
import model.TaiKhoan;

import java.util.List;

public class PasswordEncryptionUtil {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            List<TaiKhoan> taiKhoans = session.createQuery("FROM TaiKhoan", TaiKhoan.class).list();

            for (TaiKhoan taiKhoan : taiKhoans) {
                String hashedPassword = BCrypt.hashpw(taiKhoan.getMatKhau(), BCrypt.gensalt());
                taiKhoan.setMatKhau(hashedPassword);
                session.update(taiKhoan);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
