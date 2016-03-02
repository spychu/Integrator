package pl.skrzynkasmaku.integrator.wfirma.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Bartosz Spychaj
 * @param <E>
 */
public abstract class CamelCaseEnumAdapter<E extends Enum> extends XmlAdapter<String, E> {

    private Class<E> clazz;
    private E defaultValue;

    public CamelCaseEnumAdapter(Class<E> clazz) {
        this(clazz, null);
    }

    public CamelCaseEnumAdapter(Class<E> clazz, E defaultValue) {
        this.clazz = clazz;
        this.defaultValue = defaultValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E unmarshal(String v) throws Exception {
        if (v == null || v.isEmpty()) {
            return defaultValue;
        }
        return (E) Enum.valueOf(clazz, v.replaceAll("([a-z])([A-Z])", "$1_$2").toUpperCase());
    }

    @Override
    public String marshal(E v) throws Exception {
        if (v == defaultValue) {
            return null;
        }
        return toCamelCase(v.name());
    }

    private String toCamelCase(String s) {
        String[] parts = s.split("_");
        String camelCaseString = "";
        for (String part : parts) {
            if (camelCaseString.isEmpty()) {
                camelCaseString = camelCaseString + part.toLowerCase();
            } else {
                camelCaseString = camelCaseString + toProperCase(part);
            }
        }
        return camelCaseString;
    }

    private String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase()
                + s.substring(1).toLowerCase();
    }
}
