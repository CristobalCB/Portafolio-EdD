package modelo;

public class PersonalAdmin extends Persona {

    private String profesion;

    /**
     * Constructor de un Personal Administrativo con un nombre, dirección, RUN, años de esperiencia y especialidad dado
     * y fecha en el momento que se genera.
     * @param n - Nombre del personal.
     * @param d - Dirección del peronal.
     * @param r - RUN del personal.
     * @param p - Profesión del personal.
     */
    public PersonalAdmin(String n, String d, int r, String p) {
        super(n, d, r);
        this.profesion = p;
    }

    /**
     * Constructor de un Personal Administrativo con un nombre, dirección, RUN, años de esperiencia, especialidad y fecha dado.
     * @param n - Nombre del personal.
     * @param d - Dirección del personal.
     * @param r - Run del personal.
     * @param f - Fecha de ingreso del personal.
     * @param p - Profesión del personal.
     */
    public PersonalAdmin(String n, String d, int r, String f, String p) {
        super(n, d, r, f);
        this.profesion = p;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    /**
     * Genera un String que se usa para imprimir un personal administrativo.
     * @return - String con la linea a imprimir.
     */
    @Override
    public String toString() {
        return "|"+super.getNombre()+"\t|"+super.getDireccion()+"\t|"+super.getRun()+
                "\t|"+super.getFechaIng()+"\t|"+this.getProfesion()+"\t|";
    }
}
