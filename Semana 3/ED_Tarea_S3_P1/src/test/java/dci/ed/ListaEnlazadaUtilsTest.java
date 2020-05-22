package dci.ed;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.*;

public class ListaEnlazadaUtilsTest{

    private LinkedList<Integer> listLarga;
    private LinkedList<Integer> list2Corta;
    private LinkedList<Integer> list3Corta;
    private LinkedList<Integer> listVacia;
    private LinkedList<String> listStrings;
    private LinkedList<String> listStringsVacia;

    @Before
    public void prepare(){
        listLarga = new LinkedList<Integer>();
        listLarga.add(1);
        listLarga.add(2);
        listLarga.add(3);
        listLarga.add(4);
        listLarga.add(5);
        listLarga.add(6);
        listLarga.add(9);

        list2Corta = new LinkedList<Integer>();
        list2Corta.add(4);
        list2Corta.add(5);
        list2Corta.add(6);

        list3Corta = new LinkedList<Integer>();
        list3Corta.add(20);
        list3Corta.add(45);
        list3Corta.add(46);

        listVacia = new LinkedList<Integer>();

        listStrings = new LinkedList<String>();
        listStrings.add("b");
        listStrings.add("c");
        listStrings.add("d");
        listStrings.add("a");
        listStrings.add("e");
        listStrings.add("f");
        listStrings.add("g");
        listStrings.add("c");

        listStringsVacia = new LinkedList<String>();
    }
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testInsertarOrdenado() {
        ListaEnlazadaUtils.insertarOrdenado(listLarga,7);//agregar en medio
        assertEquals(7,listLarga.get(6).intValue());

        ListaEnlazadaUtils.insertarOrdenado(list2Corta,7);//agregar al final
        assertEquals(7,list2Corta.get(3).intValue());

        ListaEnlazadaUtils.insertarOrdenado(list2Corta,1);//agregar al principio
        assertEquals(1,list2Corta.get(0).intValue());

        exceptionRule.expect(NullPointerException.class);//null
        ListaEnlazadaUtils.insertarOrdenado(null,1);
    }

    @Test
    public void testRemoverValoresMaximos() {
        LinkedList<String> aux = new LinkedList<String>();
        aux.add("b");
        aux.add("a");
        ListaEnlazadaUtils.removerValoresMaximos(listStrings,6);//elemento que aparece 2 veces
        assertEquals(aux,listStrings);

        ListaEnlazadaUtils.removerValoresMaximos(aux,2);//Borrar all
        assertEquals(listStringsVacia,aux);
    }

    @Test
    public void testRemoverValoresMaximosTodasLasInstacias() {
        PrintStream save_out=System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        ListaEnlazadaUtils.removerValoresMaximos(null,10);
        assertEquals("Todas las instancias se han removido",out.toString());

        out.reset();
        ListaEnlazadaUtils.removerValoresMaximos(listStrings,-10);
        assertEquals("Todas las instancias se han removido",out.toString());
    }

    @Test
    public void testRemoverValoresMaximosIndexOutOfBounce() {
        exceptionRule.expect(IndexOutOfBoundsException.class);
        ListaEnlazadaUtils.removerValoresMaximos(listStrings,9);
    }

    @Test
    public void testContieneSubsecuencia() {
        assertEquals(true,ListaEnlazadaUtils.contieneSubsecuencia(listLarga,list2Corta));//funcionaa
        assertEquals(false,ListaEnlazadaUtils.contieneSubsecuencia(null,list2Corta));//null
        assertEquals(false,ListaEnlazadaUtils.contieneSubsecuencia(listLarga,null));//null
        assertEquals(false,ListaEnlazadaUtils.contieneSubsecuencia(listVacia,list2Corta));//lista vacia
        assertEquals(true,ListaEnlazadaUtils.contieneSubsecuencia(listVacia,listVacia));//si ambas estan vacias
        assertEquals(false,ListaEnlazadaUtils.contieneSubsecuencia(list2Corta,listLarga));//si la primera es mas grande que la segunda
        assertEquals(true,ListaEnlazadaUtils.contieneSubsecuencia(list2Corta,list2Corta));//si ambas son del mismo porte e iguales
        assertEquals(false,ListaEnlazadaUtils.contieneSubsecuencia(list2Corta,list3Corta));//si ambas son del mismo porte y distintas
        assertEquals(false,ListaEnlazadaUtils.contieneSubsecuencia(listLarga,list3Corta));//si no lo encuentra
    }
}