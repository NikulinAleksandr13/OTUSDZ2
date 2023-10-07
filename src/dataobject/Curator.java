package dataoject;

public class Curator {
    private String name = "";
    private int age = -1;
    private String id = "";

    public Curator(String name, int age, String id){
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }
}
