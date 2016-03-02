package pl.skrzynkasmaku.integrator.prestashop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Bartosz Spychaj
 */
@Entity
@Table(name = "ps_order_detail")
public class OrderDetail implements Serializable, Comparable<OrderDetail> {

    @Id
    @Column(name = "id_order_detail")
    private Integer orderDetailId;
    @Column(name = "product_name")
    private String producName;
    @Column(name = "product_quantity")
    private Integer productQuantity;
    @Column(name = "id_tax_rules_group")
    private Integer idTaxRulesGroup;
    @Column(name = "unit_price_tax_incl")
    private BigDecimal unitPriceTaxIncl;
    @Column(name = "unit_price_tax_excl")
    private BigDecimal unitPriceTaxExcl;
    @Column(name = "purchase_supplier_price")
    private BigDecimal purchaseSupplierPrice;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_order", nullable = false)
    private Order order;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getProducName() {
        return producName;
    }

    public void setProducName(String producName) {
        this.producName = producName;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Integer getIdTaxRulesGroup() {
        return idTaxRulesGroup;
    }

    public void setIdTaxRulesGroup(Integer idTaxRulesGroup) {
        this.idTaxRulesGroup = idTaxRulesGroup;
    }

    public BigDecimal getUnitPriceTaxIncl() {
        return unitPriceTaxIncl;
    }

    public void setUnitPriceTaxIncl(BigDecimal unitPriceTaxIncl) {
        this.unitPriceTaxIncl = unitPriceTaxIncl;
    }

    public void setUnitPriceTaxExcl(BigDecimal unitPriceTaxExcl) {
        this.unitPriceTaxExcl = unitPriceTaxExcl;
    }

    public BigDecimal getUnitPriceTaxExcl() {
        return unitPriceTaxExcl;
    }

    public void setPurchaseSupplierPrice(BigDecimal purchaseSupplierPrice) {
        this.purchaseSupplierPrice = purchaseSupplierPrice;
    }

    public BigDecimal getPurchaseSupplierPrice() {
        return purchaseSupplierPrice;
    }

    @Override
    public int compareTo(OrderDetail o) {
        return orderDetailId - o.orderDetailId;
    }
}
