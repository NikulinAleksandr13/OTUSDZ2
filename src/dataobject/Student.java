package dataobject;

public class Student {

    private int id;
    private String fio;
    private String sex;
    private int id_group;


    public Student(int id, String fio, String sex, int id_group){
        this.id = id;
        this.fio = fio;
        this.sex = sex;
        this.id_group = id_group;

    }

    public int getId() {
        return id;
    }
    public String getFio() {
        return fio;
    }
    public String getSex() {
        return sex;
    }
    public int getIdGroup() {
        return id_group;
    }

    @Override
    public String toString() {
        return String.format("'%s', '%s', '%s', '%s'", getId(), getFio(), getSex(), getIdGroup());
    }
}
