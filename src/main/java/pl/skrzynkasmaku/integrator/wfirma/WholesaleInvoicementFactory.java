package pl.skrzynkasmaku.integrator.wfirma;

import java.math.BigDecimal;
import pl.skrzynkasmaku.integrator.prestashop.model.OrderDetail;
import pl.skrzynkasmaku.integrator.prestashop.model.Product;
import pl.skrzynkasmaku.integrator.wfirma.model.Invoicecontent;

/**
 *
 * @author Bartosz Spychaj
 */
public class WholesaleInvoicementFactory extends InvoicementFactory {

    private final BigDecimal margin;

    public WholesaleInvoicementFactory(BigDecimal margin) {
        this.margin = margin;
    }

    @Override
    public Invoicecontent build(OrderDetail orderDetail) {
        Invoicecontent invoicecontent = super.build(orderDetail);
        Product product = orderDetail.getProduct();
        BigDecimal wholesalePrice = product.getWholesalePrice();
        BigDecimal price = wholesalePrice.multiply(margin);
        invoicecontent.setPrice(price);

        return invoicecontent;
    }

}
