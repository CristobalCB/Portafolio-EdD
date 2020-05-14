package program;

public class Animal {

    private String name;
    private String sound;
    private static final String eat = "crac - crac";

    public Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String makeSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String eat() {
        return eat;
    }
}
