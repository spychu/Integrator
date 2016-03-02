package pl.skrzynkasmaku.integrator.dao;

import pl.skrzynkasmaku.integrator.prestashop.model.Order;

/**
 *
 * @author Spychu
 */
public interface OrderDao extends GenericDAO<Order, Integer> {

    public Order findByReference(String reference);
}
