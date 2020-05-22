package dci.ed.modelo;

public enum TipoMadera {
    //Seguir agregando enums faltantes.
    ALDER("Alder"),
    PINO("Pino"),
    ROBLE("Roble"),
    ALERCE("Alerce");

    private final String tipoMadera;

    TipoMadera(String tipoMadera){
        this.tipoMadera=tipoMadera;
    }

    public String getTipoMadera() {
        return tipoMadera;
    }
}
