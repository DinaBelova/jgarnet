package name.dbelova.jgarnet;

import java.util.Map;

/**
 * @author dbelova
 */
public class Main {
    public static void main(String[] args) throws FieldAccessorException, InstantiationException, IllegalAccessException {
        Author a = new Author("Me", 19);
        ClassMapper<Author> classMapper = new ClassMapper<Author>(Author.class);
        Map<String, Object> map = classMapper.toMap(a);
        System.out.println(map);
        System.out.println(classMapper.fromMap(map));
    }
}
