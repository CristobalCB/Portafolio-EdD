package sistema.taller.mecanico.model;

import java.util.HashSet;

public class TallerMecanico {

    private HashSet<Director> directors;
    private HashSet<Mecanico> mecanicos;

    public TallerMecanico(HashSet<Director> directors, HashSet<Mecanico> mecanicos) {
        this.directors = directors;
        this.mecanicos = mecanicos;
    }

    public Director buscarDirector(String nombre){
        if (directors.contains(new Director(0, nombre, null))){
            return directors.
        }

    }
}
