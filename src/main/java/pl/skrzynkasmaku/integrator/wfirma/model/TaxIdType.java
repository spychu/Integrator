package pl.skrzynkasmaku.integrator.wfirma.model;

/**
 *
 * @author Spychu
 */
public enum TaxIdType {
    NIP,
    VAT,
    PESEL,
    REGON,
    CUSTOM,
    NONE;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
    
    
    
}
