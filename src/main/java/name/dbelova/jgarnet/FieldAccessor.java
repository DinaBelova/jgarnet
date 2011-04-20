package name.dbelova.jgarnet;

import java.lang.reflect.Field;

/**
 * @author dbelova
 */
public class FieldAccessor<P, T> {
    private Class<P> parentType;
    private Class<T> fieldType;
    private Field field;

    public FieldAccessor(Class<P> parentType, Class<T> fieldType, Field field) {
        this.parentType = parentType;
        this.fieldType = fieldType;
        this.field = field;
        field.setAccessible(true);
    }

    @SuppressWarnings({"unchecked"})
    public T get(P instance) throws FieldAccessorException {
        try {
            Object tmp = field.get(instance);
            if (tmp == null) {
                return null;
            }
            return (T) tmp;
        } catch (IllegalAccessException e) {
            throw new FieldAccessorException("Illegal access", e);
        }
    }

    public void set(P instance, T value) throws FieldAccessorException {
        try {
            field.set(instance, value);
        } catch (IllegalAccessException e) {
            throw new FieldAccessorException("Illegal access", e);
        }
    }

    @SuppressWarnings({"unchecked"})
    void setUnsafe (P instance, Object value) throws FieldAccessorException {
        set(instance, (T)value);
    }

    public Class<P> getParentType() {
        return parentType;
    }

    public Class<T> getFieldType() {
        return fieldType;
    }

}
