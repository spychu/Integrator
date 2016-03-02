package pl.skrzynkasmaku.integrator.wfirma;

import pl.skrzynkasmaku.integrator.prestashop.model.Address;
import pl.skrzynkasmaku.integrator.wfirma.model.Contractor;

/**
 *
 * @author Bartosz Spychaj
 */
public class PrivateContractorFactory extends ContractorFactory {

    public PrivateContractorFactory(Address address) {
        super(address);
    }

    @Override
    public Contractor build() {
        Contractor contractor = super.build();
        
        String name = address.getFirstname() + " " + address.getLastname();
        
        contractor.setName(name);

        return contractor;
    }

}
