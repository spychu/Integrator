package pl.skrzynkasmaku.integrator;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import pl.skrzynkasmaku.integrator.wfirma.model.Api;
import pl.skrzynkasmaku.integrator.wfirma.model.Contractor;
import pl.skrzynkasmaku.integrator.wfirma.model.Invoice;
import pl.skrzynkasmaku.integrator.wfirma.model.Invoicecontent;
import pl.skrzynkasmaku.integrator.wfirma.model.TaxIdType;

/**
 *
 * @author Bartosz Spychaj
 */
public class JaxbInit {

    private static final Logger logger = Logger.getLogger(JaxbInit.class.getName());

    public static void main(String[] args) {

        logger.info(TaxIdType.CUSTOM.toString());
        
        Api api = new Api();
        List<Invoice> invoices = new ArrayList<>();
        Invoice invoice = new Invoice();
        Invoicecontent invoicecontent = new Invoicecontent();
        invoicecontent.setPrice(BigDecimal.valueOf(1.23d));
        List<Invoicecontent> invoicecontents = new ArrayList<>();
        invoicecontents.add(invoicecontent);
        invoice.setInvoicecontents(invoicecontents);
        Contractor contractor = new Contractor();
        contractor.setCity("Wieczyn");
        contractor.setName("Jan Kowalski");
        contractor.setNip(null);
        contractor.setZip("63-304");
        invoice.setContractor(contractor);
        invoices.add(invoice);
        
        api.setInvoices(invoices);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Api.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(api, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
