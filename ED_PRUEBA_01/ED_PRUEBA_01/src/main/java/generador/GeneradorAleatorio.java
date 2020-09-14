package generador;

import java.util.Random;

public class GeneradorAleatorio {

    private static Random r = new Random();

    private static final String[] nombres = { "Andrea", "Aarón", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar",
            "Barry", "Bartolo", "Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina",
            "Carisa", "Caritina", "Carlota", "Baltazar", "Emilio", "Enrique", "Francisco", "Jeremy", "Harrison", "Jordan",
            "Matthew", "Dante", "Elian", "Dylan", "Max", "Andrés", "Jorge", "Lucas", "Darío", "Anthony", "Connor", "Arno",
            "Angela", "Candy", "Caty", "Dana", "Erica", "Mara", "Vega", "Estela", "Beatriz", "Cayetana", "Ivonne"};
    private static final String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso",
            "Cariaga", "Carillo", "Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia",
            "Griego", "Grigalva", "Altamirano", "Arrollo", "Becerril", "Barba", "Bonilla", "Campos", "Cuervo", "Carvallo",
            "Cervantes", "De la Rosa", "Domínguez", "Enríquez", "Escobar", "Echeverría", "Ferrer", "Fraga", "Funez",
            "Guardado", "Garrido", "Gutiérrez", "Gámez", "Hierro", "Hernández", "Icaza", "Jaramillo", "Jurado", "Lira",
            "Leyva", "Leyva", "Medina", "Moscoa", "Noguera", "Novales", "Zambrano", "Triguero", "Segura", "Saucedo"};

    public static String genNombre(){

        return nombres[r.nextInt(nombres.length-1)]+" "+apellidos[r.nextInt(apellidos.length-1)];
    }

    public static int genRun(){
        return 19000000 + r.nextInt(2000000);
    }

    public static String genDireccion(){
        return apellidos[r.nextInt(apellidos.length-1)]+" N# "+r.nextInt(999);
    }

    public static String genFecha(){
        int mes = 1+r.nextInt(11);
        int dia =1+r.nextInt(27);
        String smes = ""+mes;
        String  sdia = ""+dia;
        if (mes<10){
            smes = "0"+mes;
        }
        if (dia<10){
            sdia = "0"+dia;
        }
        return sdia+"/"+smes+"/"+(1980+r.nextInt(40));
    }

    public static double genNota(){
        return (double)(10+r.nextInt(60))/10;
    }

    public static int genAñosExp(){
        return 5+r.nextInt(35);
    }

    public static int genAtributo(){
        return r.nextInt(2);
    }
}

