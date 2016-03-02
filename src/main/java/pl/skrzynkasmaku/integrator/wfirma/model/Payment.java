package pl.skrzynkasmaku.integrator.wfirma.model;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Spychu
 */
@XmlJavaTypeAdapter(Payment.Adapter.class)
public enum Payment {

    CASH,
    TRANSFER,
    COMPENSATION,
    COD,
    PAYMENT_CARD;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

    public static class Adapter extends CamelCaseEnumAdapter<Payment> {

        public Adapter() {
            super(Payment.class, TRANSFER);
        }
    }
}
