package sistema.seguimiento.mantencion.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Transporte implements Comparable<Transporte> {

    private String patente;
    private String chasis;
    private byte ejes;
    private String marca;
    private LocalDate compra;
    private int kmActual;
    private int kmMantencion;
    private LocalDate ultimaMantencion;
    private TipoCarga carga;
    private String sucursal;
    private boolean mantencion;
    private String motivoMantencion;

    /**
     * Constructor con todos los parametros que necesita la clase.
     * @param patente Patente del vehiculo
     * @param chasis Código del chasis.
     * @param ejes Cantidad de ejes.
     * @param marca Marca del vehiculo.
     * @param compra Fecha de compra.
     * @param kmActual Kilometraje actual registrado.
     * @param kmMantencion Kilometraje en su última mantención
     * @param ultimaMantencion Fecha de su última mantención.
     * @param carga Tipo de carga que transporta.
     * @param sucursal Sucursal a la que pertenece o esta.
     * @param mantencion Si se le ha hecho la mantención
     * @param motivoMantencion Descripción de su estado de mantención
     */
    public Transporte(String patente, String chasis, byte ejes, String marca, LocalDate compra, int kmActual,
                      int kmMantencion, LocalDate ultimaMantencion, TipoCarga carga, String sucursal,
                      boolean mantencion, String motivoMantencion) {
        this.patente = patente;
        this.chasis = chasis;
        this.ejes = ejes;
        this.marca = marca;
        this.compra = compra;
        this.kmActual = kmActual;
        this.kmMantencion = kmMantencion;
        this.ultimaMantencion = ultimaMantencion;
        this.carga = carga;
        this.sucursal = sucursal;
        this.mantencion = mantencion;
        this.motivoMantencion = motivoMantencion;
    }

    /**
     * Cambia los datos de la última mantención, km, fecha, estado y su descripción de estado.
     */
    public void mantencion(){
        kmMantencion = kmActual;
        ultimaMantencion = LocalDate.now();
        mantencion = true;
        motivoMantencion = "Sin necesidad de mantención";
    }

    public String getPatente() {
        return patente;
    }
    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getChasis() {
        return chasis;
    }
    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDate getCompra() {
        return compra;
    }
    public void setCompra(LocalDate compra) {
        this.compra = compra;
    }

    public int getKmActual() {
        return kmActual;
    }
    public void setKmActual(int kmActual) {
        this.kmActual = kmActual;
    }

    public int getKmMantencion() {
        return kmMantencion;
    }

    public LocalDate getUltimaMantencion() {
        return ultimaMantencion;
    }

    public String getCarga() {
        return carga.getTipo();
    }
    public void setCarga(TipoCarga carga) {
        this.carga = carga;
    }

    public String getSucursal() {
        return sucursal;
    }
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public boolean isMantencion() {
        return mantencion;
    }
    public void setMantencion(boolean mantencion) {
        this.mantencion = mantencion;
    }

    public String getMotivoMantencion() {
        return motivoMantencion;
    }
    public void setMotivoMantencion(String motivoMantencion) {
        this.motivoMantencion = motivoMantencion;
    }

    @Override
    public int compareTo(Transporte transporte){
        if (this.getUltimaMantencion().compareTo(transporte.getUltimaMantencion()) == 0){
            return 1;
        } else {
            return this.getUltimaMantencion().compareTo(transporte.getUltimaMantencion());
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Transporte)) {
            return false;
        }
        Transporte that = (Transporte) o;
        return  patente.equals(that.patente) &&
                Objects.equals(chasis, that.chasis) &&
                Objects.equals(marca, that.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.patente, this.ultimaMantencion);
    }

    @Override
    public String toString() {
        return "Transporte: "+"patente="+patente+ ", chasis="+chasis+", ejes="+ejes+", marca="+marca+", compra="+compra+
                ", kmActual="+kmActual+", kmMantencion="+kmMantencion+", ultimaMantencion="+ultimaMantencion+", carga="+carga+
                ", sucursal="+sucursal+", mantencion="+mantencion+", motivoMantencion="+motivoMantencion;
    }
}
