package pl.skrzynkasmaku.integrator.utils;

/**
 *
 * @author Bartosz Spychaj
 */
import java.io.File;
import java.util.logging.Level;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author leonidas
 */
public class HibernateUtils {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(HibernateUtils.class.getName());
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().
                    configure(new File(PropertiesUtils.getAbsoluePath(IntegratorUtils.HIBERNATE_FILE))).
                    buildSessionFactory();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSession() {
        sessionFactory.getCurrentSession().close();
    }

    public static Session getCurrentSession() {
        Session hibernateSession = sessionFactory.getCurrentSession();

        return hibernateSession;
    }

    public static Session openSession() {
        Session hibernateSession = sessionFactory.openSession();

        return hibernateSession;
    }
}
