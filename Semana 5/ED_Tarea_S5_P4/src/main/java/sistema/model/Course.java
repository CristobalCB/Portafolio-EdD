package sistema.model;

public class Course implements Printable{

    private String name;
    private int hours;

    public Course(String name, int hours) {
        if (name == null){
            name = "Unregisted";
        }
        this.name = name;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void print() {
        Printer.Print("Class Name: "+name+", hour: "+hours+".\n");
    }

    private float getCredits(){
        return (float)hours;
    }
}
