package dataobject;

public class Curator {
    private int id;
    private String fio;

    public Curator(int id, String fio){
        this.id = id;
        this.fio = fio;
    }

    public int getId() {
        return id;
    }
    public String getFio() {
        return fio;
    }

    @Override
    public String toString() {
        return String.format("'%s', '%s'", getId(), getFio());
    }

}
