package dci.ed.modelo;

public enum TipoGuitarra {

    //Agregar enums faltantes.
    ELECTRICA("electrica"),
    ACUSTICA("acustica");


    private final String tipoguitarra;

    TipoGuitarra(String nombre){
        this.tipoguitarra = nombre;
    }

    public String getTipoguitarra() {
        return tipoguitarra;
    }
}
