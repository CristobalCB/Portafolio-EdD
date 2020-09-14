package modelo;

public enum Especialidad {
    BIOLOGIA("Biología"),
    MATEMATICAS("Matemáticas"),
    HISTORIA("Historia");

    private String especialidad;

    Especialidad(String e){
        especialidad = e;
    }

    public String getEspecialidad() {
        return especialidad;
    }

}
