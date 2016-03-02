package pl.skrzynkasmaku.integrator.prestashop.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.DynamicParameterizedType;
import org.hibernate.usertype.UserType;

/**
 *
 * @author Bartosz Spychaj
 */
public final class LabeledEnumType implements DynamicParameterizedType, UserType {

    private Class<? extends Enum> enumClass;

    @Override
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return cached;
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return x == y;
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x == null ? 0 : x.hashCode();
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
            throws HibernateException, SQLException {
        String label = rs.getString(names[0]);
        if (rs.wasNull()) {
            return null;
        }
        for (Enum value : returnedClass().getEnumConstants()) {
            if (value instanceof LabeledEnum) {
                LabeledEnum labeledEnum = (LabeledEnum) value;
                if (labeledEnum.getLabel().equals(label)) {
                    return value;
                }
            }
        }
        throw new IllegalStateException("Unknown " + returnedClass().getSimpleName() + " label");
    }

    @Override
    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return original;
    }

    @Override
    public Class<? extends Enum> returnedClass() {
        return enumClass;
    }

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.VARCHAR};
    }

    @Override
    public void setParameterValues(Properties parameters) {
        ParameterType params = (ParameterType) parameters.get(PARAMETER_TYPE);
        enumClass = params.getReturnedClass();
    }

    @Override
    public void nullSafeSet(java.sql.PreparedStatement ps, Object o, int i, SessionImplementor si) throws HibernateException, SQLException {

        throw new IllegalStateException("Unknown " + returnedClass().getSimpleName() + " label");

    }
}
