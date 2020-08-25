package ed.tarea.s11;

import static org.junit.Assert.*;

public class arbolBinarioTest {

    private arbolBinario arbolGeneradoAMano;
    @org.junit.Before
    public void setUp() throws Exception {
        arbolGeneradoAMano = new arbolBinario();
        arbolGeneradoAMano.root = new Nodo(5);
        arbolGeneradoAMano.root.nodoIzquierdo = new Nodo(3);
        arbolGeneradoAMano.root.nodoDerecho = new Nodo(7);
        arbolGeneradoAMano.root.nodoDerecho.nodoDerecho = new Nodo(8);
        arbolGeneradoAMano.root.nodoIzquierdo.nodoDerecho = new Nodo(4);
    }

    @org.junit.Test
    public void agregar() {
        arbolBinario arbolPrueba = new arbolBinario();
        arbolPrueba.agregar(5);
        arbolPrueba.agregar(3);
        arbolPrueba.agregar(7);
        arbolPrueba.agregar(8);
        arbolPrueba.agregar(4);
        assertEquals(5,arbolPrueba.root.valor);
        assertEquals(7,arbolPrueba.root.nodoDerecho.valor);
        assertEquals(8,arbolPrueba.root.nodoDerecho.nodoDerecho.valor);
        assertEquals(4,arbolPrueba.root.nodoIzquierdo.nodoDerecho.valor);

    }

    @org.junit.Test
    public void buscar() {
        assertEquals(false,arbolGeneradoAMano.buscar(1));
        assertEquals(true,arbolGeneradoAMano.buscar(5));
        assertEquals(true,arbolGeneradoAMano.buscar(4));
        assertEquals(false, arbolGeneradoAMano.buscar(-1));
    }

    @org.junit.Test
    public void eliminar() {
        arbolGeneradoAMano.eliminar(5);
        assertEquals(false,arbolGeneradoAMano.buscar(5));
        assertEquals(true,arbolGeneradoAMano.buscar(8));
        assertEquals(true,arbolGeneradoAMano.buscar(3));

    }
}