package pl.skrzynkasmaku.integrator.wfirma.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bartosz Spychaj
 */
@XmlRootElement
public class Contractor {

    private String taxIdType = TaxIdType.NONE.toString();
    private String name;
    private String nip;
    private String street;
    private String zip;
    private String city;

    public String getTax_id_type() {
        return taxIdType;
    }

    public String getName() {
        return name;
    }

    public String getTaxIdType() {
        return taxIdType;
    }

    @XmlElement(name = "tax_id_type")
    public void setTaxIdType(String taxIdType) {
        this.taxIdType = taxIdType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
