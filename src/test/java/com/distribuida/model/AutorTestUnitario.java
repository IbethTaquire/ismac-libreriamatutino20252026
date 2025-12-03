package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutorTestUnitario {

    private Autor autor;

    @BeforeEach
    public void setup(){
        autor = new Autor(1,
                "Charles",
                "Perraul",
                "Francia",
                "Av Francia E32",
                "0985842125",
                "charlesp@correo.com");
    }

    @Test
    public void testAutorConstructor(){

        assertAll("Validar datos del Autor con constructor",
                () ->assertEquals(1,autor.getIdAutor()),
                () ->assertEquals("Charles", autor.getNombre()),
                () -> assertEquals("Perraul",autor.getApellido()),
                () ->assertEquals("Francia", autor.getPais()),
                () ->assertEquals("Av Francia E32",autor.getDireccion ()),
                () ->assertEquals("0985842125", autor.getTelefono()),
                () ->assertEquals("charlesp@correo.com", autor.getCorreo())
        );
    }
    @Test
    public  void testAutorSetters() {

        autor.setIdAutor(2);
        autor.setNombre("Pepe");
        autor.setApellido("Pila");
        autor.setPais("Ecuador");
        autor.setDireccion("Av Tumbaco");
        autor.setTelefono("0999673411");
        autor.setCorreo("pepe@correo.com");

        assertAll("Validar datos del Autor con setters",
                () ->assertEquals(2,autor.getIdAutor()),
                () ->assertEquals(2,autor.getIdAutor()),
                () -> assertEquals("Pepe", autor.getNombre()),
                () -> assertEquals("Pila", autor.getApellido()),
                () -> assertEquals("Ecuador", autor.getPais()),
                () -> assertEquals("Av Tumbaco", autor.getDireccion()),
                () -> assertEquals("0999673411", autor.getTelefono()),
                () -> assertEquals("pepe@correo.com", autor.getCorreo())

        );

    }
    @Test
    public void testAutorToString() {
        String str = autor.toString();

        assertAll("Validar datos del Autor toString",
                () ->assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Charles")),
                () -> assertTrue(str.contains("Perraul")),
                () -> assertTrue(str.contains("Francia")),
                () -> assertTrue(str.contains("Av Francia E32")),
                () -> assertTrue(str.contains("0985842125")),
                () -> assertTrue(str.contains("charlesp@correo.com"))

        );
    }
}
