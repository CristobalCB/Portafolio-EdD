package sistema.seguimiento.mantencion.modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.TreeSet;

public class Empresa {

    private TreeSet<Transporte> transportes;
    private final LocalDate actual = LocalDate.now();

    /**
     * Constructor, llena la lista y comprueva que los transportes inscritos ho hayan superado los 6 meses sin mantención.
     */
    public Empresa(){
        transportes = new TreeSet<>();
        llenarlista();
        time();
    }

    /**
     * Agrega los km recorridos por un transporte y verifica si se le ha hecho la revision por exceder los 15000km.
     * @param transporte Transporte que realiza el viaje.
     * @param km kilometros recorridos durante el viaje
     */
    public void viaje(Transporte transporte, int km){
        transporte.setKmActual(transporte.getKmActual() + km);
        if (transporte.getKmActual() > 15000 && transporte.getKmMantencion() < 15000){
            transporte.setMantencion(false);
            transporte.setMotivoMantencion("Se ha excedido los 15000km.");
        }
    }

    /**
     * Revisa si los transportes registrados tiene  mas de 6 meses sin revision desde la fecha actual.
     */
    private void time(){
        long period;
        for (Transporte transporte : transportes) {
            period = Period.between(transporte.getUltimaMantencion(),actual).toTotalMonths();
            if (period > 6){
                transporte.setMantencion(false);
                transporte.setMotivoMantencion("Última revisión hace 6 meses.");
            }
        }
    }

    /**
     * Inicia los camiones y buses es sus correspondientes listas, se puede poner un lector de base de dato aqui en
     * lugar de esto.
     */
    private void llenarlista(){
        transportes.add(new Bus("FN-YH-29","NMK898735",(byte) 2,"MERCEDES BENZ",
                LocalDate.of(2017,4,21),110000,4000,
                LocalDate.of(2020,7,21), TipoCarga.PASAJERO,"s1",true,
                "Sin necesidad de mantención",false));
        transportes.add(new Bus("MH-ZP-18","PTG852853",(byte) 4,"MERCEDES BENZ",
                LocalDate.of(2016,12,21),85000,18000,
                LocalDate.of(2015,12,9), TipoCarga.ENCOMIENDA,"s1",true,
                "Sin necesidad de mantención",true));
        transportes.add(new Bus("GD-LZ-21","KHJ667261",(byte) 2,"MERCEDES BENZ",
                LocalDate.of(2019,5,23),50000,47000,
                LocalDate.of(2013,12,19), TipoCarga.ENCOMIENDA,"s1",true,
                "Sin necesidad de mantención",true));
        transportes.add(new Bus("LM-AS-32","MVB777254",(byte) 4,"SCANIA",
                LocalDate.of(2019,2,28),20000,15000,
                LocalDate.of(2015,12,19), TipoCarga.PASAJERO,"s1",true,
                "Sin necesidad de mantención",true));
        transportes.add(new Camion("HI-OO-99","AAJF44411",(byte) 2,"VOLVO",
                LocalDate.of(2015,3,4),35000,34000,
                LocalDate.of(2013,12,19),TipoCarga.ALIMENTO,"s1",
                true,"Sin necesidad de mantención"));
        transportes.add(new Camion("LM-WW-18","KDJ887441",(byte) 2,"VOLVO",
                LocalDate.of(2018,4,6),111000,23000,
                LocalDate.of(2013,12,19),TipoCarga.ALIMENTO,"s1",
                true,"Sin necesidad de mantención"));
        transportes.add(new Camion("WW-AZ-56","JJJ637344",(byte) 2,"SCANIA",
                LocalDate.of(2019,8,9),11000,5000,
                LocalDate.of(2020,7,19),TipoCarga.ALIMENTO,"s1",
                true,"Sin necesidad de mantención"));
        transportes.add(new Camion("TYD-EF-32","KDD662311",(byte) 2,"SCANIA",
                LocalDate.of(2013,3,1),211000,200000,
                LocalDate.of(2013,12,19),TipoCarga.ALIMENTO,"s1",
                true,"Sin necesidad de mantención"));

    }

    /**
     * Registra si se ha hecho la mentención
     * @param transporte Transporte el cual se registra su mantención.
     */
    public void mantenimiento(Transporte transporte){
        transporte.mantencion();
    }

