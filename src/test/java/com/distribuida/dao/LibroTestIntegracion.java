package com.distribuida.dao;

import com.distribuida.model.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class LibroTestIntegracion {

    @Autowired

    private LibroDAO libroDAO;

    @Autowired
    private CategoriaDAO categoriaDAO;

    @Autowired
    private AutorDAO autorDAO;



    @Test
    public void testLibroFindAll(){

        List<Libro>libros = libroDAO.findAll();
        assertNotNull(libros);
        assertTrue(libros.size()> 0);
        libros.forEach(System.out::println);
    }

    @Test
    public void testLibroFindOne(){
        Optional<Libro> libro = libroDAO.findById(1);
        assertTrue(libro.isPresent(),"El Libro con id=1 si existe");
        System.out.println(libro.toString());
    }

    @Test
    public void testLibroSave() {

        Optional<Autor> autor = autorDAO.findById(1);
        Optional<Categoria> categoria = categoriaDAO.findById(2);

        assertTrue(autor.isPresent());
        assertTrue(categoria.isPresent());

        Libro libro = new Libro();
        libro.setIdLibro(0);
        libro.setTitulo("Cien años de soledad");
        libro.setEditorial("Sudamericana");
        libro.setNumPaginas(471);
        libro.setEdicion("Primera");
        libro.setIdioma("Español");
        libro.setFechaPublicidad(new Date());
        libro.setDescripcion("Novela emblemática del realismo mágico");
        libro.setTipoPasta("Dura");
        libro.setIsbn("978-84-376-0494-7");
        libro.setNumEjemplares(50);
        libro.setPortada("cien_anos.jpg");
        libro.setPresentacion("Tapa dura con sobrecubierta");
        libro.setPrecio(25.99);

        libro.setAutor(autor.orElse(null));
        libro.setCategoria(categoria.orElse(null));


        Libro libroGuardado = libroDAO.save(libro);

        assertNotNull(libroGuardado);
        assertEquals("Cien años de soledad", libroGuardado.getTitulo());
        assertEquals("Sudamericana", libroGuardado.getEditorial());
        assertEquals("Español", libroGuardado.getIdioma());
        assertEquals("Pamela", libroGuardado.getAutor().getNombre());
        assertEquals("Matematica", libroGuardado.getCategoria().getCategoria());
    }

    @Test
    public void testLibroUpdate() {

        Optional<Autor> autor = autorDAO.findById(1);
        Optional<Categoria> categoria = categoriaDAO.findById(2);
        Optional<Libro> libro = libroDAO.findById(152);

        assertTrue(autor.isPresent());
        assertTrue(categoria.isPresent());
        assertTrue(libro.isPresent());

        libro.orElse(null).setTitulo("El amor en los tiempos del cólera");
        libro.orElse(null).setEditorial("Editorial Oveja Negra");
        libro.orElse(null).setNumPaginas(368);
        libro.orElse(null).setEdicion("Segunda");
        libro.orElse(null).setIdioma("Español");
        libro.orElse(null).setFechaPublicidad(new Date());
        libro.orElse(null).setDescripcion("Otra gran obra del realismo mágico");
        libro.orElse(null).setTipoPasta("Blanda");
        libro.orElse(null).setIsbn("978-84-376-0495-4");
        libro.orElse(null).setNumEjemplares(30);
        libro.orElse(null).setPortada("normal");
        libro.orElse(null).setPresentacion("Tapa blanda con ilustraciones");
        libro.orElse(null).setPrecio(19.99);

        libro.orElse(null).setAutor(autor.orElse(null));
        libro.orElse(null).setCategoria(categoria.orElse(null));

        Libro libroActualizado = libroDAO.save(libro.orElse(null));

        assertNotNull(libroActualizado);
        assertEquals("El amor en los tiempos del cólera", libroActualizado.getTitulo());
        assertEquals("Editorial Oveja Negra", libroActualizado.getEditorial());
        assertEquals("Español", libroActualizado.getIdioma());
        assertEquals("Pamela", libroActualizado.getAutor().getNombre());
        assertEquals("Matematica", libroActualizado.getCategoria().getCategoria());
    }

    @Test
    public void testLibroDelet(){
        if (libroDAO.existsById(152)){
            libroDAO.deleteById(152);
        }
        assertFalse(libroDAO.existsById(152)," El dato fue elimuinado");
    }


}