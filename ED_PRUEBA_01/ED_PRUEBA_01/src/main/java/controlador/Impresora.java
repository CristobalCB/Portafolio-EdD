package controlador;

import modelo.Estudiante;
import modelo.PersonalAdmin;
import modelo.Profesor;
import java.util.ArrayList;
import java.util.Queue;

public class Impresora {

    /**
     * Dado un dos listas de alumnos (Una de espera y otra de registros), imprime los tributos de estos en un especie de tabla.
     * @param estudiantes - Lista de estuiantes matriculados.
     * @param listaEspera - Lista de espera de matriculación.
     */
    public static void imprimirAlumnos (ArrayList<Estudiante> estudiantes, Queue<Estudiante> listaEspera){
        System.out.println("Lista de Alumnos.");
        System.out.println("|Nommbre\t|Dirección\t|RUN\t\t|Fecha Ingreso \t|Nota\t|");
        for (Estudiante e : estudiantes) {
            System.out.println(e.toString());
        }
        System.out.println("\nLista de Espera");
        System.out.println("|Nommbre\t|Dirección\t|RUN\t\t|Fecha Ingreso \t|Nota\t|");
        for (Estudiante e : listaEspera) {
            System.out.println(e.toString());
        }
    }

    /**
     * Dado una lista de profesores, imprime los tributos de estos en un especie de tabla.
     * @param profesores - Lista de profesores trabajando.
     */
    public static void imprimirProfesores(ArrayList<Profesor> profesores){
        System.out.println("Lista Profesores:");
        System.out.println("|Nommbre\t|Dirección\t|RUN\t\t|Fecha Ingreso \t|Años Esperiencia\t|Especialidad\t|");
        for (Profesor p: profesores) {
            System.out.println(p.toString());
        }
    }

    /**
     * Dado una lista de personal Administrativo, imprime los tributos de estos en un especie de tabla.
     * @param personal - Lista de Personal administrativo
     */
    public static void imprimirPersonal(ArrayList<PersonalAdmin> personal) {
        //String n, String d, int r, String p
        System.out.println("Lista de personal Administrativo");
        System.out.println("|Nommbre\t|Dirección\t|RUN\t\t|Fecha Ingreso\t|Profesión\t|");
        for (PersonalAdmin p: personal) {

        }
    }
}
