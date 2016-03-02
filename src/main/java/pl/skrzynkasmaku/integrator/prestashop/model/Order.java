package pl.skrzynkasmaku.integrator.prestashop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.SortedSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;
import pl.skrzynkasmaku.integrator.wfirma.model.PrestaPayment;

/**
 *
 * @author Bartosz Spychaj
 */
@Entity
@Table(name = "ps_orders")
public class Order implements Serializable {

    @Id
    @Column(name = "id_order")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_address_delivery")
    private Address deliveryAddress;
    @ManyToOne
    @JoinColumn(name = "id_address_invoice")
    private Address invoiceAddress;
    @Column(name = "date_add")
    //@Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "reference")
    private String reference;
    @Column(name = "total_shipping")
    private BigDecimal totalShipping;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    @OrderBy("orderDetailId ASC")
    private SortedSet<OrderDetail> orderDetails;
    @Column(name = "total_paid_tax_incl")
    private BigDecimal totalPaidTaxIncl;
    @Column(name = "module")
    @Type(type = "pl.skrzynkasmaku.integrator.prestashop.model.LabeledEnumType")
    private PrestaPayment payment;

    public void setPayment(PrestaPayment payment) {
        this.payment = payment;
    }

    public PrestaPayment getPayment() {
        return payment;
    }

    public void setTotalPaidTaxIncl(BigDecimal totalPaidTaxIncl) {
        this.totalPaidTaxIncl = totalPaidTaxIncl;
    }

    public BigDecimal getTotalPaidTaxIncl() {
        return totalPaidTaxIncl;
    }

    public SortedSet<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(SortedSet<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Address getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(Address invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BigDecimal getTotalShipping() {
        return totalShipping;
    }

    public void setTotalShipping(BigDecimal totalShipping) {
        this.totalShipping = totalShipping;
    }
}
