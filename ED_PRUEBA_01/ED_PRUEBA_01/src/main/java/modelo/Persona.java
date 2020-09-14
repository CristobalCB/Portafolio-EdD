package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona {

    protected String nombre, direccion;
    protected int run;
    protected LocalDate fechaIng;

    /**
     * Contructor que genera unq persona con un nombre, direccion y run dado y con fecha de ingreso del mismo instante
     * en que se genera.
     * @param n - Nombre de la persona.
     * @param d - Direccion de la persona.
     * @param r - Run de la persona.
     */
    protected Persona(String n, String d, int r) {
        this.nombre = n;
        this.direccion = d;
        this.run = r;
        this.fechaIng = LocalDate.now();
    }

    /**
     * Contructor que genera una persona con un nombre, direccion, run y con fecha dada.
     * @param n - Nombre de la persona.
     * @param d - Direccion de la persona.
     * @param r - Run de la persona.
     * @param f - Fecha en la cual se ingreso la persona Formato "dd/MM/yyyy".
     */
    protected Persona(String n, String d, int r, String f) {
        this.nombre = n;
        this.direccion = d;
        this.run = r;
        this.fechaIng = LocalDate.parse(f, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public String getFechaIng() {
        return fechaIng.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
    }

    public void setFechaIng(LocalDate fechaIng) {
        this.fechaIng = fechaIng;
    }
}
