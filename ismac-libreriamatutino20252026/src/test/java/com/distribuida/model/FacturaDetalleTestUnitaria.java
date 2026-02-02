package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FacturaDetalleTestUnitaria {

    private FacturaDetalle facturaDetalle;
    private Factura factura;
    private Libro libro ;


    @BeforeEach
    public void setup(){
        facturaDetalle = new FacturaDetalle();

        facturaDetalle.setIdFacturaDetalle(1);
        facturaDetalle.setCantidad(10);
        facturaDetalle.setSubtotal(new BigDecimal("20.00"));


        factura = new Factura();

        factura.setIdFactura(1);
        factura.setNumFactura("FAC-001");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.00);
        factura.setIva(15.00);
        factura.setTotal(115.00);


        libro = new Libro();

        libro.setIdLibro(1);
        libro.setTitulo("Caperucita Roja");
        libro.setEditorial("Editorial X");
        libro.setNumPaginas(300);
        libro.setEdicion("Primera");
        libro.setIdioma("Español");
        libro.setFechaPublicidad(new Date());
        libro.setDescripcion("Libro de Cuentos Infantiles");
        libro.setTipoPasta("Rústica");
        libro.setIsbn("1234567890");
        libro.setNumEjemplares(50);
        libro.setPortada("portada.jpg");
        libro.setPresentacion("Tapa blanda");
        libro.setPrecio(55.0);

        //Inyeccion de dependencias

        facturaDetalle.setFactura(factura);
        facturaDetalle.setLibro(libro);

    }
    @Test
    public void testFacturaDetalleConstructor(){
        assertAll("Validad datos del Constructor - Factura Detalle",
                        () ->assertEquals(1, facturaDetalle.getIdFacturaDetalle()),
                        () ->assertEquals(10,facturaDetalle.getCantidad()),
                        () ->assertEquals(20.00,facturaDetalle.getSubtotal())

        );

    }
    @Test
    public void testFacturaDetalleToString() {
        String str = facturaDetalle.toString();

        assertAll("Validar datos de toString - FacturaDetalle",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("10")),
                () -> assertTrue(str.contains("20.0")),


                () -> assertTrue(str.contains("FAC-001")),
                () -> assertTrue(str.contains("115.0")),


                () -> assertTrue(str.contains("Caperucita Roja")),
                () -> assertTrue(str.contains("Tapa blanda"))
        );
    }



    @Test
    public void testFacturaDetalleInyeccion(){
        assertAll("Validar metodo inyector",
                () -> assertNotNull(facturaDetalle.getFactura()),
                () -> assertNotNull(facturaDetalle.getLibro()),

                () -> assertEquals("FAC-001",facturaDetalle.getFactura().getNumFactura()),
                () -> assertEquals(115.00,facturaDetalle.getFactura().getTotal()),

                () -> assertEquals("Caperucita Roja",facturaDetalle.getLibro().getTitulo()),
                () -> assertEquals("Español",facturaDetalle.getLibro().getIdioma())

                );
    }
}
