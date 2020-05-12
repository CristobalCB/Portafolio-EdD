package dci.ed;

public class Cola {
    
    // agregar los elementos que permiten implementar una Cola
    Nodo rear = null;
    Nodo front = null;
    /*
     *  Método que permite agregar al final de la rear
     */
    public void agregarEnCola(int valor){
        // implementar
        Nodo nuevo = new Nodo(valor);
        if (front==null){
            front = nuevo;
        } else {
            Nodo aux = front;
            while(aux.siguiente != null){
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
        rear = nuevo;
    }

    /*
     *  Método que permite remover desde el frente de la rear
     */
    public void removerDesdeFrente(){
        // implementar
        if (front == null){
            throw new NullPointerException();
        } else {
            if (front.siguiente == null){
                rear = null;
            }
            front = front.siguiente;
        }
    }

}
