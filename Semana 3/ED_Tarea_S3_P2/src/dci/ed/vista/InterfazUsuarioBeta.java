package dci.ed.vista;

import dci.ed.modelo.Inventario;

public class InterfazUsuarioBeta {
    public static void main(String[] args) {
        //
        //Fether,Stratocastor,Eléctrica,Alder,Alder,50000
        Inventario i = new Inventario();
        i.buscarC(0,"Fether",true);
        i.buscarC(1,"",false);
        i.buscarC(2,"",false);
        i.buscarC(3,"",false);
        i.buscarC(4,"",false);
        System.out.println(i.mostrarBusqueda());
    }

}
