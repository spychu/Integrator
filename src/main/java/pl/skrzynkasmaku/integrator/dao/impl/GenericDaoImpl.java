package pl.skrzynkasmaku.integrator.dao.impl;

/**
 *
 * @author Bartosz Spychaj
 */
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pl.skrzynkasmaku.integrator.dao.GenericDAO;
import pl.skrzynkasmaku.integrator.utils.HibernateUtils;

/**
 *
 * @author leonidas
 * @param <T>
 * @param <ID>
 */
public abstract class GenericDaoImpl<T, ID extends Integer> implements GenericDAO<T, ID> {

    protected Session getCurrentSession() {
        return HibernateUtils.getCurrentSession();
    }

    protected Session openSession() {
        return HibernateUtils.openSession();
    }

    protected void closeSession() {
        HibernateUtils.closeSession();
    }

    @Override
    public List<T> findMany(Query query) {
        List<T> t = (List<T>) query.list();
        return t;
    }

    @Override
    public T findOne(Query query) {
        T t = (T) query.uniqueResult();
        return t;
    }

    @Override
    public T findByID(Class clazz, Integer id) {
        Session hibernateSession = this.openSession();
        T t = (T) hibernateSession.get(clazz, id);
        return t;
    }

    @Override
    public List findAll(Class clazz) {
        Session hibernateSession = this.openSession();
        Query query = hibernateSession.createQuery("from " + clazz.getName());
        List T = query.list();
        return T;
    }
}
