package pl.skrzynkasmaku.integrator.reference;

import java.math.BigDecimal;

/**
 *
 * @author Bartosz Spychaj
 */
public class ReferenceParser {

    private final static String SEPARATOR = " ";
    private final static String WHOLESALE_KEY = "h";
    private final static String MARGIN_KEY = "m";
    private final static String VALUE_SEPARATOR = ":";

    public static Reference parse(String line) {
        String[] parts = line.split(SEPARATOR);
        Reference reference = new Reference();
        if (parts.length > 0) {
            String text = parts[0];
            reference.setText(text);
        }
        if (parts.length > 1) {
            if (parts[1].equals(WHOLESALE_KEY)) {
                reference.setWholesale(true);
                if (parts.length > 2) {
                    if (parts[2].startsWith(MARGIN_KEY)) {
                        String marginPart = parts[2];
                        String[] marginParts = marginPart.split(VALUE_SEPARATOR);
                        if (marginParts.length > 1) {
                            String marginValue = marginParts[1];
                            BigDecimal margin = new BigDecimal(marginValue);
                            reference.setMargin(margin);
                        }
                    }
                }
            }
        }
        return reference;
    }
}
