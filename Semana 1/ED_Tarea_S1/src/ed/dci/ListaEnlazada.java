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
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        if(cola==null) {
            cola = cabeza;
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
        if(cabeza!=null) {
            Nodo puntero = cabeza;
            for(int i = 0;i<index;i++){
                if(puntero.siguiente==null) { break; }
                puntero = puntero.siguiente;
            }
            nuevo.siguiente = puntero.siguiente;
            puntero.siguiente = nuevo;
        } else {
            cabeza = nuevo;
            cola = nuevo;
        }
    }

    /*
     *  Método que permite imprimir los elementos
     *  de la Lista Enlazada
     */
    public void imprimirLista(ListaEnlazada nombreLista){
        if(nombreLista.cabeza!=null) {
            Nodo puntero = nombreLista.cabeza;
            do {
                System.out.println("[ "+ puntero.valor +" ]");
                puntero = puntero.siguiente;
            } while(cabeza.siguiente!=null);
        }
    }

    public static void main(String[] args) {

    }
}
