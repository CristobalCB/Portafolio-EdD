import cl.ufro.dci.ed.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Object;

import java.text.ParseException;

public class Tests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private Liga serieA;
    private Equipo juventus;
    private Equipo milan;
    private Equipo inter;
    private Futbolista cristiano;
    private Futbolista dybala;
    private Futbolista higuain;

    @Before
    public void prepare() throws ParseException {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        serieA = new Liga("serie A","Italia");
        juventus = new Equipo("Juventus","Turin","nose","juventus Estadium",82);
        milan = new Equipo("Milan","Milan","nose","Giuzepe Meaza",70);
        inter = new Equipo("Inter de Milan","Milan","nose","San Siro",81);
        cristiano = new Futbolista("Cristiano Ronaldo",33,"Portugal",1.88,84,7,93,1000000,70000000, Posicion.EXTREMO_IZQUIERDO);
        dybala = new Futbolista("Paulo Dybala",24,"Argentina",1.70,70,10,89,800000,80000000, Posicion.MEDIAPUNTA);
        higuain = new Futbolista("Gonzalo Higuain",30,"Argentina",1.75,80,9,90,900000,40000000, Posicion.DELANTERO_CENTRO);
        juventus.agregarJugador(dybala);
        juventus.agregarJugador(cristiano);
        juventus.agregarJugador(higuain);
        cristiano.setEquipo(juventus);
        dybala.setEquipo(juventus);
        higuain.setEquipo(juventus);
        serieA.agregarEquipo(milan);
        serieA.agregarEquipo(juventus);
        serieA.agregarEquipo(inter);
    }

    @Test
    public void mostrarEquipos() {
        assertEquals(new Equipo("Juventus","Turin","nose","juventus Estadium",82),serieA.getEquipos().pollFirst());
    }

    @Test
    public void mostrarJugadores() {
        Futbolista cristianoRonaldo = new Futbolista("Cristiano Ronaldo",33,"Portugal",1.88,84,7,93,1000000,70000000, Posicion.EXTREMO_IZQUIERDO);
        cristianoRonaldo.setEquipo(juventus);
        assertEquals(cristianoRonaldo,juventus.getJugadores().pollFirst());
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

}
