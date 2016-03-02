package pl.skrzynkasmaku.integrator.wfirma.model;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Bartosz Spychaj
 */
public class VatContent {

    private BigDecimal brutto;
    private BigDecimal netto = BigDecimal.ONE;
    private BigDecimal tax = BigDecimal.ONE;
    private VatCode vatCode;

    @XmlElement(name = "vat_code")
    public void setVatCode(VatCode vatCode) {
        this.vatCode = vatCode;
    }

    public VatCode getVatCode() {
        return vatCode;
    }

    public void setBrutto(BigDecimal brutto) {
        this.brutto = brutto;
    }

    public BigDecimal getBrutto() {
        return brutto;
    }

    public void addBrutto(BigDecimal brutto) {
        this.brutto = this.brutto.add(brutto);
    }

    public BigDecimal getNetto() {
        return netto;
    }

    public void setNetto(BigDecimal netto) {
        this.netto = netto;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
    
    

}
