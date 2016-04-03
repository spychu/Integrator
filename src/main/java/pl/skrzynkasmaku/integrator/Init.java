package pl.skrzynkasmaku.integrator;

import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.skrzynkasmaku.integrator.prestashop.model.Address;
import pl.skrzynkasmaku.integrator.prestashop.model.Order;
import pl.skrzynkasmaku.integrator.prestashop.model.OrderDetail;
/**
 * Komentarz testowy linia 1
 * Komentarz testowy linia 2B
 * Komentarz testowy linia 3
 */
/**
 *
 * @author Bartosz Spychaj
 */
public class Init {

    private static final Logger logger = Logger.getLogger(Init.class.getName());

    public static void main(String... args) {
        logger.info(new Object().toString());

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("From Address ");
        List<Address> resultList = q.list();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Addresses size: ").append(resultList.size());
        logger.info(stringBuilder.toString());
        q = session.createQuery("From Order as ord where ord.reference like 'WFCBCYRRM'");
        List<Order> orders = q.list();
        stringBuilder = new StringBuilder();
        stringBuilder.append("Orders size: ").append(orders.size());
        logger.info(stringBuilder.toString());
        for (Order order : orders) {
            Address delivery = order.getDeliveryAddress();
            String city = delivery.getCity();
            stringBuilder = new StringBuilder();
            stringBuilder.append("address: ").append(city);
            logger.info(stringBuilder.toString());
        }
        q = session.createQuery("From OrderDetail as ords where ords.orderId like '1'");
        List<OrderDetail> details = q.list();
        stringBuilder = new StringBuilder();
        stringBuilder.append("OrderDetail size: ").append(details.size());
        logger.info(stringBuilder.toString());

    }
}
