package sistema.taller.mecanico.model;

public class Tarea {
    private String nombre;
    private boolean hecha;
    private String descripcion;

    public Tarea(String nombre, String descripcion) {
        this.nombre = nombre;
        this.hecha = false;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isHecha() {
        return hecha;
    }

    public void setHecha(boolean hecha) {
        this.hecha = hecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        String hechaS = "no";
        if (hecha){
            hechaS = "si";
        }
        return "nombre: "+nombre+", ¿hecha? "+hechaS+", Descripción: "+descripcion;
    }
}
