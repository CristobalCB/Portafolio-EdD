package cl.ufro.dci.ed.model;

import java.util.Objects;
import java.util.TreeSet;

public class Equipo implements Comparable<Equipo>{

    private String club;
    private String ciudad;
    private String dueño;
    private String estadio;
    private int puntaje;
    private TreeSet <Futbolista> jugadores;

    /**
     *
     * @param club el nombre del equipo
     * @param ciudad es la ciudad en que se encuentra el equipo
     * @param dueño es el nombre del dueño del equipo
     * @param estadio es el nombre del estadio del equipo
     * @param puntaje son los puntos del equipo que actualmente lleva en la liga
     */
    public Equipo(String club, String ciudad, String dueño, String estadio, int puntaje) {
        this.club = club;
        this.ciudad = ciudad;
        this.dueño = dueño;
        this.estadio = estadio;
        this.puntaje = puntaje;
        this.jugadores = new TreeSet<>();
    }

    /**
     * Si el equipo gana un partido se le suma 3 puntos al puntaje
     */
    public void ganarPartido(){
        this.puntaje = puntaje + 3;
    }

    /**
     * Si el equipo empata un partido se le suma 1 punto al puntaje
     */
    public void empatarPartido(){
        this.puntaje = puntaje + 1;
    }

    public void agregarJugador (Futbolista jugador){
        if(this.jugadores.size() > 30){
            System.out.println("no se pueden agregar más de 30 jugadores");
        }else {
            this.jugadores.add(jugador);
        }
    }

    public TreeSet<Futbolista> getJugadores() {
        return jugadores;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "club='" + club + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", dueño='" + dueño + '\'' +
                ", estadio='" + estadio + '\'' +
                ", puntaje=" + puntaje +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo)) return false;
        Equipo equipo = (Equipo) o;
        return getPuntaje() == equipo.getPuntaje() &&
                getClub().equals(equipo.getClub()) &&
                Objects.equals(getCiudad(), equipo.getCiudad()) &&
                Objects.equals(getDueño(), equipo.getDueño()) &&
                Objects.equals(getEstadio(), equipo.getEstadio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPuntaje());
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
     * @param otroEquipo the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Equipo otroEquipo) {
        if(this.getPuntaje() > otroEquipo.getPuntaje()){
            return -1;
        }else if(this.getPuntaje() < otroEquipo.getPuntaje() ){
            return 1;
        }else {
            return 1;
        }
    }
}
