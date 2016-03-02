package pl.skrzynkasmaku.integrator.wfirma.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bartosz Spychaj
 */
@XmlRootElement(name = "invoice")
public class Invoice implements Serializable {

    private String warehouseType = "simple";
    private String paymentDate;
    private String paymentstate = "paid";
    private String priceType = "brutto";
    private String payment;
    private BigDecimal total;
    private Company company = new Company();
    private BigDecimal alreadypaidInitial;
    private List<VatContent> vatContents = new ArrayList<>();
    private Contractor contractor;
    private List<Invoicecontent> invoicecontents = new ArrayList<>();

    @XmlElement(name = "alreadypaid_initial")
    public void setAlreadypaidInitial(BigDecimal alreadypaidInitial) {
        this.alreadypaidInitial = alreadypaidInitial;
    }

    public BigDecimal getAlreadypaidInitial() {
        return alreadypaidInitial;
    }

    @XmlElement(name = "paymentmethod")
    public void setPayment(Payment payment) {
        this.payment = payment.toString();
    }

    public String getPayment() {
        return payment;
    }

    public String getWarehouseType() {
        return warehouseType;
    }

    @XmlElement(name = "warehouse_type")
    public void setWarehouseType(String warehouseType) {
        this.warehouseType = warehouseType;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    @XmlElement(name = "paymentdate")
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentstate() {
        return paymentstate;
    }

    @XmlElement(name = "paymentstate")
    public void setPaymentstate(String paymentstate) {
        this.paymentstate = paymentstate;
    }

    @XmlElementWrapper(name = "invoicecontents")
    @XmlElement(name = "invoicecontent")
    public void setInvoicecontents(List<Invoicecontent> invoicecontents) {
        this.invoicecontents = invoicecontents;
    }

    public List<Invoicecontent> getInvoicecontents() {
        return invoicecontents;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    public Contractor getContractor() {
        return contractor;
    }

    @XmlElement(name = "price_type")
    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getPriceType() {
        return priceType;
    }

    @XmlTransient
    public void setVatContents(List<VatContent> vatContents) {
        this.vatContents = vatContents;
    }

    public List<VatContent> getVatContents() {
        return vatContents;
    }

    @XmlTransient
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }

}
