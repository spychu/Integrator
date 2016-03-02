package pl.skrzynkasmaku.integrator.wfirma;

import pl.skrzynkasmaku.integrator.prestashop.model.Address;
import pl.skrzynkasmaku.integrator.wfirma.model.Contractor;

/**
 *
 * @author Bartosz Spychaj
 */
public abstract class ContractorFactory {

    protected Address address;

    public ContractorFactory(Address address) {
        this.address = address;
    }

    public Contractor build() {
        Contractor contractor = new Contractor();
        contractor.setCity(address.getCity());
        contractor.setZip(address.getPostcode());
        String street = address.getAddress1() + " " + address.getAddress2();
        contractor.setStreet(street);
        
        return contractor;
    }
}
