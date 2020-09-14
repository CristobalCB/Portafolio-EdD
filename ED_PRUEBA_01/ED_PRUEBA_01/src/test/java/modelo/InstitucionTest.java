package modelo;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class InstitucionTest {


    private Institucion i = new Institucion();

    @Before
    public void setUp() {
        Estudiante e1 = new Estudiante("n1", "d1", 1, 4.2);
        Estudiante e2 = new Estudiante("n2", "d2", 2, 5.3);
        Estudiante e3 = new Estudiante("n3", "d3", 3, 6.3);
        i.getEstudiantes().add(e1);
        i.getEstudiantes().add(e2);
        i.getEstudiantes().add(e3);

        Estudiante le1 = new Estudiante("ne1","de1",1,0.0);
        i.getListaEsperaE().add(le1);

        Profesor p1 = new Profesor("n1", "d1", 1, 1, Especialidad.MATEMATICAS);
        Profesor p2 = new Profesor("n2", "d2", 2, 1, Especialidad.BIOLOGIA);
        Profesor p3 = new Profesor("n3", "d3", 3, 1, Especialidad.HISTORIA);
        i.getProfesores().add(p1);
        i.getProfesores().add(p2);
        i.getProfesores().add(p3);

        Profesor lp1 = new Profesor("np1", "dp1", 1, 1, Especialidad.BIOLOGIA);
        i.getListaEsperaP().add(lp1);

        PersonalAdmin pa1 = new PersonalAdmin("n1", "d1", 1,"p1");
        PersonalAdmin pa2 = new PersonalAdmin("n2", "d2", 2,"p2");
        PersonalAdmin pa3 = new PersonalAdmin("n3", "d3", 3,"p3");
        i.getPersonal().add(pa1);
        i.getPersonal().add(pa2);
        i.getPersonal().add(pa3);
    }

    @Test
    public void agregarEstudianteSinEspera() {
        Estudiante e4 = new Estudiante("n4", "d4", 4, 7.0);
        i.agregarEstudianteSinEspera(e4);
        assertEquals("Al agregar uno debe aumentar su largo a 4.",4,i.getEstudiantes().size());
        assertEquals("El último elemento debe ser e4.",e4,i.getEstudiantes().get(3));

        Estudiante e5 = new Estudiante("n5", "d5", 5, 1.0);
        i.agregarEstudianteSinEspera(e5);
        assertEquals("Al agregar uno debe aumentar su largo a 5.",5,i.getEstudiantes().size());
        assertEquals("El primer elemento debe ser e5",e5,i.getEstudiantes().get(0));

        Estudiante e6 = new Estudiante("n6", "d6", 6, 5.2);
        i.agregarEstudianteSinEspera(e6);
        assertEquals("Al agregar uno debe aumentar su largo a 6.",6,i.getEstudiantes().size());
        assertEquals("El tercer elemento debe ser e6.",e6,i.getEstudiantes().get(2));

        Estudiante e7 = null;
        i.agregarEstudianteSinEspera(e7);
        assertEquals("No deberia hacer nada",6,i.getEstudiantes().size());

    }

    @Test
    public void agregarEstudianteConEspera() {
        PrintStream save_out=System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Estudiante le1 = i.getListaEsperaE().peek();
        le1.setPromedioG(1.0);
        i.agregarEstudianteConEspera(1.0);
        assertEquals("Debe agregar le1 a estudiantes en la primera posición con nota 1.0",
                le1,i.getEstudiantes().get(0));

        i.agregarEstudianteConEspera(2.0);
        assertEquals("No deberia agregar ningun elemento nuevo a estudiantes",
                4,i.getEstudiantes().size());
        assertEquals("La lista esta vacía, deberia decir que lo esta.",
                "Lista de espera vacía", out.toString());
    }

    @Test
    public void registarEstudiante() {
        i.registarEstudiante("ne2","de2", 2);
        assertEquals("Deberia aumentar a 2", 2, i.getListaEsperaE().size());
    }

    @Test
    public void eliminarEstudiante() {
        Estudiante el1 = i.getEstudiantes().get(1);
        i.eliminarEstudiante(el1);
        assertEquals("El número de estudiante deberia ser 2",2,i.getEstudiantes().size());
        assertEquals("El estudiante no deberia estar", false, i.getEstudiantes().contains(el1));

        Estudiante el2 = null;
        i.eliminarEstudiante(el2);
        assertEquals("El número de estudiante deberia ser 2",2,i.getEstudiantes().size());

    }

    @Test
    public void cambiarPromedio() {
        Estudiante cp1 = i.getEstudiantes().get(1);
        i.cambiarPromedio(cp1,7.0);
        assertEquals("Deberia estar al final.", cp1, i.getEstudiantes().get(2));

        ArrayList<Estudiante> lista = i.getEstudiantes();
        i.cambiarPromedio(null, 0.0);
        assertEquals("No deberia hacer nada", lista, i.getEstudiantes());
    }

    @Test
    public void registarProfesorConEspera() {
        PrintStream save_out=System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Profesor lp1 = i.getListaEsperaP().peek();
        i.registarProfesorConEspera();
        assertEquals("Debe agregar la cabeza de la lista de espera a la última posición de la lsita de profesores",
                lp1, i.getProfesores().get(3));

        i.registarProfesorConEspera();
        assertEquals("No deberia agregar ningun elemento nuevo a estudiantes",
                4,i.getProfesores().size());
        assertEquals("La lista esta vacía, deberia decir que lo esta.",
                "Lista de espera vacía", out.toString());
    }

    @Test
    public void registrarProfesorsinEspera() {
        Profesor p4 = new Profesor("n4", "d4", 4, 7, Especialidad.MATEMATICAS);
        i.registrarProfesorsinEspera(p4);
        assertEquals("Al agregar uno, debe aumentar su largo a 4.",4,i.getProfesores().size());
        assertEquals("El último elemento debe ser p4.",p4,i.getProfesores().get(3));

        Estudiante p5 = null;
        i.agregarEstudianteSinEspera(p5);
        assertEquals("No deberia hacer nada",4,i.getProfesores().size());
    }

    @Test
    public void registrarProfesor() {
        i.registrarProfesor("np2", "dp2", 2, 1, Especialidad.HISTORIA);
        assertEquals("Deberia haber un profesor mas en listaEsperaP", 2, i.getListaEsperaP().size());
    }

    @Test
    public void retirarProfesor() {
        Profesor aux = i.getProfesores().get(1);
        i.retirarProfesor(aux);
        assertEquals("No deberia estar el profesor n2", false, i.getProfesores().contains(aux));

        i.retirarProfesor(null);
        assertEquals("No deberia cambiar el tamaño de la lista", 2, i.getProfesores().size());
    }

    @Test
    public void registrarPerAdmin() {
        i.registrarPerAdmin("n4", "d4", 4, "p4");
        assertEquals("El tamaño de la lista de Personal administrativo debio aumentar",
                4, i.getPersonal().size());
    }
}