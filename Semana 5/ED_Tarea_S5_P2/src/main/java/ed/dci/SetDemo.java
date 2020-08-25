package ed.dci;

import java.util.ArrayList;

public class SetDemo {

    public ArrayList<Integer>[] buckets;

    private int tamanoActual = 0;
    private double factorIndicador;

    SetDemo(int tamano, double factorIndicador){
        buckets = new ArrayList[tamano];
        for(int i=0;i<tamano;i++){
            buckets[i] = new ArrayList<Integer>();
        }
        this.factorIndicador = factorIndicador;
    }

    /**
     * Función de Hashing de esta claseSet.
     * @param valor - Parámetro de entrada.
     * @return - Valor de la función de hash
     */
    private int hashCode(int valor){
        return valor;
    }

    /**
     * Agrega un objeto donde le corresponde según la funcion de hash.
     * @param valor - Valor a agregar.
     * @return - True: si no estaba presente y se agregó; False: en caso opuesto.
     */
    public boolean add(int valor){
        if (!contiene(valor)){
            int i = hashCode(valor) % buckets.length;
            buckets[i].add(0,valor);
            tamanoActual++;
            double average = tamanoActual / (double) buckets.length;
            if (average > factorIndicador){
                reinsertarTodo();
            }
            return true;
        }
        return false; // modificar si es necesario
    }

    /**
     * Busca con la funcion de hash si el número ingresado se encuantra en la tabla.
     * @param valor - Número a buscar.
     * @return - True: si se encuentra; False: si no.
     */
    public boolean contiene(int valor){
        int i = hashCode(valor) % buckets.length;
        return buckets[i].contains(valor); // modificar si es necesario
    }

    /**
     * Reescalado del tamaño de los buckets del set para la mantención de la eficiencia de busqueda.
     */
    private void reinsertarTodo(){
        ArrayList<Integer>[] oldBuckets = buckets;
        buckets = new ArrayList[oldBuckets.length * 2];
        for(int i=0;i<(oldBuckets.length*2);i++){
            buckets[i] = new ArrayList<Integer>();
        }
        for (ArrayList<Integer> arrayList : oldBuckets) {
            for ( int element : arrayList ) {
                int i = hashCode(element) % buckets.length;
                buckets[i].add(0,element);
            }
        }

    }
}
