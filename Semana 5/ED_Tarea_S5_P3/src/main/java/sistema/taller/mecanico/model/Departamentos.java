package sistema.taller.mecanico.model;

import java.util.ArrayList;

public enum Departamentos {
    MOTOR("Motor","Reparar","Ver el fallo y corregirlo"),
    FRENOS("Frenos","Calibrar:Revisión","Assegurarse que frenen lo mismo:Checker el correcto funcionamiento"),
    GASES("Gases","Cambio","Remplazar los existente por nuevos");

    private String nombre;
    private ArrayList<Tarea> tareas;

    Departamentos(String nombre, String Ntareas, String descripciones){
        this.nombre = nombre;
        tareas = new ArrayList<Tarea>();
        String[] tareasA = Ntareas.split(":");
        String[] descripcionesA = descripciones.split(":");
        for (int i = 0; i < tareasA.length; i++) {
            this.tareas.add(new Tarea(tareasA[i], descripcionesA[i]));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }
}
