package pl.skrzynkasmaku.integrator.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.skrzynkasmaku.integrator.dao.OrderDao;
import pl.skrzynkasmaku.integrator.prestashop.model.Order;

/**
 *
 * @author Bartosz Spychaj
 */
public class OrderDaoImpl extends GenericDaoImpl<Order, Integer> implements OrderDao {

    @Override
    public Order findByReference(String reference) {

        String hql = "From Order as ord where ord.reference = :reference";
        Order order;
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(hql).setParameter("reference", reference);
            order = findOne(query);
            transaction.commit();
        }
        
        return order;
    }
}
