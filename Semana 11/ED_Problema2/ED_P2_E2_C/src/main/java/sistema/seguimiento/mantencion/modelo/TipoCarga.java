package sistema.seguimiento.mantencion.modelo;

public enum  TipoCarga {
    PASAJERO("Pasajero",false),
    ENCOMIENDA("Encomienda",false),
    ALIMENTO("Alimento", true),
    CONSTRUCCION("Construcción", true);

    private String tipo;
    private boolean camion;

    TipoCarga(String tipo, boolean camion) {
        this.tipo = tipo;
        this.camion = camion;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isCamion() {
        return camion;
    }

    @Override
    public String toString() {
        return  tipo;
    }
}
