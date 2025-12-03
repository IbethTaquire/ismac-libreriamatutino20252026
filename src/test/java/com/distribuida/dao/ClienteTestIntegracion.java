package com.distribuida.dao;

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

//import org.springframework.beans.factory.annotation.Autowired;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class ClienteTestIntegracion {

    @Autowired
    public ClienteDAO clienteDAO;

    @Test
    public void findAll(){
        List<Cliente> clientes=clienteDAO.findAll();
        assertNotNull(clientes);
        assertTrue(clientes.size() > 0);
        for(Cliente item: clientes){
            System.out.println(item.toString());
        }
    }


    @Test
    public void faidOne(){
        Optional<Cliente> cliente = clienteDAO.findById(1);
        assertTrue(cliente.isPresent(),"El cliente con id=1 si existe");
        System.out.println(cliente.toString());
    }

    @Test
    public void save(){
        Cliente cliente = new Cliente (0,"170123456","Juan","Taipe6","Av.por ahi y mas alla ","0987654321","jtaipe@correo.com");
        Cliente clienteGuardado = clienteDAO.save(cliente);
        assertNotNull(clienteGuardado,"El cliente nuevo se guardo correctamente");
        assertEquals("170123456",clienteGuardado.getCedula());
        assertEquals("Juan",clienteGuardado.getNombre());
    }

@Test
    public void  update(){

    Optional<Cliente> cliente = clienteDAO.findById(42);
    assertTrue(cliente.isPresent(),"El cliente existe en DB");

    cliente.orElse(null).setCedula("17012345777");
    cliente.orElse(null).setNombre("Jose");
    cliente.orElse(null).setApellido("Tupiza");
    cliente.orElse(null).setDireccion("Av Quito");
    cliente.orElse(null).setTelefono("09858421257");
    cliente.orElse(null).setCorreo("joset@correo.com");

    Cliente clienteActualizado = clienteDAO.save(cliente.orElse(null));
    assertNotNull(clienteActualizado,"El cliente fue actulizado");
    assertEquals("Jose",clienteActualizado.getNombre());
    assertEquals("Tupiza",clienteActualizado.getApellido());

}

@Test
    public void delete(){
        if(clienteDAO.existsById(42)) {
            clienteDAO.deleteById(42);
        }
        assertFalse(clienteDAO.existsById(42),"El dato fue eliminado");
}

}
