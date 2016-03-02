package pl.skrzynkasmaku.integrator.jaxb;

import java.io.Serializable;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;

/**
 *
 * @author Bartosz Spychaj
 */
public class Marshaller {

    public String marshall(Serializable serializable) throws PropertyException, JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(serializable.getClass());
        javax.xml.bind.Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
        StringWriter stringWriter = new StringWriter();

        jaxbMarshaller.marshal(serializable, stringWriter);

        return stringWriter.toString();

    }
}
