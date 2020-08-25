import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EstablecimientoTest {

    Establecimiento establecimiento;
    @Test
    public void buscarAlumno() {
    agregarAlumnos();
    assertEquals(new Alumno("21627774-5", "Adolfo Mellado", Curso.CUARTOB,
            "Las lilas 6739", 6.8),establecimiento.buscarAlumno("21627774-5"));
    }

    @Test
    public void listaAlumnosPorRut() {
        agregarAlumnos();
        ArrayList<Alumno> lista =  establecimiento.ListaAlumnosPorRut();
        assertEquals(new Alumno("20412274-1", "Michelle Naour", Curso.CUARTOB,"San Martin 367",
                6.3),lista.get(0));
        assertEquals(new Alumno("21887277-5", "Ignacia Garrido", Curso.TERCEROA,"Miraflores 1206",
                4.9),lista.get(3));
        assertEquals(new Alumno("23637524-k", "Carolina Peña", Curso.SEGUNDOB,"Chorrillos 989",
                5.1),lista.get(5));
    }

    public void agregarAlumnos(){
        establecimiento= new Establecimiento();
        establecimiento.agregarAlumno("20412274-1", "Michelle Naour", Curso.CUARTOB,"San Martin 367", 6.3);
        establecimiento.agregarAlumno("22378371-1", "Camilo Mora", Curso.PRIMEROB,"Avenida Prat 366", 5.6);
        establecimiento.agregarAlumno("21552616-3", "Eduardo Castillo", Curso.TERCEROA,"Las Heras 2603", 4.2);
        establecimiento.agregarAlumno("21627774-5", "Adolfo Mellado", Curso.CUARTOB,"Las lilas 6739", 6.8);
        establecimiento.agregarAlumno("23637524-k", "Carolina Peña", Curso.SEGUNDOB,"Chorrillos 989", 5.1);
        establecimiento.agregarAlumno("21887277-5", "Ignacia Garrido", Curso.TERCEROA,"Miraflores 1206", 4.9);
    }

}