package com.distribuida.service;

import com.distribuida.dao.LibroDAO;
import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import com.distribuida.model.Libro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LibroServiceTestUnitaria {

    @Mock
    private LibroDAO libroDAO;

    @InjectMocks
    private LibroSeviceImpl libroService;

    private Libro libro;
    private Categoria categoria;
    private Autor autor;

    @BeforeEach
    public void setUp() {

        categoria = new Categoria();
        categoria.setIdCategoria(1);
        categoria.setCategoria("Tecnología");

        autor = new Autor();
        autor.setIdAutor(1);
        autor.setNombre("Juan");
        autor.setApellido("Taipe");

        libro = new Libro();
        libro.setIdLibro(1);
        libro.setTitulo("Java Básico");
        libro.setEditorial("Pearson");
        libro.setNumPaginas(300);
        libro.setEdicion("Primera");
        libro.setIdioma("Español");
        libro.setFechaPublicidad(new Date());
        libro.setDescripcion("Libro de introducción a Java");
        libro.setTipoPasta("Dura");
        libro.setIsbn("978-1234567890");
        libro.setNumEjemplares(10);
        libro.setPortada("portada.jpg");
        libro.setPresentacion("Física");
        libro.setPrecio(50.00);
        libro.setCategoria(categoria);
        libro.setAutor(autor);
    }

    @Test
    public void findAll() {
        when(libroDAO.findAll()).thenReturn(List.of(libro));

        List<Libro> libros = libroService.findAll();

        assertNotNull(libros);
        assertEquals(1, libros.size());
        verify(libroDAO, times(1)).findAll();
    }

    @Test
    public void findOneExistente() {
        when(libroDAO.findById(1)).thenReturn(Optional.of(libro));

        Optional<Libro> resultado = libroService.findOne(1);

        assertNotNull(resultado);
        assertEquals("Java Básico", resultado.orElse(null).getTitulo());
    }

    @Test
    public void findOneNoExistente() {
        when(libroDAO.findById(999)).thenReturn(null);

        Optional<Libro> resultado = libroService.findOne(999);

        assertNull(resultado);
    }

    @Test
    public void save() {
        when(libroDAO.save(libro)).thenReturn(libro);

        Libro libroGuardado = libroService.save(libro);

        assertNotNull(libroGuardado);
        assertEquals("Java Básico", libroGuardado.getTitulo());
    }

    @Test
    public void updateExistente() {
        Libro libroActualizado = new Libro();
        libroActualizado.setTitulo("Java Avanzado");
        libroActualizado.setEditorial("McGraw-Hill");
        libroActualizado.setNumPaginas(450);
        libroActualizado.setEdicion("Segunda");
        libroActualizado.setIdioma("Español");
        libroActualizado.setFechaPublicidad(new Date());
        libroActualizado.setDescripcion("Java a nivel avanzado");
        libroActualizado.setTipoPasta("Blanda");
        libroActualizado.setIsbn("978-0987654321");
        libroActualizado.setNumEjemplares(5);
        libroActualizado.setPortada("portada2.jpg");
        libroActualizado.setPresentacion("Digital");
        libroActualizado.setPrecio(75.00);
        libroActualizado.setCategoria(categoria);
        libroActualizado.setAutor(autor);

        when(libroDAO.findById(1)).thenReturn(Optional.of(libro));
        when(libroDAO.save(any())).thenReturn(libroActualizado);

        Libro resultado = libroService.update(1, libroActualizado);

        assertNotNull(resultado);
        assertEquals("Java Avanzado", resultado.getTitulo());
        verify(libroDAO, times(1)).save(libro);
    }

    @Test
    public void updateNoExistente() {
        Libro nuevo = new Libro();

        when(libroDAO.findById(999)).thenReturn(null);

        Libro resultado = libroService.update(999, nuevo);

        assertNull(resultado);
        verify(libroDAO, never()).save(any());
    }

    @Test
    public void deleteExistente() {
        when(libroDAO.existsById(1)).thenReturn(true);

        libroService.delete(1);

        verify(libroDAO).deleteById(1);
    }

    @Test
    public void deleteNoExistente() {
        when(libroDAO.existsById(999)).thenReturn(false);

        libroService.delete(999);

        verify(libroDAO, never()).deleteById(anyInt());
    }







}
