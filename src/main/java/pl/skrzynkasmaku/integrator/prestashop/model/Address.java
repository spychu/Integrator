package pl.skrzynkasmaku.integrator.prestashop.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Bartosz Spychaj
 */
@Entity
@Table(name = "ps_address")
public class Address implements Serializable {

    @Id
    @Column(name = "id_address")
    Integer id;
    @Column(name = "city")
    String city;
    @Column(name = "address1")
    String address1;
    @Column(name = "address2")
    String address2;
    @Column(name = "company")
    String company;
    @Column(name = "lastname")
    String lastname;
    @Column(name = "firstname")
    String firstname;
    @Column(name = "postcode")
    String postcode;
    @Column(name = "vat_number")
    String vatNumber;

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

}
