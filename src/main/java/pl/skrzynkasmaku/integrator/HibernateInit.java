package pl.skrzynkasmaku.integrator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import pl.skrzynkasmaku.integrator.dao.OrderDao;
import pl.skrzynkasmaku.integrator.dao.impl.OrderDaoImpl;
import pl.skrzynkasmaku.integrator.prestashop.model.Order;

/**
 *
 * @author Bartosz Spychaj
 */
public class HibernateInit {
    
    public static void main(String... args) {
        String reference = "WFCBCYRRM";
        OrderDao orderDao = new OrderDaoImpl();
        
        for (int i = 0; i < 122; i++) {
            Order order = orderDao.findByReference(reference);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Reference read: ").append(reference).append(", ").append(order.getId()).append(".");
            LogManager.getLogger(ServiceInit.class).log(Level.INFO, stringBuilder);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Processing terminated.");
        LogManager.getLogger(ServiceInit.class).log(Level.INFO, stringBuilder);
    }
}
