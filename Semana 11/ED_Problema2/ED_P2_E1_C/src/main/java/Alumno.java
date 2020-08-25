public class Alumno {
    String nombre;
    String rut;
    String direccion;
    double promedio;
    Curso curso;

    /***
     * Constructor de Alumno
     * @param nombre Nombre del Alumno
     * @param rut Rut del alumno sin puntos y con guión
     * @param curso Curso del alumno
     * @param direccion Direccion del alumno
     * @param promedio promedio del alumno
     */
    Alumno(String rut, String nombre, Curso curso, String direccion, double promedio){
        this.nombre=nombre;
        this.rut=rut;
        this.direccion=direccion;
        this.promedio=promedio;
        this.curso =curso;
    }

    @Override
    public String toString() {
        return "nombre: "+nombre+" rut: "+rut+" Nivel "+ curso + " direccion: "+direccion+" Promedio: "+promedio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return rut.equals(alumno.rut);
    }

}
