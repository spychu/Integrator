package pl.skrzynkasmaku.integrator.wfirma;

import java.math.BigDecimal;
import pl.skrzynkasmaku.integrator.reference.Reference;

/**
 *
 * @author Bartosz Spychaj
 */
public class InvoiceFactoryProducer {

    public static InvoiceFactory getFactory(Reference reference) {

        InvoiceFactory invoiceFactory;
        if (reference.isWholesale()) {
            BigDecimal margin = reference.getMargin();
            invoiceFactory = new WholesailInvoiceFactory(margin);
        } else {
            invoiceFactory = new RetailInvoiceFactory();
        }
        return invoiceFactory;
    }
}
