package com.distribuida.dao;

import com.distribuida.model.Autor;
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
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class AutorTestIntegracion {

    @Autowired
    public AutorDAO autorDAO;

    @Test
    public void findAll(){
        List<Autor> autores= autorDAO.findAll();
        assertNotNull(autores);
        assertTrue(autores.size()>0);
        for (Autor item :autores){
            System.out.println(item.toString());
        }

    }

    @Test
    public void faidOne(){
        Optional<Autor> autores = autorDAO.findById(1);
        assertTrue(autores.isPresent(),"El Autor con id=1 si existe");
        System.out.println(autores.toString());
    }

    @Test
    public void save(){
        Autor autor = new Autor(48,"Charles ","Perraul","Francia","Av Francia E32","0985842125.","charlesp@correo.com");
        Autor autorGuardado = autorDAO.save(autor);
        assertNotNull(autorGuardado,"El Autor nuevo se guardo correctamente");
        assertEquals("Francia",autorGuardado.getPais());
        assertEquals("Charles ",autorGuardado.getNombre());
    }

    @Test
    public void  update(){

        Optional<Autor> autores = autorDAO.findById(48);
        assertTrue(autores.isPresent(),"El autor existe en DB");

        autores.orElse(null).setNombre("Jose");
        autores.orElse(null).setDireccion("Av Quito");
        autores.orElse(null).setTelefono("0999673411");


        Autor autorActualizado = autorDAO.save(autores.orElse(null));
        assertNotNull(autorActualizado,"El autor fue actulizado");
        assertEquals("Jose",autorActualizado.getNombre());
        assertEquals("Av Quito",autorActualizado.getDireccion());
        assertEquals("0999673411",autorActualizado.getTelefono());

    }
    @Test
    public void delete(){
        if(autorDAO.existsById(48)) {
            autorDAO.deleteById(48);
        }
        assertFalse(autorDAO.existsById(48),"El dato fue eliminado");
    }

}
