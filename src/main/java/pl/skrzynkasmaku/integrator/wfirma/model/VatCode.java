package pl.skrzynkasmaku.integrator.wfirma.model;

import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bartosz Spychaj
 */
@XmlRootElement(name = "vat_code")
public class VatCode {

    private Integer id;

    @XmlElement(name = "id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VatCode)) {
            return false;
        }
        VatCode vatCode = (VatCode) obj;

        return Objects.equals(vatCode.id, id);
    }

    @Override
    public int hashCode() {
        return id;
    }

}
