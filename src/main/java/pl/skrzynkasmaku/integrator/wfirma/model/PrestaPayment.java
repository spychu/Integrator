package pl.skrzynkasmaku.integrator.wfirma.model;

import pl.skrzynkasmaku.integrator.prestashop.model.LabeledEnum;

/**
 *
 * @author Spychu
 */
public enum PrestaPayment implements LabeledEnum {

    CHEQUE,
    BANKWIRE,
    PAYU,
    CASHONDELIVERY,
    FREE_ORDER;

    @Override
    public String getLabel() {
        return super.toString().toLowerCase();
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();

    }
}
