package com.distribuida.service;

import com.distribuida.dao.AutorDAO;
import com.distribuida.model.Autor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
public class AutorServiceTestUnitaria {

    @Mock
    private AutorDAO autorDAO;

    @InjectMocks
    private AutorServiceImpl autorService;

    private Autor autor;


    @BeforeEach
    public void  setUP(){
        autor = new Autor();
        autor.setIdAutor(1);
        autor.setNombre("Jose");
        autor.setApellido("Taipe");
        autor.setPais("Francia");
        autor.setDireccion("Av Calle 42");
        autor.setTelefono("0987654321");
        autor.setCorreo("jtaipe@correo.com");
    }

    @Test

    public  void  findAll(){
        when(autorDAO.findAll()).thenReturn(List.of(autor));
        List<Autor> autor = autorService.findAll();

        assertNotNull(autor);
        assertEquals(1,autor.size());
        verify(autorDAO,times(1)).findAll();
    }

    @Test
    public void testFindOneExistente(){
        when(autorDAO.findById(1)).thenReturn(Optional.ofNullable(autor));
        Optional<Autor> autor= autorService.findOne(1);

        assertNotNull(autor);
        assertEquals("Jose",autor.orElse(null).getNombre());

    }
    @Test
    public void testFindOneNoExistente(){
        when(autorDAO.findById(2)).thenReturn(null);
        Optional<Autor> autor = autorService.findOne(2);
        assertNull(autor);

    }

    @Test
    public void testSave(){
        when(autorDAO.save(autor)).thenReturn(autor);
        Autor autorGuardado = autorService.save(autor);
        assertNotNull(autorGuardado);
        assertEquals("Jose",autorGuardado.getNombre());
    }

    @Test
    public void testUpdateExistente(){
        Autor autorActualizado = new Autor();
        autorActualizado.setNombre("Jose22");
        autorActualizado.setApellido("Taipe22");
        autorActualizado.setPais("Europa");
        autorActualizado.setDireccion("Direccion14");
        autorActualizado.setTelefono("0987654666");
        autorActualizado.setCorreo("jtaipe66@correo.com");

        when(autorDAO.findById(1)).thenReturn(Optional.ofNullable(autor));
        when(autorDAO.save(any())).thenReturn(autorActualizado);

        Autor autorResultado = autorService.update(1,autorActualizado);

        assertNotNull(autorResultado);
        assertEquals("Jose22",autorResultado.getNombre());
        verify(autorDAO,times(1)).save(autor);

    }

    @Test
    public void testUpdateNoExistente(){
        Autor autorNuevo = new Autor();
        when(autorDAO.findById(10)).thenReturn(null);
        Autor resultado = autorService.update(10,autorNuevo);

        assertNull(resultado);
        verify(autorDAO,never()).save(any());
    }

    @Test
    public void testDeleteExistente(){
        when(autorDAO.existsById(1)).thenReturn(true);
        autorService.delete(1);

        verify(autorDAO).deleteById(1);
    }

    @Test
    public void testeDeleteNoExistente(){
        when(autorDAO.existsById(10)).thenReturn(false);
        autorService.delete(10);

        verify(autorDAO,never()).deleteById(10);
    }



}
