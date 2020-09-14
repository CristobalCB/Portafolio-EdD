package modelo;

public class Asignatura {

    private String nombre;
    private int credito;
    private String tipo;

    /**
     * Constructor de un objeto asignatura.
     * @param nombre - Nombre de la asignatura.
     * @param credito - Creditos que da la asignatura.
     * @param t - Tipo de asigantura (usa enum TipoAsig).
     */
    public Asignatura(String nombre, int credito, TipoAsig t) {
        this.nombre = nombre;
        this.credito = credito;
        this.tipo = t.getTipoAsig();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(TipoAsig tipo) {
        this.tipo = tipo.getTipoAsig();
    }

    /**
     * Genera un String que se usa para imprimir una asignatura.
     * @return - String con la linea a imprimir.
     */
    @Override
    public String toString() {
        return "|"+this.getNombre()+"\t|"+this.getCredito()+"\t|"+this.getTipo()+"\t|";
    }
}
