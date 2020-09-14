package modelo;

public class Profesor extends Persona{

    private int añosExp;
    private String especialidad;

    /**
     * Constructor de un Profesor con un nombre, dirección, RUN, años de esperiencia y especialidad dado y fecha en
     * el momento que se genera.
     * @param n - Nombre del profesor.
     * @param d - Dirección del profesor.
     * @param r - RUN del profesor.
     * @param aE - Años de experiancia del Profesor.
     * @param e - Especialidad del Profesor.
     */
    public Profesor(String n, String d, int r, int aE, Especialidad e) {
        super(n, d, r);
        this.añosExp = aE;
        this.especialidad = e.getEspecialidad();
    }

    /**
     * Constructor de un Profesor con un nombre, dirección, RUN, años de esperiencia, especialidad y fecha dado.
     * @param n - Nombre del profesor.
     * @param d - Dirección del profesor.
     * @param r - RUN del profesor.
     * @param f - Fecha de ingreso del profesor.
     * @param aE - Años de experiancia del Profesor.
     * @param e - Especialidad del Profesor.
     */
    public Profesor(String n, String d, int r, String f, int aE, Especialidad e) {
        super(n, d, r, f);
        this.añosExp = aE;
        this.especialidad = e.getEspecialidad();
    }

    public int getAñosExp() {
        return añosExp;
    }

    public void setAñosExp(int añosExp) {
        this.añosExp = añosExp;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad.getEspecialidad();
    }

    /**
     * Genera un String que se usa para imprimir un Profesor.
     * @return - String con la linea a imprimir.
     */
    @Override
    public String toString() {
        return "|"+super.getNombre()+"\t|"+super.getDireccion()+"\t|"+super.getRun()+
                "\t|"+super.getFechaIng()+"\t|"+this.getAñosExp()+"\t|"+this.getEspecialidad()+"\t|";
    }
}
