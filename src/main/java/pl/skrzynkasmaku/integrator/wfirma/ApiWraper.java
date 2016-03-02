package pl.skrzynkasmaku.integrator.wfirma;

import java.util.ArrayList;
import java.util.List;
import pl.skrzynkasmaku.integrator.wfirma.model.Api;
import pl.skrzynkasmaku.integrator.wfirma.model.Invoice;

/**
 *
 * @author Bartosz Spychaj
 */
public class ApiWraper {

    public Api wrap(Invoice invoice) {
        Api api = new Api();
        List<Invoice> invoices = new ArrayList<>(1);
        invoices.add(invoice);
        api.setInvoices(invoices);
        
        return api;
    }
}
