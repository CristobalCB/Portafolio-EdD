package cl.ufro.dci.ed.model;

import java.util.TreeSet;

public class Liga {

    private String nombre;
    private String pais;
    private TreeSet <Equipo> equipos;

    /**
     *
     * @param nombre nombre de la liga
     * @param pais pais en que se juega la liga
     */
    public Liga(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        this.equipos = new TreeSet<>();
    }

    public void agregarEquipo (Equipo equipo) {
        if (this.equipos.size() > 20) {
            System.out.println("No puedes agregar más de 20 equipos");
        } else {
            this.equipos.add(equipo);
        }
    }

    public TreeSet <Equipo> getEquipos() {
        return equipos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
