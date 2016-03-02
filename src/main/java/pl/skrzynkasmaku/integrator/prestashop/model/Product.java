package pl.skrzynkasmaku.integrator.prestashop.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Bartosz Spychaj
 */
@Entity
@Table(name = "ps_product")
public class Product {

    @Id
    @Column(name = "id_product")
    private Integer productId;

    @Column(name = "wholesale_price")
    private BigDecimal wholesalePrice;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

}
