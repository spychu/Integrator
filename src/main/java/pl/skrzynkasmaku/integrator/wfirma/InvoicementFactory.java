package pl.skrzynkasmaku.integrator.wfirma;

import pl.skrzynkasmaku.integrator.prestashop.model.OrderDetail;
import pl.skrzynkasmaku.integrator.wfirma.model.Invoicecontent;
import pl.skrzynkasmaku.integrator.wfirma.model.VatCode;

/**
 *
 * @author Bartosz Spychaj
 */
public abstract class InvoicementFactory {

    public Invoicecontent build(OrderDetail orderDetail) {
        String productName = orderDetail.getProducName();
        Integer productQuantity = orderDetail.getProductQuantity();
        Integer idTaxRulesGroup = orderDetail.getIdTaxRulesGroup();
        Invoicecontent invoicecontent = new Invoicecontent();
        invoicecontent.setName(productName);
        invoicecontent.setCount(productQuantity);
        VatCode vatCode = InvoiceFactory.convert(idTaxRulesGroup);
        invoicecontent.setVatCode(vatCode);
        
        return invoicecontent;
    }
}
