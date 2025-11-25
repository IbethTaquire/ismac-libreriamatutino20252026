package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LibroTestUnitario {

    private Categoria categoria;
    private Autor autor;
    private Libro libro;

    @BeforeEach
    public void setup() {

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


        categoria = new Categoria(1,
                "Infantil",
                "Cuento para niños de 4-5 años de edad");

        autor = new Autor(1,
                "Charles ",
                "Perraul",
                "Francia",
                "Av Francia E32",
                "0985842125",
                "charlesp@correo.com");


        //Inyecciones de dependencias
        libro.setCategoria(categoria);
        libro.setAutor(autor);
    }

    @Test
    public void testLibroConstructor() {
        assertAll("Validar datos de Libro con setters",

                () -> assertEquals(1, libro.getIdLibro()),
                () -> assertEquals("Caperucita Roja", libro.getTitulo()),
                () -> assertEquals("Editorial X", libro.getEditorial()),
                () -> assertEquals(300, libro.getNumPaginas()),
                () -> assertEquals("Primera", libro.getEdicion()),
                () -> assertEquals("Español", libro.getIdioma()),
                //() -> assertEquals(fecha, libro.getFechaPublicidad()),
                () -> assertEquals("Libro de Cuentos Infantiles", libro.getDescripcion()),
                () -> assertEquals("Rústica", libro.getTipoPasta()),
                () -> assertEquals("1234567890", libro.getIsbn()),
                () -> assertEquals(50, libro.getNumEjemplares()),
                () -> assertEquals("portada.jpg", libro.getPortada()),
                () -> assertEquals("Tapa blanda", libro.getPresentacion()),
                () -> assertEquals(55.0, libro.getPrecio())

        );

    }

    @Test
    public void testLibroToString() {
        String str = libro.toString();

        assertAll("Validar contenido del toString",
                () -> assertTrue(str.contains("Caperucita Roja")),
                () -> assertTrue(str.contains("Editorial X")),
                () -> assertTrue(str.contains("300")),
                () -> assertTrue(str.contains("Rústica")),
                () -> assertTrue(str.contains("1234567890")),
                () -> assertTrue(str.contains("Infantil")),
                () -> assertTrue(str.contains("Charles"))
        );
    }

    @Test
    public void testLibroInyeccion() {
        assertAll("Validar inyección de Autor y Categoria",
                () -> assertNotNull(libro.getCategoria()),
                () -> assertNotNull(libro.getAutor()),

                () -> assertEquals("Infantil", libro.getCategoria().getCategoria()),
                () -> assertEquals("Charles ", libro.getAutor().getNombre())
        );
    }

}
