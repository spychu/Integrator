package pl.skrzynkasmaku.integrator.wfirma;

import pl.skrzynkasmaku.integrator.prestashop.model.Address;

/**
 *
 * @author Bartosz Spychaj
 */
public class ContractorFactoryProducer {

    public static ContractorFactory getFactory(Address address) {

        String company = address.getCompany();
        if (company != null && !"".equals(company)) {
            return new BussinessContractorFactory(address);
        } else {
            return new PrivateContractorFactory(address);
        }
    }
}
