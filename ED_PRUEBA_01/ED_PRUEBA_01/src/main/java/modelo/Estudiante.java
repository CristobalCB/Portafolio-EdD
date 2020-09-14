package modelo;

public class Estudiante extends Persona implements Comparable<Estudiante>{

    private double promedioG;

    /**
     *Constructor de un Estudiante con un nombre, dirección, RUN y promedio dado y fecha en el momento que se genera.
     * @param n - Nombre del estudiante.
     * @param d - Dirección del estudiante.
     * @param r - RUN del estudiante.
     * @param p - Promedio actual del estudiante.
     */
    public Estudiante(String n, String d, int r, double p) {
        super(n, d, r);
        this.promedioG = p;
    }

    /**
     * Constructor de un Personal Administrativo con un nombre, dirección, RUN, fecha y promedio dado.
     * @param n - Nombre del estudiante.
     * @param d - Dirección del estudiante.
     * @param r - RUN del estudiante.
     * @param f - Fechad de ingreso del estudiante.
     * @param p - Promedio actual del estudiante.
     */
    public Estudiante(String n, String d, int r, String f, double p) {
        super(n, d, r, f);
        this.promedioG = p;
    }

    public double getPromedioG() {
        return promedioG;
    }

    public void setPromedioG(double promedioG) {
        this.promedioG = promedioG;
    }

    /**
     * Genera un String que se usa para imprimir un Estudiante.
     * @return - String con la linea a imprimir.
     */
    @Override
    public String toString() {
        return "|"+super.getNombre()+"\t|"+super.getDireccion()+ "\t|"+super.getRun()+
                "\t|"+super.getFechaIng()+"\t|"+this.getPromedioG()+"|";
    }

    /**
     * Sobre-escritura del método compareTo de Comparable.
     * @param estudiante - Estudiante a comparar con this.
     * @return - un número negativo, cero o un positivo si el promedio es menor, igual o mayor, respectivamente.
     */
    @Override
    public int compareTo(Estudiante estudiante) {
        return (int)(this.getPromedioG()*10 - estudiante.getPromedioG()*10);
    }
}
