package pl.skrzynkasmaku.integrator.reference;

import java.math.BigDecimal;

/**
 *
 * @author Bartosz Spychaj
 */
public class Reference {

    private String text;
    private boolean wholesale;
    private BigDecimal margin = new BigDecimal("1.18");

    public boolean isWholesale() {
        return wholesale;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public void setWholesale(boolean wholesale) {
        this.wholesale = wholesale;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
