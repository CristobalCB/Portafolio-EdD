package sistema.seguimiento.mantencion.modelo;

import java.time.LocalDate;

public class Bus extends Transporte {

    private boolean piso2;
    private boolean isbus;

    /**
     * Constructor del bus.
     * @param patente Patente del bus.
     * @param chasis Código del chasis del bus.
     * @param ejes Ejes del bus.
     * @param marca Marca del bus.
     * @param compra Fecha de compra del bus.
     * @param kmActual Kilometraje actual del bus.
     * @param kmMantencion Kilometraje del bus cuando se le realizo la mantención.
     * @param ultimaMantencion Fecha de la última mantención del bus.
     * @param carga Tipo del carga del bus.
     * @param sucursal Sucursal a la que pertertenece o esta el bus.
     * @param mantencion Si la mantención del bus esta al día.
     * @param motivoMantencion Descripción del estado de la mantención del bus.
     * @param piso2 Si posee segundo piso o no.
     */
    public Bus(String patente, String chasis, byte ejes, String marca, LocalDate compra, int kmActual, int kmMantencion,
               LocalDate ultimaMantencion, TipoCarga carga, String sucursal, boolean mantencion,
               String motivoMantencion, boolean piso2) {
        super(patente, chasis, ejes, marca, compra, kmActual, kmMantencion, ultimaMantencion, carga, sucursal,
                mantencion, motivoMantencion);
        this.piso2 = piso2;
        this.isbus = true;
    }

    public boolean isPiso2() {
        return piso2;
    }
    public void setPiso2(boolean piso2) {
        this.piso2 = piso2;
    }

    @Override
    public String toString() {
        return super.toString()+", piso2="+piso2;
    }
}
