import java.util.ArrayList;
import java.util.TreeMap;

public class Establecimiento {
    TreeMap<String, Alumno> alumnos;

    Establecimiento(){
        alumnos= new TreeMap<>();
    }

    Alumno buscarAlumno(String rut){
        return alumnos.get(rut);
    }

    /**
     * Crea un alumno con los parámetros que tienem agrega este alumno al TreeMap usando el Rut como key
     * @param nombre Nombre del Alumno que se quiere agregar
     * @param rut Rut del alumno sin puntos y con guión del alumno que se quiere agregar
     * @param curso Curso del alumno que se quiere agregar
     * @param direccion Direccion del alumno que se quiere agregar
     * @param promedio promedio del alumno que se quiere agregar
     * @return
     */
    void agregarAlumno(String rut, String nombre, Curso curso, String direccion, double promedio){
        Alumno alumno= new Alumno(rut,nombre,curso,direccion,promedio);
        alumnos.put(rut,alumno);
    }

    /**
     *Itera por el TreeMap y agrega cada alumno a un ArrayList
     * @return un ArrayList con todos los alumnos del establecimiento ordenados por Rut
     */
    ArrayList<Alumno> ListaAlumnosPorRut(){
        ArrayList<Alumno> ArrayListAlumnosPorRut= new ArrayList<>();
        for (Alumno alumno: alumnos.values()){
            ArrayListAlumnosPorRut.add(alumno);
        }
        return ArrayListAlumnosPorRut;
    }
}
