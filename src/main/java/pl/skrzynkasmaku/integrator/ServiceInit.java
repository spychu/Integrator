package pl.skrzynkasmaku.integrator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import pl.skrzynkasmaku.integrator.reference.Reference;
import pl.skrzynkasmaku.integrator.reference.ReferenceParser;
import pl.skrzynkasmaku.integrator.utils.IntegratorUtils;
import pl.skrzynkasmaku.integrator.utils.PropertiesUtils;

/**
 *
 * @author Bartosz Spychaj
 */
public class ServiceInit {

    public static void main(String... args) {
        StringBuilder stringBuilder;
        try {
            PropertiesUtils.read();
        } catch (IOException ex) {
            LogManager.getLogger(ServiceInit.class).log(Level.ERROR, ex.getMessage(), ex);
        }
       
        String filePath = PropertiesUtils.getAbsoluePath(IntegratorUtils.REFERENCES_FILE);
        Path path = Paths.get(filePath);
        InvoiceIntegrator invoiceIntegrator = new InvoiceIntegrator();
        try {
            Stream<String> stream = Files.lines(path).filter(new Predicate<String>() {

                @Override
                public boolean test(String text) {
                    return text != null && !"".equals(text);
                }
            });
            Iterator<String> lines = stream.iterator();            
            int count = 0;
            while (lines.hasNext()) {
                count++;
                String line = lines.next();
                Reference reference = ReferenceParser.parse(line);
                stringBuilder = new StringBuilder();
                stringBuilder.append("Reference read: ").append(line).append(".");
                LogManager.getLogger(ServiceInit.class).log(Level.INFO, stringBuilder);
                invoiceIntegrator.integrateByReference(reference);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Number od references read: ").append(count).append(".");
            LogManager.getLogger(ServiceInit.class).log(Level.INFO, stringBuilder);
        } catch (IOException ex) {
            LogManager.getLogger(ServiceInit.class).log(Level.ERROR, ex.getMessage(), ex);
        }
    }
}
