package pl.skrzynkasmaku.integrator.wfirma;

import pl.skrzynkasmaku.integrator.prestashop.model.Order;
import pl.skrzynkasmaku.integrator.wfirma.model.Invoice;
import pl.skrzynkasmaku.integrator.wfirma.model.PriceType;

/**
 *
 * @author Bartosz Spychaj
 */
public class RetailInvoiceFactory extends InvoiceFactory {

    public RetailInvoiceFactory() {
        setInvoicementFactory(new RetailInvoicementFactory());
    }

    @Override
    public Invoice build(Order order) {
        Invoice invoice = super.build(order);
        invoice.setPriceType(PriceType.Brutto.toString());

        return invoice;
    }

}
