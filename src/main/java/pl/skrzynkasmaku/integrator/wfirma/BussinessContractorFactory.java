package pl.skrzynkasmaku.integrator.wfirma;

import pl.skrzynkasmaku.integrator.prestashop.model.Address;
import pl.skrzynkasmaku.integrator.wfirma.model.Contractor;
import pl.skrzynkasmaku.integrator.wfirma.model.TaxIdType;

/**
 *
 * @author Bartosz Spychaj
 */
public class BussinessContractorFactory extends ContractorFactory {

    public BussinessContractorFactory(Address address) {
        super(address);
    }

    @Override
    public Contractor build() {
        Contractor contractor = super.build();
        String company = address.getCompany();
        String vatNumber = address.getVatNumber();
        contractor.setName(company);
        contractor.setNip(vatNumber);
        if (vatNumber != null && !"".equals(vatNumber)) {
            contractor.setTaxIdType(TaxIdType.NIP.toString());
        }

        return contractor;
    }

}
