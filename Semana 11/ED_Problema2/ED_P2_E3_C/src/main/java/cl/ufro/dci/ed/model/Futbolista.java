package cl.ufro.dci.ed.model;

import java.util.Objects;

public class Futbolista implements Comparable<Futbolista>{

    private String nombre;
    private int edad;
    private String nacionalidad;
    private double altura;
    private double peso;
    private int dorsal;
    private int valoracion;
    private double sueldo;
    private double valor;
    private Posicion posicion;
    private Equipo equipo;

    /**
     *
     * @param nombre es el nombre completo del futbolista
     * @param edad es la edad que tiene el futbolista
     * @param nacionalidad es la nacionalidad del futbolista
     * @param altura es la altura en m del futbolista
     * @param peso es el peso en kg del futbolista
     * @param dorsal es el numero de la camiseta del futbolista
     * @param valoracion es la valoracion de la habilidad del futbolista
     * @param sueldo es el sueldo del futbolista
     * @param valor es el valor del futbolista en el mercado
     * @param posicion es la posicion que desempeña el futbolista
     */
    public Futbolista(String nombre, int edad, String nacionalidad, double altura, double peso, int dorsal, int valoracion, double sueldo, double valor, Posicion posicion) {
        this.nombre = nombre;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.altura = altura;
        this.peso = peso;
        this.dorsal = dorsal;
        this.valoracion = valoracion;
        this.sueldo = sueldo;
        this.valor = valor;
        this.posicion = posicion;
        this.equipo = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Futbolista)) return false;
        Futbolista that = (Futbolista) o;
        return getEdad() == that.getEdad() &&
                Double.compare(that.getAltura(), getAltura()) == 0 &&
                Double.compare(that.getPeso(), getPeso()) == 0 &&
                getDorsal() == that.getDorsal() &&
                getValoracion() == that.getValoracion() &&
                Double.compare(that.getSueldo(), getSueldo()) == 0 &&
                Double.compare(that.getValor(), getValor()) == 0 &&
                getNombre().equals(that.getNombre()) &&
                Objects.equals(getNacionalidad(), that.getNacionalidad()) &&
                getPosicion() == that.getPosicion() &&
                Objects.equals(getEquipo(), that.getEquipo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValoracion());
    }

    @Override
    public String toString() {
        return "Futbolista{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                ", dorsal=" + dorsal +
                ", valoracion=" + valoracion +
                ", sueldo=" + sueldo +
                ", valor=" + valor +
                ", posicion=" + posicion +
                ", equipo=" + equipo +
                '}';
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param otroFutbolista the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Futbolista otroFutbolista) {
        if(this.getValoracion() > otroFutbolista.getValoracion()){
            return -1;
        }else if(this.getValoracion() < otroFutbolista.getValoracion()){
            return 1;
        }else {
            return 1;
        }
    }
}
