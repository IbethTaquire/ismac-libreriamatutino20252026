package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTestUnitaria {

    private Cliente cliente;

@BeforeEach
    public void setup(){
        cliente = new Cliente(1,"1720336435"
                ,"Carlos"
                ,"Bejarano"
                ,"Av Quito Chaupimolino"
                ,"0999673411"
                ,"carlos@correo.com");
    }

    @Test

    public void testClienteConstructor(){

    assertAll("Validar datos del Cliente con constructor",
            () ->assertEquals(1, cliente.getIdCliente()),
            () -> assertEquals("1720336435",cliente.getCedula()),
            () ->assertEquals("Carlos", cliente.getNombre()),
            () ->assertEquals("Bejarano", cliente.getApellido ()),
            () ->assertEquals("Av Quito Chaupimolino", cliente.getDireccion()),
            () ->assertEquals("0999673411", cliente.getTelefono()),
            () ->assertEquals("carlos@correo.com", cliente.getCorreo())
            );
    }

    @Test
    public  void testClienteSetters() {

        cliente.setIdCliente(2);
        cliente.setCedula("1720336434");
        cliente.setNombre("Pedro");
        cliente.setApellido("Toaquiza");
        cliente.setDireccion("Av Quito Checa");
        cliente.setTelefono("0998541423");
        cliente.setCorreo("pedrot@correo.com");

        assertAll("Validar datos del Cliente con setters",
        () -> assertEquals(2, cliente.getIdCliente()),
                () -> assertEquals("1720336434", cliente.getCedula()),
                () -> assertEquals("Pedro", cliente.getNombre()),
                () -> assertEquals("Toaquiza", cliente.getApellido()),
                () -> assertEquals("Av Quito Checa", cliente.getDireccion()),
                () -> assertEquals("0998541423", cliente.getTelefono()),
                () -> assertEquals("pedrot@correo.com", cliente.getCorreo())

         );

 }

@Test
    public void testClienteToString(){
    String str= cliente.toString();

    assertAll("Validar datos del cliente toString",

            () -> assertTrue(str.contains("1")),
            () -> assertTrue(str.contains("1720336435")),
            () -> assertTrue(str.contains("Carlos")),
            () -> assertTrue(str.contains("Bejarano")),
            () -> assertTrue(str.contains("Av Quito Chaupimolino")),
            () -> assertTrue(str.contains("0999673411")),
            () -> assertTrue(str.contains("carlos@correo.com"))

            );
}

}


