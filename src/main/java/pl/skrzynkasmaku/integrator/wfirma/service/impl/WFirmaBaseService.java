package pl.skrzynkasmaku.integrator.wfirma.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.bind.JAXBException;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import pl.skrzynkasmaku.integrator.jaxb.Marshaller;
import pl.skrzynkasmaku.integrator.utils.IntegratorUtils;
import pl.skrzynkasmaku.integrator.utils.PropertiesUtils;

/**
 *
 * @author Bartosz Spychaj
 */
public class WFirmaBaseService {

    private final Marshaller marshaller = new Marshaller();

    public String getPath() {
        return PropertiesUtils.getProperty(IntegratorUtils.API_KEY);
    }

    public String getCredential() {
        return PropertiesUtils.getProperty(IntegratorUtils.CREDENTIAL_KEY);
    }

    protected void send(String fullPath, String command) {
        try {
            URL url = new URL(fullPath);
            byte[] encodedBytes = Base64.encodeBase64(getCredential().getBytes());
            String encoding = new String(encodedBytes);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            try (OutputStreamWriter out = new OutputStreamWriter(
                    connection.getOutputStream(), "UTF-8")) {
                out.write(command);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("wFirma command: ");
            stringBuilder.append("/n");
            stringBuilder.append(command);
            LogManager.getLogger(WFirmaBaseService.class).log(Level.DEBUG, stringBuilder);
            InputStream content = (InputStream) connection.getInputStream();
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(content));

            String line;
            StringWriter stringWriter = new StringWriter();
            while ((line = in.readLine()) != null) {
                stringWriter.write(line);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("wFirma result: ");
            stringBuilder.append("/n");
            stringBuilder.append(stringWriter);
            LogManager.getLogger(WFirmaBaseService.class).log(Level.DEBUG, stringBuilder);
        } catch (IOException ex) {
            LogManager.getLogger(WFirmaBaseService.class).log(Level.ERROR, ex.getMessage(), ex);

        }
    }

    protected void send(String fullPath, Serializable serializable) throws JAXBException {
        String command = marshaller.marshall(serializable);
        this.send(fullPath, command);
    }

}
