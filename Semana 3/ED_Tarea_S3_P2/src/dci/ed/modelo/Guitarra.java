package dci.ed.modelo;

public class Guitarra {
    private int numeroSerie, stock;
    private String fabricante, modelo, tipo, maderaPosterior, maderaFrontal;
    private double precio;

    public Guitarra(int numeroSerie, String fabricante, String modelo, String tipo,
                    String maderaPosterior, String maderaFrontal, double precio,
                    int stock){
        this.numeroSerie = numeroSerie;
        this.precio = precio;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.tipo = tipo;
        this.maderaPosterior = maderaPosterior;
        this.maderaFrontal = maderaFrontal;
        this.stock = stock;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMaderaPosterior() {
        return maderaPosterior;
    }

    public String getMaderaFrontal() {
        return maderaFrontal;
    }

    public double getPrecio() {
        return precio;
    }

    /**
     * Utilizado para editar el precio de una guitarra.
     * @param precio - nuevo precio.
     */
    public void cambiarPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Disminuye el stock en 1, si este no es 0, simulando una venta.
     */
    public void venta(){
        if (stock > 0){
            stock--;
        }
    }

    /**
     * entrega el formato para poder ser almacenado cuando termine el programa.
     * @return - String con los datos de la guitarra.
     *      * 0. numeroSerie
     *      * 1. fabricante
     *      * 2. modelo
     *      * 3. tipo,
     *      * 4. maderaPosterior
     *      * 5. maderaFrontal
     *      * 6. precio,
     *      * 7. stock
     */
    public String guardar() {
        return numeroSerie + ","  + fabricante + "," + modelo +
                "," + tipo + "," + maderaPosterior + "," + maderaFrontal +
                "," + precio + "," + stock + '\n';
    }

    @Override
    public String toString() {
        return "Guitarra{" +
                "numeroSerie=" + numeroSerie +
                ", stock=" + stock +
                ", fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", maderaPosterior='" + maderaPosterior + '\'' +
                ", maderaFrontal='" + maderaFrontal + '\'' +
                ", precio=" + precio +
                '}';
    }
}
