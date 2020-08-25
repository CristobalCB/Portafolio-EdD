package sistema.taller.mecanico.model;

public class Mecanico extends Empleado implements Comparable<Empleado>{

    private Director director;

    public Mecanico(int id, String nombre, Departamentos departamento, Director director) {
        super(id, nombre, departamento);
        this.director = director;
    }


    public int compareTo(Empleado empleado) {
        return super.getNombre().compareToIgnoreCase(empleado.getNombre());
    }
}
