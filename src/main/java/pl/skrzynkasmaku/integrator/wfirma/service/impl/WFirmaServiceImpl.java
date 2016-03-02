package pl.skrzynkasmaku.integrator.wfirma.service.impl;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import pl.skrzynkasmaku.integrator.wfirma.ApiWraper;
import pl.skrzynkasmaku.integrator.wfirma.model.Api;
import pl.skrzynkasmaku.integrator.wfirma.model.Invoice;
import pl.skrzynkasmaku.integrator.wfirma.service.WFirmaService;

/**
 *
 * @author Bartosz Spychaj
 */
public class WFirmaServiceImpl extends WFirmaBaseService implements WFirmaService {

    private static final Logger logger = Logger.getLogger(WFirmaServiceImpl.class.getName());
    private final ApiWraper apiWraper = new ApiWraper();

    @Override
    public void add(Invoice invoice) {
        String methodPath = "invoices/add";
        String fullPath = getPath() + methodPath;
        Api api = apiWraper.wrap(invoice);

        try {
            super.send(fullPath, api);
        } catch (JAXBException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    public void add(String command) {
        String methodPath = "invoices/add";
        String fullPath = getPath() + methodPath;
        super.send(fullPath, command);
    }

}