    /**
     * Registra si ha surguido algo que haga que la mantencion ser requerida.
     * @param transporte Transporte el cual se registra el fallo.
     * @param motivo Descripción del fallo.
     */
    public void falla(Transporte transporte, String motivo){
        transporte.setMantencion(false);
        transporte.setMotivoMantencion(motivo);

    }

    /**
     * Método que entrega la lista de camiones con los parametros de busqueda solicidados.7
     * @param todos Si se piden todos los datos.
     * @param mantencion Se requiere el camion con mantención al día.
     * @param tipo Que tipo de carga transporta.
     * @param menorkm Se requiere que se muestren solo los que tienen menor kilometraje
     * @return TreeSet con los datos separados.
     */
    public TreeSet<Transporte> sublistasCamion(boolean todos, boolean mantencion, TipoCarga tipo, boolean menorkm){
        TreeSet<Transporte> busqueda = new TreeSet<>(),
                aux1 = new TreeSet<>();
        busqueda.addAll(transportes);
        for (Transporte t : busqueda) {
            if (t.getCarga().equals("Construcción") || t.getCarga().equals("Alimento")){
                aux1.add(t);
            }
        }
        busqueda.clear();
        busqueda.addAll(aux1);
        aux1.clear();

        if (todos) {
            return busqueda;
        }

        for (Transporte transporte : busqueda) {
            if (transporte.isMantencion() == mantencion) {
                aux1.add(transporte);
            }
        }
        busqueda.clear();
        busqueda.addAll(aux1);
        aux1.clear();

        for (Transporte transporte : busqueda) {
            if (transporte.getCarga().equals(tipo.getTipo())) {
                aux1.add(transporte);
            }
        }
        busqueda.clear();
        busqueda.addAll(aux1);
        aux1.clear();

        if (!mantencion && menorkm) {
            for (Transporte transporte : busqueda) {
                if (transporte.getKmActual() < 60000) {
                    aux1.add(transporte);
                }
            }
            busqueda.clear();
            busqueda.addAll(aux1);
        }

        return busqueda;
    }

    /**
     * Método que entrega la lista de buses con los parametros de busqueda solicidados.
     * @param todos Piden todos los datos.
     * @param mantencion Se requiere el bus con mantención al día.
     * @param tipo Que tipo de carga transporta.
     * @param piso2 Se necesitan buses de 2 pisos.
     * @param menorkm Se requiere que se muestren solo los que tienen menor kilometraje
     * @return TreeSet con los datos separados.
     */
    public TreeSet<Transporte> sublistasBus(boolean todos, boolean mantencion, TipoCarga tipo, boolean piso2, boolean menorkm){
        TreeSet<Transporte> busqueda = new TreeSet<>(),
                aux1 = new TreeSet<>();
        busqueda.addAll(transportes);

        for (Transporte t : busqueda) {
            if (t.getCarga().equals("Pasajero") || t.getCarga().equals("Encomienda")){
                aux1.add(t);
            }
        }
        busqueda.clear();
        busqueda.addAll(aux1);
        aux1.clear();

        if (todos) {
            return busqueda;
        }

        for (Transporte transporte:busqueda) {
            if (transporte.isMantencion() == mantencion) {
                aux1.add(transporte);
            }
        }
        busqueda.clear();
        busqueda.addAll(aux1);
        aux1.clear();

        for (Transporte transporte:busqueda) {
            if (transporte.getCarga().equalsIgnoreCase(tipo.getTipo())) {
                aux1.add(transporte);
            }
        }
        busqueda.clear();
        busqueda.addAll(aux1);
        aux1.clear();

        for (Transporte transporte:busqueda) {
            Bus bus = (Bus) transporte;
            if (bus.isPiso2() == piso2) {
                aux1.add(bus);
            }
        }
        busqueda.clear();
        busqueda.addAll(aux1);
        aux1.clear();

        if(!mantencion && menorkm) {
            for (Transporte transporte:busqueda) {
                if (transporte.getKmActual() < 60000) {
                    aux1.add(transporte);
                }
            }
            busqueda.clear();
            busqueda.addAll(aux1);

        }
        return busqueda;
    }

}
