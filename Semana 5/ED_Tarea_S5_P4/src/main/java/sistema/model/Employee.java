package sistema.model;

public class Employee extends Person {

    private int id;

    public Employee(String name, String address, int id) {
        super(name, address);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
