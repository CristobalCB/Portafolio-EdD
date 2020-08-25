package sistema.seguimiento.mantencion.modelo;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class EmpresaTest {

    private Bus b1, b2;
    private Empresa l1;

    @org.junit.Before
    public void setUp() throws Exception {
        b1 = new Bus("FN-YH-29","NMK898735",(byte) 2,"MERCEDES BENZ",
                LocalDate.of(2017,4,21),110000,4000,
                LocalDate.of(2020,7,21), TipoCarga.PASAJERO,"s1",true,
                "Sin necesidad de mantención",false);
        b2 = new Bus("FN-YH-29","NMK898735",(byte) 2,"MERCEDES BENZ",
                LocalDate.of(2017,4,21),110000,4000,
                LocalDate.of(2020,7,21), TipoCarga.PASAJERO,"s1",false,
                "Fallo en motor",false);
        l1 = new Empresa();
    }

    @org.junit.Test
    public void viaje() {
        Bus exito = new Bus("FN-YH-29","NMK898735",(byte) 2,"MERCEDES BENZ",
                LocalDate.of(2017,4,21),111000,4000,
                LocalDate.of(2020,7,21), TipoCarga.PASAJERO,"s1",false,
                "Se ha excedido los 15000km.",false);

        l1.viaje(b1,1000);
        assertEquals(exito.getKmMantencion(),b1.getKmMantencion());
        assertEquals(exito.getMotivoMantencion(),b1.getMotivoMantencion());
        assertEquals(exito.isMantencion(),b1.isMantencion());
        //Ambos viajes funcionan exactamente igual, salvo el objeto en el que trabajan.
    }

    @org.junit.Test
    public void mantenimiento() {
        Bus exito = new Bus("FN-YH-29","NMK898735",(byte) 2,"MERCEDES BENZ",
                LocalDate.of(2017,4,21),110000,110000,
                LocalDate.now(), TipoCarga.PASAJERO,"s1",true,
                "Sin necesidad de mantención",false);
        l1.mantenimiento(b2);
        assertEquals(exito.isMantencion(),b2.isMantencion());
        assertEquals(exito.getKmMantencion(),b2.getKmMantencion());
        assertEquals(exito.getMotivoMantencion(),b2.getMotivoMantencion());
        assertEquals(exito.getUltimaMantencion().getDayOfMonth(),b2.getUltimaMantencion().getDayOfMonth());
        assertEquals(exito.getUltimaMantencion().getMonthValue(),b2.getUltimaMantencion().getMonthValue());
        assertEquals(exito.getUltimaMantencion().getYear(),b2.getUltimaMantencion().getYear());

    }

    @org.junit.Test
    public void falla() {
        Bus exito = new Bus("FN-YH-29","NMK898735",(byte) 2,"MERCEDES BENZ",
                LocalDate.of(2017,4,21),110000,4000,
                LocalDate.of(2020,7,21), TipoCarga.PASAJERO,"s1",false,
                "Fallo en motor",false);
        l1.falla(b1,"Fallo en motor");
        assertEquals(exito.getMotivoMantencion(),b1.getMotivoMantencion());
        assertEquals(exito.isMantencion(),b1.isMantencion());
    }

    /*
        Los siguientes test no van con assert, son solo para ver si los resultados cuadran con la busqueda.
     */
    @org.junit.Test
    public void sublistasCamion() {
        for (Transporte camion : l1.sublistasCamion(false, false, TipoCarga.ALIMENTO, false)) {
            System.out.println(camion);
        }
        System.out.println("");
        for (Transporte camion : l1.sublistasCamion(false, false, TipoCarga.ALIMENTO, true)) {
            System.out.println(camion);
        }
        System.out.println("");
        for (Transporte camion : l1.sublistasCamion(true, true, TipoCarga.ALIMENTO, true)) {
            System.out.println(camion);
        }
    }

    @org.junit.Test
    public void sublistasBus() {
        for (Transporte b:l1.sublistasBus(false,false,TipoCarga.ENCOMIENDA,true,false)) {
            System.out.println(b);
        }
        System.out.println("");
        for (Transporte b:l1.sublistasBus(false,false,TipoCarga.ENCOMIENDA,true,true)) {
            System.out.println(b);
        }
        System.out.println("");
        for (Transporte b:l1.sublistasBus(true,true,TipoCarga.ENCOMIENDA,true,true)) {
            System.out.println(b);
        }
    }
}