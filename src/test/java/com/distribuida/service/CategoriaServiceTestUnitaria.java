package com.distribuida.service;

import com.distribuida.dao.CategoriaDAO;
import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.AssertionsKt.assertNotNull;
import static org.junit.jupiter.api.AssertionsKt.assertNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTestUnitaria {
    @Mock
    private CategoriaDAO categoriaDAO;

    @InjectMocks
    private CategoriaServiceImpl categoriaService;

    private Categoria categoria;


    @BeforeEach
    public void setUp() {
        categoria = new Categoria();
        categoria.setIdCategoria(1);
        categoria.setCategoria("Tecnología");
        categoria.setDescripcion("Libros de tecnología");
    }
    @Test
    public  void  findAll(){
        when(categoriaDAO.findAll()).thenReturn(List.of(categoria));
        List<Categoria> categoria = categoriaService.findAll();

        Assertions.assertNotNull(categoria);
        assertEquals(1,categoria.size());
        verify(categoriaDAO,times(1)).findAll();
    }
    @Test
    public void testFindOneExistente() {
        when(categoriaDAO.findById(1)).thenReturn(Optional.of(categoria));

        Optional<Categoria> categoria = categoriaService.findOne(1);

        assertNotNull(categoria);
        assertEquals("Tecnología", categoria.orElse(null).getCategoria());
    }

    @Test
    public void testFindOneNoExistente() {
        when(categoriaDAO.findById(2)).thenReturn(null);

        Optional<Categoria> categoria = categoriaService.findOne(2);

        assertNull(categoria);
    }

    @Test
    public void testSave() {
        when(categoriaDAO.save(categoria)).thenReturn(categoria);

        Categoria categoriaGuardada = categoriaService.save(categoria);

        assertNotNull(categoriaGuardada);
        assertEquals("Tecnología", categoriaGuardada.getCategoria());
    }

    @Test
    public void testUpdateExistente() {
        Categoria categoriaActualizada = new Categoria();
        categoriaActualizada.setCategoria("Ciencia");
        categoriaActualizada.setDescripcion("Libros científicos");

        when(categoriaDAO.findById(1)).thenReturn(Optional.of(categoria));
        when(categoriaDAO.save(any())).thenReturn(categoriaActualizada);

        Categoria categoriaResultado = categoriaService.update(1, categoriaActualizada);

        assertNotNull(categoriaResultado);
        assertEquals("Ciencia", categoriaResultado.getCategoria());
        verify(categoriaDAO, times(1)).save(categoria);
    }

    @Test
    public void testUpdateNoExistente() {
        Categoria categoriaNueva = new Categoria();
        when(categoriaDAO.findById(15)).thenReturn(null);

        Categoria resultado = categoriaService.update(15, categoriaNueva);

        assertNull(resultado);
        verify(categoriaDAO, never()).save(any());
    }

    @Test
    public void testDeleteExistente() {
        when(categoriaDAO.existsById(1)).thenReturn(true);

        categoriaService.delete(1);

        verify(categoriaDAO).deleteById(1);
    }

    @Test
    public void testDeleteNoExistente() {
        when(categoriaDAO.existsById(15)).thenReturn(false);

        categoriaService.delete(15);

        verify(categoriaDAO, never()).deleteById(15);
    }


}
