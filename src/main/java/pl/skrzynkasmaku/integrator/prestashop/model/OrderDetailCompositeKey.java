package pl.skrzynkasmaku.integrator.prestashop.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Bartosz Spychaj
 */
public class OrderDetailCompositeKey implements Serializable {

    protected Integer orderDetailId;
    
    protected Integer orderId;

    public OrderDetailCompositeKey() {
    }

    public OrderDetailCompositeKey(Integer orderDetailId, Integer orderId) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
    }

    

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderDetailCompositeKey)) {
            return false;
        }
        OrderDetailCompositeKey oDetailId = (OrderDetailCompositeKey) obj;

        return Objects.equals(oDetailId.orderId, orderId) && Objects.equals(oDetailId.orderDetailId, orderDetailId);
    }

    @Override
    public int hashCode() {
        return orderId * orderDetailId;
    }

}
