package bst;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BSTTest {

    private BST arbolGeneradoAMano;
    @org.junit.Before
    public void setUp() throws Exception {
        arbolGeneradoAMano = new BST();
        arbolGeneradoAMano.root = new Nodo(5);
        arbolGeneradoAMano.root.leftChild = new Nodo(3);
        arbolGeneradoAMano.root.rightChild = new Nodo(7);
        arbolGeneradoAMano.root.rightChild.rightChild = new Nodo(8);
        arbolGeneradoAMano.root.leftChild.rightChild = new Nodo(4);
    }

    @org.junit.Test
    public void agregar() {
        BST arbolPrueba = new BST();
        arbolPrueba.agregar(5);
        arbolPrueba.agregar(3);
        arbolPrueba.agregar(7);
        arbolPrueba.agregar(8);
        arbolPrueba.agregar(4);
        assertEquals(arbolGeneradoAMano.root.valor,
                arbolPrueba.root.valor);
        assertEquals(arbolGeneradoAMano.root.rightChild.valor,
                arbolPrueba.root.rightChild.valor);
        assertEquals(arbolGeneradoAMano.root.rightChild.rightChild.valor,
                arbolPrueba.root.rightChild.rightChild.valor);
        assertEquals(arbolGeneradoAMano.root.leftChild.rightChild.valor,
                arbolPrueba.root.leftChild.rightChild.valor);
    }

    @org.junit.Test
    public void eliminarRoot() {
        arbolGeneradoAMano.eliminar(5);
        assertEquals(false,arbolGeneradoAMano.buscar(arbolGeneradoAMano.root,5));
        assertEquals(true,arbolGeneradoAMano.buscar(arbolGeneradoAMano.root, 8));
        assertEquals(true,arbolGeneradoAMano.buscar(arbolGeneradoAMano.root, 3));
    }

    @org.junit.Test
    public void eliminarHoja() {
        arbolGeneradoAMano.eliminar(4);
        assertEquals(false,arbolGeneradoAMano.buscar(arbolGeneradoAMano.root,4));
        assertEquals(true,arbolGeneradoAMano.buscar(arbolGeneradoAMano.root, 3));
    }

    @org.junit.Test
    public void eliminarPadre() {
        arbolGeneradoAMano.eliminar(3);
        assertEquals(false,arbolGeneradoAMano.buscar(arbolGeneradoAMano.root,3));
        assertEquals(true,arbolGeneradoAMano.buscar(arbolGeneradoAMano.root, 4));
    }

    @org.junit.Test
    public void eliminarVacioYNodoNoExistente() {
        PrintStream save_out=System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        BST arbolVacio = new BST();
        arbolVacio.eliminar(0);
        assertEquals("Árbol vacío.",out.toString());

        out.reset();
        arbolGeneradoAMano.eliminar(0);
        assertEquals("Valor no encontrado.",out.toString());

    }
}