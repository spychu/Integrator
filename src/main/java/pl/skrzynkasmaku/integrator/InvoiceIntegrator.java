package pl.skrzynkasmaku.integrator;

import pl.skrzynkasmaku.integrator.dao.OrderDao;
import pl.skrzynkasmaku.integrator.dao.impl.OrderDaoImpl;
import pl.skrzynkasmaku.integrator.prestashop.model.Order;
import pl.skrzynkasmaku.integrator.reference.Reference;
import pl.skrzynkasmaku.integrator.wfirma.InvoiceFactory;
import pl.skrzynkasmaku.integrator.wfirma.InvoiceFactoryProducer;
import pl.skrzynkasmaku.integrator.wfirma.model.Invoice;
import pl.skrzynkasmaku.integrator.wfirma.service.WFirmaService;
import pl.skrzynkasmaku.integrator.wfirma.service.impl.WFirmaServiceImpl;

/**
 *
 * @author Bartosz Spychaj
 */
public class InvoiceIntegrator {

    private final OrderDao orderDao = new OrderDaoImpl();
    private final WFirmaService wFirmaService = new WFirmaServiceImpl();

    public void integrateByReference(Reference reference) {
        Order order = orderDao.findByReference(reference.getText());
        InvoiceFactory invoiceFactory = InvoiceFactoryProducer.getFactory(reference);
        Invoice invoice = invoiceFactory.build(order);
        wFirmaService.add(invoice);
    }

    public void add(String command) {
        wFirmaService.add(command);
    }
}
