package pl.skrzynkasmaku.integrator.wfirma;

import java.math.BigDecimal;
import pl.skrzynkasmaku.integrator.prestashop.model.OrderDetail;
import pl.skrzynkasmaku.integrator.wfirma.model.Invoicecontent;

/**
 *
 * @author Bartosz Spychaj
 */
public class RetailInvoicementFactory extends InvoicementFactory{

    public RetailInvoicementFactory() {
        
    }
    
    

    @Override
    public Invoicecontent build(OrderDetail orderDetail) {
        Invoicecontent invoicecontent = super.build(orderDetail); 
        BigDecimal unitPriceTaxIncl = orderDetail.getUnitPriceTaxIncl();
        invoicecontent.setPrice(unitPriceTaxIncl);
        
        return invoicecontent; 
    }

}
