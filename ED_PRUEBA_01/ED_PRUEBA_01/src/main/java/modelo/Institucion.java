package modelo;

import java.util.*;
import controlador.Impresora;
import generador.GeneradorAleatorio;

public class Institucion {

    private Queue<Estudiante> listaEsperaE;
    private Queue<Profesor> listaEsperaP;

    private ArrayList<Profesor> profesores;
    private ArrayList<PersonalAdmin> personal;
    private ArrayList<Apoderado> apoderados;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Asignatura> asignaturas;

    /*
    public static void main(String[] args){
        Institucion i = new Institucion();
    }
*/

    /**
     * Constructor que inicializa y llena las lista de espera, listas de personas y lista de asignaturas de la institución.
     */
    public Institucion(){
        this.listaEsperaE = new LinkedList<>();
        this.listaEsperaP = new LinkedList<>();

        this.profesores = new ArrayList<>();
        this.personal = new ArrayList<>();
        this.apoderados = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        this.asignaturas = new ArrayList<>();
        //llenadoListasAleatorio(); //Cambiar por gestor de archivos cuando este disponible.
    }

    /**
     * Método que agrega datos iniciales aleatorios a cada lista inicial. (Descartable en versión final)
     */
    private void llenadoListasAleatorio(){
        TipoAsig[] tA = TipoAsig.values();
        Especialidad[] e = Especialidad.values();
        for (int i = 0; i < 15; i++) {
            listaEsperaE.add(new Estudiante(GeneradorAleatorio.genNombre(),GeneradorAleatorio.genDireccion(),
                    GeneradorAleatorio.genRun(),GeneradorAleatorio.genFecha(),0.0));
            listaEsperaP.add(new Profesor(GeneradorAleatorio.genNombre(),GeneradorAleatorio.genDireccion(),
                    GeneradorAleatorio.genRun(),GeneradorAleatorio.genFecha(),GeneradorAleatorio.genAñosExp(),
                    e[GeneradorAleatorio.genAtributo()]));
        }
        for (int i = 0; i < 20; i++) {
            profesores.add(new Profesor(GeneradorAleatorio.genNombre(),GeneradorAleatorio.genDireccion(),
                    GeneradorAleatorio.genRun(),GeneradorAleatorio.genFecha(),GeneradorAleatorio.genAñosExp(),
                    e[GeneradorAleatorio.genAtributo()]));
            personal.add(new PersonalAdmin(GeneradorAleatorio.genNombre(),GeneradorAleatorio.genDireccion(),
                    GeneradorAleatorio.genRun(), GeneradorAleatorio.genFecha(),"Inspector"));

            String fechaAE = GeneradorAleatorio.genFecha(); //Para que haya un apoderado por cada alumno (ingresan en la misma fecha)
            apoderados.add(new Apoderado(GeneradorAleatorio.genNombre(),GeneradorAleatorio.genDireccion(),
                    GeneradorAleatorio.genRun(), fechaAE));
            agregarEstudianteSinEspera(new Estudiante(GeneradorAleatorio.genNombre(),GeneradorAleatorio.genDireccion(),
                    GeneradorAleatorio.genRun(),GeneradorAleatorio.genFecha(),GeneradorAleatorio.genNota()));
        }
        for (int i = 0; i < 7; i++) {
            asignaturas.add(new Asignatura("Nombre Asignatura",(int)(GeneradorAleatorio.genNota()),
                    tA[GeneradorAleatorio.genAtributo()]));
        }
    }

