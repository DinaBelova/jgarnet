package name.dbelova.jgarnet;

/**
 * @author dbelova
 */
public class Author {
    private String name;
    private int age;

    public Author() {
    }

    public Author(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + age;
    }
}
