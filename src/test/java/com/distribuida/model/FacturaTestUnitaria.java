package com.distribuida.model;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FacturaTestUnitaria {

    private Factura factura;
    private Cliente cliente;

    @BeforeEach
    public void setup(){

        cliente = new Cliente(1,"1720336435"
                ,"Carlos"
                ,"Bejarano"
                ,"Av Quito Chaupimolino"
                ,"0999673411"
                ,"carlos@correo.com");

        factura = new Factura();

        factura.setIdFactura(1);
        factura.setNumFactura("FAC-001");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.00);
        factura.setIva(15.00);
        factura.setTotal(115.00);

        //Inyeccion de Dependencias
        factura.setCliente(cliente);

    }

    @Test
    public void testFacturaConstruct(){

        assertAll("Validar datos del Constructor - Factura",
                () -> assertEquals(1,factura.getIdFactura()),
                () -> assertEquals("FAC-001",factura.getNumFactura()),
                //() -> assertEquals(new Date(), factura.getFecha()),
                () -> assertEquals(100.00, factura.getTotalNeto()),
                () -> assertEquals(15.00, factura.getIva()),
                () -> assertEquals(115.00, factura.getTotal())

                );
    }

    @Test
    public void testFacturaSetter(){
        cliente = new Cliente(2,"1720336435","Carlos","Bejarano","Av Quito Chaupimolino","0985842125","carlos@correo.com");

        factura = new Factura();

        factura.setIdFactura(2);
        factura.setNumFactura("FAC-002");
        factura.setFecha(new Date());
        factura.setTotalNeto(200.00);
        factura.setIva(30.00);
        factura.setTotal(230.00);

        //test en inyeccion de dependencias

        factura.setCliente(cliente);

        assertAll("Validar metodos setter - Factura",
                () -> assertEquals(2,factura.getIdFactura()),
                () -> assertEquals("FAC-002",factura.getNumFactura()),
                //() -> assertEquals(new Date(), factura.getFecha()),
                () -> assertEquals(200.00, factura.getTotalNeto()),
                () -> assertEquals(30.00, factura.getIva()),
                () -> assertEquals(230.00, factura.getTotal()),
                () -> assertEquals("1720336435", factura.getCliente().getCedula())
                );
    }

    @Test
    public void  testFacturaToString(){
        String str =factura.toString();

        assertAll("Validar datos de toString - Factura",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("FAC-001")),
                () -> assertTrue(str.contains("100.0")),
                () -> assertTrue(str.contains("15.0")),
                () -> assertTrue(str.contains("115.0")),
                () -> assertTrue(str.contains("Carlos"))
                );
    }

@Test
    public void testFacturaInyeccion(){

        assertAll("Validar dato metodo inyector",
                () -> assertNotNull(factura.getCliente()),
                () ->assertEquals("Bejarano", factura.getCliente().getApellido())
                );
}

@Test
    public void testFacturaValoresNegativos(){

        factura.setTotal(-100.00);
        assertAll("Validar datos negativos -Factura",
                () -> assertEquals(-100.00,factura.getTotal())
                );

        //validar que se evite valores negativos.
}

}
