package com.distribuida.principal;

import com.distribuida.model.Cliente;
import com.distribuida.model.Factura;
import com.distribuida.model.FacturaDetalle;
import com.distribuida.model.Libro;

import java.math.BigDecimal;
import java.util.Date;


public class FacturaDetallePrincipal {

    public static void main(String[] args) {

        //factura detalle
        FacturaDetalle facturaDetalle = new FacturaDetalle ();

        facturaDetalle.setIdFacturaDetalle(1);
        facturaDetalle.setCantidad(10);
        facturaDetalle.setSubtotal(new BigDecimal("20.00"));

        //factura
        Factura factura = new Factura();

        factura.setIdFactura(1);
        factura.setNumFactura("FAC-0001");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.00);
        factura.setIva(15.00);
        factura.setTotal(115.00);



        //libro
        Libro libro  = new Libro();
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


        //inyeccion de dependencias
        facturaDetalle.setFactura(factura);
        facturaDetalle.setLibro(libro);


        System.out.println(facturaDetalle.toString());
        System.out.println(libro.toString());
        System.out.println(factura.toString());


    }




}
