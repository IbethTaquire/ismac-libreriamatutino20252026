package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoriaTestUnitario {

    private Categoria categoria;

    @BeforeEach
     public void setup(){

        categoria = new Categoria(1,
                "Infantil",
                "Cuento para niños de 4-5 años de edad");

    }
    @Test
    public void testCategoriaConstructor(){

        assertAll("Validar datos de Categoria con constructor",
                () ->assertEquals(1,categoria.getIdCategoria()),
                () ->assertEquals("Infantil",categoria.getCategoria()),
                () ->assertEquals("Cuento para niños de 4-5 años de edad", categoria.getDescripcion())

        );
    }

    @Test
    public  void testCategoriarSetters() {

        categoria.setIdCategoria(2);
        categoria.setCategoria("Terror");
        categoria.setDescripcion("Historias de miedo para niños de 15 años");


        assertAll("Validar datos de Categoria con setters",
                () -> assertEquals(2, categoria.getIdCategoria()),
                () -> assertEquals("Terror", categoria.getCategoria()),
                () -> assertEquals("Historias de miedo para niños de 15 años", categoria.getDescripcion())

                );
    }

    @Test
    public void testCategoriaToString() {
        String str = categoria.toString();

        assertAll("Validar datos de Categoria toString",
                () ->assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Infantil")),
                () -> assertTrue(str.contains("Cuento para niños de 4-5 años de edad"))


        );
    }


}
