package pl.skrzynkasmaku.integrator.wfirma.model;

/**
 *
 * @author Spychu
 */
public enum PriceType {

    Brutto("brutto"),
    Netto("netto");

    private String value;
    
    private PriceType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    
}
