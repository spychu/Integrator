package pl.skrzynkasmaku.integrator.wfirma.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bartosz Spychaj
 */
@XmlRootElement
public class Company {

    private String id = "87318";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
