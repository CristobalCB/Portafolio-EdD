package dci.ed.modelo;

import dci.ed.controlador.AdministradorArchivo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventario {
    private List<Guitarra> listaGuitarras;
    private List<Guitarra> listaBusqueda;

    /**
     * Constructor que inicializa la lista principal y la llena con las guitarras registradas y leidas por el
     * AdministradorArchivo
     */
    public Inventario() {
        listaGuitarras = new LinkedList();
        ArrayList<String[]> datos = AdministradorArchivo.leerArchivo();
        for (String[] s : datos) {
            agregarGuitarra(s);
        }
    }

    /**
     * Método que a través de un arreglo de String crea una guitarra con esas características, los índices del arreglo
     * deben ser:
     * 0. numeroSerie
     * 1. fabricante
     * 2. modelo
     * 3. tipo,
     * 4. maderaPosterior
     * 5. maderaFrontal
     * 6. precio,
     * 7. stock
     * @param linea - Arreglo de String que contiene las características de la guitarra a crear.
     */
    public void agregarGuitarra(String[] linea) {
        listaGuitarras.add(new Guitarra(Integer.parseInt(linea[0]),
                linea[1], linea[2], linea[3], linea[4], linea[5],
                Double.parseDouble(linea[6]), Integer.parseInt(linea[7])));
    }

    /*
    public Guitarra obtenerGuitarra(String numeroSerie) {
        Iterator<Guitarra> iterador = listaGuitarras.iterator();
        while (iterador.hasNext()) {
            Guitarra guitarra = iterador.next();
            if (guitarra.getNumeroSerie().equals(numeroSerie)) {
                return guitarra;
            }
        }
        return null;
    }
    */ //ObtenerGuitarra() ya no es requerido.

    /**
     * Inicio una busqueda nueva reiniciando listaBusqueda si aux es true.
     * @param aux - boleano que define si la busqueda es desde 0.
     */
    private void nuevaBusqueda(boolean aux){
        if (aux){
            listaBusqueda = new LinkedList();
            this.listaBusqueda.addAll(listaGuitarras);
        }
    }

    /**
     * Método que elimina los elementos de la listaBusqueda que no coincidan con el parámetro ingresado.
     * @param tipo - int que define que parámetro se esta comparando
     *             0 => Fabricante.
     *             1 => Modelo.
     *             2 => Tipo.
     *             3 => Madera posterior.
     *             4 => Madera frontal.
     * @param caracteristica - Valor de la característica que se evalua.
     * @param nueva True => busqueda desde 0.
     *              false => busqueda con la listaBusqueda actual.
     */
    public void buscarC(int tipo, String caracteristica, boolean nueva){
        nuevaBusqueda(nueva);
        Iterator<Guitarra> iterador = listaBusqueda.iterator();
        while (iterador.hasNext()) {
            Guitarra guitarra = iterador.next();
            if(caracteristica.equals("")){
                continue;
            } else if (tipo == 0 && guitarra.getFabricante().equals(caracteristica)) {
                continue;
            } else if (tipo == 1 && guitarra.getModelo().equals(caracteristica)) {
                continue;
            }else if (tipo == 2 && guitarra.getTipo().equals(caracteristica)) {
                continue;
            }else if (tipo == 3 && guitarra.getMaderaPosterior().equals(caracteristica)) {
                continue;
            }else if (tipo == 4 && guitarra.getMaderaFrontal().equals(caracteristica)) {
                continue;
            } else {
                listaBusqueda.remove(guitarra);
            }
        }
    }

    /**
     * Método que elimina los elementos de la listaBusqueda que cuyo precio no se encuentre entre los valores ingresados.
     * (La interfaz de usuario debería asegurarse que precioMax>=PrecioMin)
     * @param precioMin - Precio mínimo dispuesto a pagar.
     * @param precioMax - Precio maximo dispuesto a pagar.
     * @param nueva True => busqueda desde 0.
     *              false => busqueda con la listaBusqueda actual.
     */
    public void buscarP(double precioMin, double precioMax, boolean nueva){
        nuevaBusqueda(nueva);
        Iterator<Guitarra> iterador = listaBusqueda.iterator();
        while (iterador.hasNext()) {
            Guitarra guitarra = iterador.next();
            double precio = guitarra.getPrecio();
            if(precio>=precioMin && precio<=precioMax){
                continue;
            } else {
                listaBusqueda.remove(guitarra);
            }
        }
    }

    public String mostrarBusqueda(){
        return listaBusqueda.toString();
    }

    /*
    public Guitarra buscar(Guitarra guitarraBuscada) {

        Iterator<Guitarra> iterador = listaGuitarras.iterator();

        while (iterador.hasNext()) {

            Guitarra guitarra = iterador.next();
            String fabricante = guitarraBuscada.getFabricante();
            if ((fabricante != null) && (!fabricante.equals("")) &&
                    (!fabricante.equals(guitarra.getFabricante()))) {
                continue;
            }

            String modelo = guitarra.getModelo();
            if ((modelo != null) && (!modelo.equals("")) &&
                    (!modelo.equals(guitarra.getModelo()))){
                continue;
            }

            String tipo = guitarra.getTipo();
            if ((tipo != null) && (!tipo.equals("")) &&
                    (!tipo.equals(guitarra.getTipo()))){
                continue;
            }

            String maderaPosterior = guitarra.getMaderaPosterior();
            if ((maderaPosterior != null) && (!maderaPosterior.equals("")) &&
                    (!maderaPosterior.equals(guitarra.getMaderaFrontal()))){
                continue;
            }

            String maderaFrontal = guitarra.getMaderaFrontal();
            if ((maderaFrontal != null) && (!maderaFrontal.equals("")) &&
                    (!maderaFrontal.equals(guitarra.getMaderaFrontal()))){
                continue;
            }

        }
        return null;
    }
    */ //Buscar() ya no es requerido.

}
