public enum Curso {
    CUARTOA("4°A"),
    CUARTOB("4°B"),
    TERCEROA("3°A"),
    TERCEROB("3°B"),
    SEGUNDOA("2°A"),
    SEGUNDOB("2°B"),
    PRIMEROA("1°A"),
    PRIMEROB("1°B");

    private final String nombre;
    Curso(String nombre){this.nombre=nombre;}
    public String toString(){return this.nombre;}

}
