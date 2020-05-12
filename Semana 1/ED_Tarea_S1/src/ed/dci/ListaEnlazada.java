package ed.dci;

public class ListaEnlazada {
    // variables miembro de la clase Lista Enlazada
    Nodo cabeza = null;
    Nodo cola = null;

    /*
     *  Método que permite agregar un elemento
     *  al frente de la Lista Enlazada
     */
    public void agregarFrente(int valor) {
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
    public void agregarFinal(int valor) {
        // implementar
        Nodo nuevo = new Nodo(valor);
        if(cabeza!=null) {
            Nodo puntero = cabeza;
            while(puntero.siguiente!=null) {
                puntero = puntero.siguiente;
            }
            puntero.siguiente = nuevo;
            cola = nuevo;
        } else {
            cabeza = nuevo;
            cola = nuevo;
        }
    }

    /*
     *  Método que permite agregar un elemento
     *  en un índice específico de la Lista Enlazada
     */
    public void agregarEnIndice(int index, int valor) {
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
    public void imprimirLista(ListaEnlazada nombreLista){
        if (cabeza != null) {
            Nodo aux = cabeza;
            while (aux != null){
                System.out.print("[ "+aux.valor+" ]");
                aux = aux.siguiente;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {

    }
}
