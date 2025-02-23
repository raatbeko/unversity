package domain.base;

public class NamedObject {

    private String name;

    public NamedObject() {
    }

    public NamedObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
