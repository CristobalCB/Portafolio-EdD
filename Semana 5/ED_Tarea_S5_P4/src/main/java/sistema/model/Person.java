package sistema.model;

public class Person implements Printable{

    private String name;
    private String address;

    public Person(String name, String address) {
        if (name == null){
            name = "Unregisted";
        }
        if (address == null){
            address = "Unregisted";
        }
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void print() {
        Printer.Print("Person Name: "+name+", Address:"+address+".\n");
    }
}
