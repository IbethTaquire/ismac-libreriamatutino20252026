package com.distribuida.dao;

import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class CategoriaTestIntegracion {

    @Autowired
    public CategoriaDAO categoriaDAO;

    @Test
    public void findAll(){
        List<Categoria> categorias=categoriaDAO.findAll();
        assertNotNull(categorias);
        assertTrue(categorias.size() > 0);
        for(Categoria item: categorias){
            System.out.println(item.toString());
        }
    }
    @Test
    public void faidOne(){
        Optional<Categoria> categorias= categoriaDAO.findById(1);
        assertTrue(categorias.isPresent(),"El Autor con id=1 si existe");
        System.out.println(categorias.toString());
    }
    @Test
    public void save(){
        Categoria categoria =new Categoria(1,"Infantil","Cuento para niños de 4-5 años de edad");

        Categoria categoriaGuardado = categoriaDAO.save(categoria);
        assertNotNull(categoriaGuardado,"La categoria nueva se guardo correctamente");
        assertEquals("Infantil",categoriaGuardado.getCategoria());
        assertEquals("Cuento para niños de 4-5 años de edad",categoriaGuardado.getDescripcion());
    }

    @Test
    public void  update(){

        Optional<Categoria> categorias = categoriaDAO.findById(51);
        assertTrue(categorias.isPresent(),"La categoria existe en DB");

        categorias.orElse(null).setDescripcion("dedicada al estudio del comportamiento humano, las sociedades y las relaciones entre personas, culturas e instituciones.");

        Categoria categoriaActualizado = categoriaDAO.save(categorias.orElse(null));
        assertNotNull(categorias,"El cliente fue actulizado");

        assertEquals("dedicada al estudio del comportamiento humano, las sociedades y las relaciones entre personas, culturas e instituciones.",categoriaActualizado.getDescripcion());


    }

    @Test
    public void delete(){
        if(categoriaDAO.existsById(1)) {
            categoriaDAO.deleteById(1);
        }
        assertFalse(categoriaDAO.existsById(1),"El dato fue eliminado");
    }

}
