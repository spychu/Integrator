package pl.skrzynkasmaku.integrator.wfirma.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bartosz Spychaj
 */
@XmlRootElement
public class Api implements Serializable{

    private List<Invoice> invoices = new ArrayList<>();

    @XmlElementWrapper(name = "invoices")
    @XmlElement(name = "invoice")
    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

}
