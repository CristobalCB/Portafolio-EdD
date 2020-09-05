package ed.tarea.s11;

public class arbolBinario {

    protected Nodo root;

    /**
     * Creación de un árbol binario con un valor inicial.
     * @param valor Valor inicial (Esta será la raíz).
     */
    arbolBinario(int valor) {
        root = new Nodo(valor);
    }

    /**
     * Creación de un árbol binario sin valor inicial.
     */
    arbolBinario() {
        root = null;
    }

    /**
     * Método recursivo que crea un nodo si el nodo es nulo o desiga a la derecha o izquierda del nodo actual (Según
     * orden numérico, de ser igual lo agrega a la derecha), un valor dado.
     * @param actual Nodo actual en el que esta trabajando.
     * @param valor Valor que tiene que agregar.
     * @return si el nodo es nulo, agrega uno con el valor, sino devuelve su mismo nodo (para no destruir el árbol)
     */
      private Nodo agregarNodo(Nodo actual, int valor) {
        if (actual == null){
            return new Nodo(valor);
        } else {
            if (valor < actual.valor) {
                actual.nodoIzquierdo = agregarNodo(actual.nodoIzquierdo, valor);
            } else {
                actual.nodoDerecho = agregarNodo(actual.nodoDerecho, valor);
            }
            return actual;
        }
    }

    /**
     *  Método público que llama al método privado para que este agregue un nodo con el valor dado.
     * @param value Valor a agregar.
     */
    public void agregar(int value) {
        root = agregarNodo(root,value);
    }

    /**
     * Si el nodo entregado tiene el valor entrega verdadero, sino y si tiene algún hijo, busca en sus hijos y en caso de
     * que nunguno se cumpla devueve falso.
     * @param actual Nodo en el que trabaja.
     * @param valor Valor que busca.
     * @return si se encuentra el valor en el nodo o en algun nodo se su sub-árbol.
     */
    private boolean buscarNodo(Nodo actual, int valor) {
        if (actual.valor == valor){
            return true;
        } else if (actual.nodoDerecho != null || actual.nodoIzquierdo != null){
            if (actual.nodoIzquierdo != null && valor < actual.valor){
                return buscarNodo(actual.nodoIzquierdo,valor);
            }
            if (actual.nodoDerecho != null && valor > actual.valor){
                return buscarNodo(actual.nodoDerecho,valor);
            }
            return false;
        } else {
            return false;
        }
    }

    /**
     * Método público que inicia el método privado y recursivo de busqueda.
     * @param valor Valor a buscar.
     * @return Respuesta de la busqueda.
     */
    public boolean buscar(int valor) {
        if (root == null) {
            return false;
        } else {
            return buscarNodo(root, valor);
        }
    }

    /**
     *
     * @param actual Nodo en el que se trabaja.
     * @param valor Valor a eliminar.
     * @return
     */
    private Nodo eliminarNodo(Nodo actual, int valor) {
        if (actual == null){
            throw new NullPointerException("Nodo no encontrado.");
        } else if (valor < actual.valor){
            Nodo izquierdo = eliminarNodo(actual.nodoIzquierdo,valor);
            actual.nodoIzquierdo = izquierdo;
        } else if (valor > actual.valor){
            Nodo derecho = eliminarNodo(actual.nodoDerecho,valor);
            actual.nodoDerecho = derecho;
        } else {
            Nodo aEliminar = actual;
            if (aEliminar.nodoDerecho == null){
                actual = aEliminar.nodoIzquierdo;
            } else if (aEliminar.nodoIzquierdo == null){
                actual = aEliminar.nodoDerecho;
            } else {
                aEliminar = reemplazarNodo(aEliminar);
            }
            aEliminar = null;
        }
        return actual;
    }

    private Nodo reemplazarNodo(Nodo aEliminar){
        Nodo padre = aEliminar;
        Nodo hijoMayor = aEliminar.nodoIzquierdo;
        while (hijoMayor.nodoDerecho != null){
            padre = hijoMayor;
            hijoMayor = hijoMayor.nodoDerecho;
        }
        aEliminar.valor = hijoMayor.valor;
        if (padre == aEliminar){
            padre.nodoIzquierdo = hijoMayor.nodoIzquierdo;
        }else {
            padre.nodoDerecho = hijoMayor.nodoIzquierdo;
        }
        return hijoMayor;
    }

    /**
     * Comprueba que el árbol no este vacío y de no estarlo ejecuta el método de eliminacin recursiva´.
     * @param valor - Valor a eliminar.
     */
    public void eliminar(int valor) {
        if (root == null){
            System.err.println("Árbol vacío");
        } else {
            root = eliminarNodo(root,valor);

        }
    }
}



