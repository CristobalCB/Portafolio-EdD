package sistema.seguimiento.mantencion.modelo;

import java.time.LocalDate;

public class Camion extends Transporte {

    private boolean isCamion;
    /**
     * Se reconoce que esta clase, por si misma, no amerita serlo, mas por temas de diseño y representación se creó.
     * @param patente Patente del camión.
     * @param chasis Código del chasis del camión.
     * @param ejes Ejes del camión.
     * @param marca Marca del Camión.
     * @param compra Fecha de compra del camión.
     * @param kmActual Kilometraje actual del camión.
     * @param kmMantencion Kilometraje del camión cuando se le realizo la mantención.
     * @param ultimaMantencion Fecha de la última mantención del camión.
     * @param carga Tipo del carga del camión.
     * @param sucursal Sucursal a la que pertertenece o esta el camión.
     * @param mantencion Si la mantención del camión esta al día.
     * @param motivoMantencion Descripción del estado de la mantención del camión.
     */
    public Camion(String patente, String chasis, byte ejes, String marca, LocalDate compra, int kmActual,
                  int kmMantencion, LocalDate ultimaMantencion, TipoCarga carga, String sucursal,
                  boolean mantencion, String motivoMantencion){
        super(patente, chasis, ejes, marca, compra, kmActual, kmMantencion, ultimaMantencion, carga,
                    sucursal, mantencion, motivoMantencion);
        this.isCamion = true;
    }



}
