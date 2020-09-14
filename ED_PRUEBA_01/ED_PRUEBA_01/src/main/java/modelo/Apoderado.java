package modelo;

public class Apoderado extends Persona{

    /**
     * Constructor de un Apoderado con un nombre, dirección y RUN dado y fecha en el momento que se genera.
     * @param n - Nombre del apoderado.
     * @param d - Dirección del apoderado.
     * @param r - RUN del apoderado.
     */
    public Apoderado(String n, String d, int r){
        super(n, d, r);
    }

    /**
     * Constructor de un Apoderado con un nombre, dirección, RUN y fecha dada.
     * @param n - Nombre del apoderado.
     * @param d - Dirección del apoderado.
     * @param r - RUN del apoderado.
     * @param f - Fecha de ingreso del apoderado.
     */
    public Apoderado(String n, String d, int r, String f){
        super(n, d, r, f);
    }

    /**
     * Genera un String que se usa para imprimir un apoderado.
     * @return - String con la linea a imprimir.
     */
    @Override
    public String toString() {
        return "|"+super.getNombre()+"\t|"+super.getDireccion()+
                "\t|"+super.getRun()+"\t|"+super.getFechaIng()+"\t|";
    }

}
