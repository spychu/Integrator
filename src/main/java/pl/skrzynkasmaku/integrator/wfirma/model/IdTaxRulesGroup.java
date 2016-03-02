package pl.skrzynkasmaku.integrator.wfirma.model;

import java.util.Objects;

/**
 *
 * @author Spychu
 */
/*
 Po stronie wFirma
 224 - 5 %
 223 - 8%
 222 - 23%

 Po stronie PrestaShop: idTaxRulesGroup
 1 - 23%
 2 - 8%
 3 - 5%
 */
public enum IdTaxRulesGroup {

    TAX_5(3, 224),
    TAX_8(2, 223),
    TAX_23(1, 222);

    private IdTaxRulesGroup(Integer prestaShopValue, Integer wfirmaValue) {
        this.prestaShopValue = prestaShopValue;
        this.wfirmaValue = wfirmaValue;
    }

    private final Integer prestaShopValue;
    private final Integer wfirmaValue;

    public Integer getPrestaShopValue() {
        return prestaShopValue;
    }

    public Integer getWfirmaValue() {
        return wfirmaValue;
    }

    public static IdTaxRulesGroup getFromPrestaShopValue(Integer prestaShopValue) {
        IdTaxRulesGroup idTaxRulesGroup = null;
        for (IdTaxRulesGroup idTax : IdTaxRulesGroup.values()) {
            if (Objects.equals(idTax.prestaShopValue, prestaShopValue)) {
                idTaxRulesGroup = idTax;
                break;
            }
        }
        return idTaxRulesGroup;
    }

}
