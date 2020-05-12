package dci.ed;

import java.util.Calendar;

public class ListaEnlazada {

    Nodo cabeza = null;
    Nodo cola = null;

    /*
     *  Método que permite si un valor particular
     *  existe en la Lista Enlazada
     */
    public boolean contiene(int valor){
        // implementar
        if(cabeza != null) {
            Nodo aux = cabeza;
            while (aux != null) {
                if (aux.valor == valor) {
                    return true;
                }
                aux = aux.siguiente;
            }
        }
        return false;
    }

    /*
     *  Método que permite obtener un valor determinado
     *  en una posición específica de una la Lista Enlazada
     */
    public int getPorIndice(int index){
        // implementar
        if (cabeza == null) {
            throw new NullPointerException();
        } else if (index < 0){
            throw new IndexOutOfBoundsException();
        } else {
            Nodo aux = cabeza;
            for (int i = 0; i < index; i++) {
                if (aux.siguiente == null) {
                    throw new IndexOutOfBoundsException();
                }
                aux = aux.siguiente;
            }
            return aux.valor;
        }
    }

    /*
     *  Método que permite remover un valor
     *  desde el frente de una la Lista Enlazada
     */
    public void removerDesdeFrente(){
        // implementar
        if (cabeza == null){
            throw new NullPointerException();
        } else if (cabeza.equals(cola)){
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.siguiente;
        }
    }

    /*
     *  Método que permite remover un valor
     *  desde la rear una la Lista Enlazada
     */
    public void removerDesdeCola() {
        // implementar
        if ( cabeza == null ) {
            throw new NullPointerException();
        } else if ( cabeza.equals(cola) ) {
            cabeza = null;
            cola = null;
        } else {
            Nodo aux = cabeza;
            while ( aux.siguiente != cola ) {
                aux = aux.siguiente;
            }
            cola = aux;
            aux.siguiente = null;
        }
    }

    /*
     *  Método que permite remover un valor determinado
     *  en una posición específica de una la Lista Enlazada
     */
    public void removerEnIndice(int index){
        // implementar
        if (index < 0){
            throw new IndexOutOfBoundsException();
        } else if (cabeza == null){
            throw new  NullPointerException();
        } else if (index == 0) {
            removerDesdeFrente();
        } else {
            Nodo aux = cabeza;
            for ( int i = 0 ; i < index-1; i++ ){
                if (aux == null) {
                    throw new IndexOutOfBoundsException();
                }
                aux = aux.siguiente;
            }
            aux.siguiente = aux.siguiente.siguiente;
            if(aux.siguiente == null){
                cola = aux;
            }
        }
    }

    /*
     *  Método que permite agregar un elemento
     *  al frente de la Lista Enlazada
     */
    public void agregarFrente(int valor){
        // implementar
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null){
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        }
    }

    /*
     *  Método que permite agregar un elemento
     *  al final la Lista Enlazada
     */
    public void agregarFinal(int valor){
        // implementar
        Nodo nuevo = new Nodo(valor);
        if(cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            Nodo puntero = cabeza;
            while(puntero.siguiente!=null) {
                puntero = puntero.siguiente;
            }
            puntero.siguiente = nuevo;
            cola = nuevo;
        }
    }

    /*
     *  Método que permite agregar un elemento
     *  en un índice específico de la Lista Enlazada
     */
    public void agregarEnIndice(int index, int valor){
        // implementar
        Nodo nuevo = new Nodo(valor);
        if (index < 0){
            throw new IndexOutOfBoundsException();
        } else {
            Nodo aux = cabeza;
            for ( int i = 0 ; i < index-1 ; i++ ){
                if (aux == null){
                    throw new IndexOutOfBoundsException();
                }
                aux = aux.siguiente;
            }
            if (aux.siguiente == null){
                aux.siguiente = nuevo;
                cola = nuevo;
            } else {
                nuevo.siguiente = aux.siguiente;
                aux.siguiente = nuevo;
            }
        }
    }

    /*
     *  Método que permite imprimir los elementos
     *  de la Lista Enlazada
     */
    public void imprimirLista(ListaEnlazada nombreLista) {
        // implementar
        if (cabeza != null) {
            Nodo aux = cabeza;
            while (aux != null){
                System.out.print("[ "+aux.valor+" ]");
                aux = aux.siguiente;
            }
            System.out.println("");
        }
    }

}
