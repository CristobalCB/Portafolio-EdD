package sistema.taller.mecanico.model;

import java.util.ArrayList;

public class Director extends Empleado implements Comparable<Director>{

    ArrayList<Mecanico> mecanicos;

    public Director(int id, String nombre, Departamentos departamento) {
        super(id, nombre, departamento);
        mecanicos = new ArrayList<Mecanico>();
    }

    public ArrayList<Mecanico> getMecanicos() {
        return mecanicos;
    }

    public void addMecanico(Mecanico mecanico){
        mecanicos.add(mecanico);
    }

    public void removeMecanico(int index){
        mecanicos.remove(index);
    }

    public int compareTo(Director director) {
        return super.getNombre().compareToIgnoreCase(director.getNombre());
    }
}
