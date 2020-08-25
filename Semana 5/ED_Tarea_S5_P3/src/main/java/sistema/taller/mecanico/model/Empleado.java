package sistema.taller.mecanico.model;

import java.util.ArrayList;
import java.util.Objects;

public class Empleado {

    private int id;
    private String nombre;
    private Departamentos Departamento;
    private ArrayList<Tarea> tareas;

    public Empleado(int id, String nombre, Departamentos departamento) {
        this.id = id;
        this.nombre = nombre;
        Departamento = departamento;
        tareas.addAll(departamento.getTareas());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamentos getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(Departamentos departamento) {
        Departamento = departamento;
    }

    public String listarTareas(int value){
        String tareaS = "";
        for (Tarea t : tareas) {
            if((value == 0)||(value == 1 && t.isHecha())||(value == 2 && !t.isHecha())) {
                tareaS = tareaS + t.toString() + '\n';
            }
        }

        return tareaS;
    }

    public void CompletarTarea(int i){
        tareas.get(i).setHecha(true);
    }

    public void agregarTarea(Tarea tarea){
        tareas.add(tarea);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(nombre, empleado.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