    //Métodos refenrentes a alumnos.
    public Queue<Estudiante> getListaEsperaE() {
        return listaEsperaE;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    /**
     * Agrega un alumno sin importar si estaba en la lista de espera o no. Lo agrega en en orden ascendente.
     * @param nuevo - Alumno a agregar.
     */
    public void agregarEstudianteSinEspera(Estudiante nuevo){
        if(nuevo != null){
            boolean end = true;
            for (int i = 0; i < estudiantes.size(); i++) {
                if (estudiantes.get(i).compareTo(nuevo) > 0) {
                    estudiantes.add(i, nuevo);
                    end = false;
                    break;
                }
            }
            if (end){
                estudiantes.add(nuevo);
            }
        }
    }

    /**
     * Toma el alumno al principio de la cola y lo agrega al grupo de alumnos matriculados.
     */
    public void agregarEstudianteConEspera(double nota){
        try {
            Estudiante nuevo = listaEsperaE.poll();
            nuevo.setPromedioG(nota);
            agregarEstudianteSinEspera(nuevo);
        } catch (NullPointerException e){
            System.out.print("Lista de espera vacía");
        }

    }

    /**
     * Registra un alumno en la lista de espera del establecimiento.
     * @param n - nombre del estudiante.
     * @param d - Direccion del estudiante.
     * @param r - Run del estudiante.
     */
    public void registarEstudiante(String n, String d, int r){
        listaEsperaE.add(new Estudiante(n, d, r, 0.0));
    }

    /**
     * Elimina el estudiante un estudiante de la lista.
     * @param estudiante - Estudiante a eliminar.
     */
    public void eliminarEstudiante(Estudiante estudiante){
        if(estudiante != null){
            estudiantes.remove(estudiante);
        }
    }

    /**
     * Llama al método estaticos de la clase impresora entregandole las lista a imprimir.
     */
    public void imprimirEstudiantes(){
        Impresora.imprimirAlumnos(estudiantes, listaEsperaE);
    }

    /**
     * Método que actualiza al nota de un estudiante sacamdolo de la lista, cambiandole la nota y colocandolo otra vez
     * de manera ascendente con su nueva nota.
     * @param e - Estudiante a cambiar de promedio.
     * @param nota - Nuevo promedio del estudiante.
     */
    public void cambiarPromedio(Estudiante e, double nota){
        if (e != null) {
            estudiantes.remove(e);
            e.setPromedioG(nota);
            agregarEstudianteSinEspera(e);
        }
    }
    //Fin métodos referentes a alumnos.

    //Métodos referentes a Profesores.
    public Queue<Profesor> getListaEsperaP() {
        return listaEsperaP;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    /**
     * Agregar un profesor de la cola de espera a la lista de profesores
     */
    public void registarProfesorConEspera(){
        try {
            Profesor aux = listaEsperaP.poll();
            if (aux != null) {
                profesores.add(aux);
            }else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e){
            System.out.print("Lista de espera vacía");
        }
    }

    /**
     * Agrega un profesor directamente e a la lista de profesores.
     * @param profesor - Profesor a agregar.
     */
    public void registrarProfesorsinEspera(Profesor profesor){
        if (profesor != null){
            profesores.add(profesor);
        }
    }

    /**
     * Registra un profesor y lo agrega a la lista de espera.
     * @param n - Nombre del profesor.
     * @param d - Dirección del profesor.
     * @param r - run del profesor.
     * @param aE - Años de experiencia del profesor.
     * @param e - especialidad del profesor.
     */
    public void registrarProfesor(String n, String d, int r, int aE, Especialidad e){
        listaEsperaP.add(new Profesor(n, d, r, aE, e));
    }

    /**
     * Elimina un profesor de la lista de profesores.
     * @param profesor - Profesor a eliminar.
     */
    public void retirarProfesor(Profesor profesor){
        if (profesor != null) {
            profesores.remove(profesor);
        }
    }

    /**
     * Llama a la impresora para imprimir la lista de profesores en forma de tabla.
     */
    public void imprimirProfesores(){
        Impresora.imprimirProfesores(profesores);
    }
    //Fin Métodos referentes a profesores.

    //Métodos referentes a personal administrativos.
    public ArrayList<PersonalAdmin> getPersonal() {
        return personal;
    }

    /**
     * Dado un nombre, dirección, run y profesion, se agrega un nuevo registro a la lista de personal administrativo.
     * @param n - Nombre del personal.
     * @param d - Dirección del personal.
     * @param r - Run del personal.
     * @param p - Profesión del personal.
     */
    public void registrarPerAdmin(String n, String d, int r, String p){
        personal.add(new PersonalAdmin(n, d, r, p));
    }

    /**
     * llama al la clase impresora y le entraga la lista del personal adminsitrativo para que la imprima.
     */
    public void imprimirPerAdmin(){
        Impresora.imprimirPersonal(personal);
    }
    //Fin métodos referentes a profesores.

    public ArrayList<Apoderado> getApoderados() {
        return apoderados;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
}
