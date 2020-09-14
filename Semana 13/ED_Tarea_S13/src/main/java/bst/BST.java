package bst;

public class BST {

    // Raíz del BST
    Nodo root = null;

    // Constructor según valor
    BST(int value) {
        root = new Nodo(value);
    }

    // Constructor por defecto
    BST() {
        root = null;
    }

    // Buscar nodo con determinado valor
    public boolean buscar(Nodo nodo, int value) {
        // Caso base: la raíz del BST root es null
        if (nodo == null) {
            return false;
        }
        // Caso base: el valor la raíz del BST root
        // no es null y es igual que valor
        if (nodo.valor == value) {
            return true;
            // Caso valor del nodo es mayor que el que se busca,
            // el nodo debe estar en el sub árbol izquierdo
        } else if (nodo.valor > value) {
            return buscar(nodo.leftChild, value);
        } else {
            // Caso valor del nodo es menor que el que se busca,
            // el nodo debe estar en el sub árbol derecho
            return buscar(nodo.rightChild, value);
        }
    }

    /**
     *  Método público que llama al método privado para que este agregue un nodo con el valor dado.
     * @param value Valor a agregar.
     */
    public void insertar(int value) {
        root = insertarNodo(root,value);
    }

    /**
     * Método recursivo que crea un nodo si el nodo es nulo o desiga a la derecha o izquierda del nodo actual (Según
     * orden numérico, de ser igual lo agrega a la derecha), un valor dado.
     * @param actual Nodo actual en el que esta trabajando.
     * @param valor Valor que tiene que agregar.
     * @return si el nodo es nulo, agrega uno con el valor, sino devuelve su mismo nodo (para no destruir el árbol)
     */
    private Nodo insertarNodo(Nodo actual, int valor) {
        if (actual == null){
            return new Nodo(valor);
        } else {
            if (valor < actual.valor) {
                actual.leftChild = insertarNodo(actual.leftChild, valor);
            } else {
                actual.rightChild = insertarNodo(actual.rightChild, valor);
            }
            return actual;
        }
    }

    /**
     * Comprueba que el árbol no este vacío y de no estarlo ejecuta el método de eliminacin recursiva´.
     * @param valor Valor a eliminar.
     */
    public void eliminar(int valor) {
        if (root == null){
            System.out.print("Árbol vacío.");
        } else {
            root = eliminarNodo(root,valor);

        }
    }

    /**
     * Primero busca el nodo a eliminar, y una vez encontrado comprueba si tiene algun hijo, de no tenerlo lo asigna nulo,
     * de tener uno, lo asigna como su hijo, y de tener dos reemplaza el nodo usando el método reemplazarNodo().
     * @param actual Nodo en el que se trabaja.
     * @param valor Valor a eliminar.
     * @return El nodo con el que esta trabajando para no alterar el árbol.
     */
    private Nodo eliminarNodo(Nodo actual, int valor) {
        if (actual == null) {
            System.out.print("Valor no encontrado.");
        } else if (valor < actual.valor){
            Nodo izquierdo = eliminarNodo(actual.leftChild,valor);
            actual.leftChild = izquierdo;
        } else if (valor > actual.valor){
            Nodo derecho = eliminarNodo(actual.rightChild,valor);
            actual.rightChild = derecho;
        } else {
            Nodo aEliminar = actual;
            if (aEliminar.rightChild == null){
                actual = aEliminar.leftChild;
            } else if (aEliminar.leftChild == null){
                actual = aEliminar.rightChild;
            } else {
                aEliminar = reemplazarNodo(aEliminar);
            }
            aEliminar = null;
        }
        return actual;
    }

    /**
     * Busca el nodo mayor del sub-arbol con los hijos menores e intercambia el valor del nodo a eliminar por el mayor
     * de los menores
     * @param aEliminar Nodo a eliminar
     * @return Nodo menor del nodo a eliminar.
     */
    private Nodo reemplazarNodo(Nodo aEliminar){
        Nodo padre = aEliminar;
        Nodo hijoMayor = aEliminar.leftChild;
        while (hijoMayor.rightChild != null){
            padre = hijoMayor;
            hijoMayor = hijoMayor.rightChild;
        }
        aEliminar.valor = hijoMayor.valor;
        if (padre == aEliminar){
            padre.leftChild = hijoMayor.leftChild;
        }else {
            padre.rightChild = hijoMayor.leftChild;
        }
        return hijoMayor;
    }
}

