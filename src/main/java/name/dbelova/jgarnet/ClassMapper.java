package name.dbelova.jgarnet;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author dbelova
 */
public class ClassMapper<T> {
    private Class<T> type;
    private Map<String, FieldAccessor<T, ?>> fieldAccessorMap;

    @SuppressWarnings({"unchecked"})
    public ClassMapper(Class<T> type) {
        this.type = type;
        this.fieldAccessorMap = Maps.createHashMap();
        // todo scan superClasses fo declared fields
        for (Field field : type.getDeclaredFields()) {
            fieldAccessorMap.put(field.getName(), new FieldAccessor(type, field.getType(), field));
        }
    }

    public Map<String, Object> toMap (T instance) throws FieldAccessorException {
        Map<String, Object> fieldValues = Maps.createHashMap();
        for (Map.Entry<String, FieldAccessor<T, ?>> entry : fieldAccessorMap.entrySet()) {
            fieldValues.put(entry.getKey(), entry.getValue().get(instance));
        }
        return fieldValues;
    }

    public T fromMap (Map<String, Object> fieldValues)
            throws IllegalAccessException, InstantiationException, FieldAccessorException {
        T instance = type.newInstance();
        for (Map.Entry<String, FieldAccessor<T, ?>> entry : fieldAccessorMap.entrySet()) {
            entry.getValue().setUnsafe(instance, fieldValues.get(entry.getKey()));
        }
        return instance;
    }
}
