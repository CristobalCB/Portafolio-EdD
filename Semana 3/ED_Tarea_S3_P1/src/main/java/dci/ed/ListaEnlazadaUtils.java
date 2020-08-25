package dci.ed;

import java.util.*;
public class ListaEnlazadaUtils {

    public static void insertarOrdenado(LinkedList<Integer> lista, int valor) {
        /* Implementar método */
        boolean end = true;
        if(lista == null){
            throw new NullPointerException();
        } else {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i) >= valor) {
                    lista.add(i, valor);
                    end = false;
                    break;
                }
            }
            if (end){
                lista.addLast(valor);
            }
        }
    }

    public static void removerValoresMaximos(LinkedList<String> list, int N) {
        /* Implementar método */
        if(list == null || (N<0)){
            System.out.print("Todas las instancias se han removido");
        } else if(N>list.size()){
            throw new IndexOutOfBoundsException();
        } else {
            int i = 0;
            while(i<N){
                String aux = list.getFirst();
                for (String actualString: list) {
                    if(aux.compareToIgnoreCase(actualString)<0){
                       aux = actualString;
                    }
                }
                list.remove(aux);
                i++;
            }
        }
    }

    public static boolean contieneSubsecuencia(LinkedList<Integer> one, LinkedList<Integer> two) {
        /* Implementar método */
        if(one==null || two==null) { //Excepciones si una o ambas son nulas.
            return false;
        } else if(one.size()==two.size()){ //Comprobación que two cabe en one (igual tamaño)
            for (int i = 0;i<one.size();i++){
                if(one.get(i) != two.get(i)){
                    return false;
                }
            }
            return true;
        } else if(one.size()>two.size()){ //comprobación que two cabe en one (one>=two)
            boolean exist = false;
            for(int i = 0;i<=(one.size()-two.size());i++){
                for(int j = 0;j<two.size();j++){
                    if(one.get(j+i) == two.get(j)){
                        exist = true;
                    } else {
                        exist = false;
                        break;
                    }
                }
                if(exist){ break; }
            }
            return exist;
        } else { //two es mayor que one, no puede ser un subconjunto.
            return false;
        }
    }
}
