package modelo;

public enum TipoAsig {

    BASICA("Básica"),
    INTERMEDIA("Intermedia"),
    AVANZADA("Avanzada");

    private String tipoAsig;

    TipoAsig(String tA){
        this.tipoAsig = tA;
    }

    public String getTipoAsig(){
        return tipoAsig;
    }
}
