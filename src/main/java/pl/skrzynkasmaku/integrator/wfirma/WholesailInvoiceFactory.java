package pl.skrzynkasmaku.integrator.wfirma;

import java.math.BigDecimal;
import pl.skrzynkasmaku.integrator.prestashop.model.Order;
import pl.skrzynkasmaku.integrator.wfirma.model.Invoice;
import pl.skrzynkasmaku.integrator.wfirma.model.PriceType;

/**
 *
 * @author Bartosz Spychaj
 */
public class WholesailInvoiceFactory extends InvoiceFactory {

    public WholesailInvoiceFactory(BigDecimal margin) {
        setInvoicementFactory(new WholesaleInvoicementFactory(margin));
    }

    @Override
    public Invoice build(Order order) {
        Invoice invoice = super.build(order);
        invoice.setPriceType(PriceType.Netto.toString());

        return invoice;
    }

}
