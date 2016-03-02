package pl.skrzynkasmaku.integrator.wfirma.model;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bartosz Spychaj
 */
@XmlRootElement
public class Invoicecontent {

    private String name;
    private String unit = "szt.";
    private Integer count;
    private BigDecimal price;
    private VatCode vatCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @XmlElement(name = "vat_code")
    public void setVatCode(VatCode vatCode) {
        this.vatCode = vatCode;
    }

    public VatCode getVatCode() {
        return vatCode;
    }

}
