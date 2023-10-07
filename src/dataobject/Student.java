package dataoject;

public class Student {

    private String name = "";
    private int age = -1;
    private String id = "";

    public Student(String name, int age, String id){
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
