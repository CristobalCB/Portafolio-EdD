package program;

public class Animal {

    private final String name;
    private final String sound;
    private static final String eat = "crac - crac";

    /**
     * Crea un animal nuevo.
     * @param name - nombre del animal (especie)
     * @param sound - sonido que hace (onomatopeya)
     */
    public Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    /**
     * Es un getsound pero mejor nombrado segun esta ocación
     * @return String del sonido producido por el animal como onomatopeya.
     */
    public String makeSound() {
        return sound;
    }

    /**
     * Es un geteat pero mejor nombrado segun esta ocación.
     * @return String del sonido cuando come el animal como onomatopeya.
     */
    public static String eat() {
        return eat;
    }
}
