package com.distribuida.principal;

import com.distribuida.model.Cliente;
import com.distribuida.model.Factura;

import java.util.Date;

public class FacturaPrincipal {

    public static  void main(String[] ags){

        Cliente cliente = new Cliente(1,
                "1728171503",
                "Erick",
                "Chiran",
                "Av.Quito Selva Alegre",
                "0985842125",
                "erick@correo.com");

        Factura factura = new Factura();

        factura.setIdFactura(1);
        factura.setNumFactura("FAC-0001");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.00);
        factura.setIva(15.00);
        factura.setTotal(115.00);

        //inyección de dependencias
        factura.setCliente(cliente);

        System.out.println(factura.toString());

    }
}
