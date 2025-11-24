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
        List<Cliente> clientes =clienteDAO.findAll();
        for(Cliente item: clientes){
            System.out.println(item.toString());
        }
    }


    @Test
    public void faidOne(){
        Optional<Cliente> cliente = clienteDAO.findById(1);
        System.out.println(cliente.toString());
    }
    @Test
    public void save(){
        Cliente cliente = new Cliente (0,"170123456","Juan","Taipe6","Av.por ahi y mas alla ","0987654321","jtaipe@correo.com");
        clienteDAO.save(cliente);
    }

@Test
    public void  update(){

    Optional<Cliente> cliente = clienteDAO.findById(39);
        cliente.orElse(null).setCedula("17012345777");
    cliente.orElse(null).setNombre("Jose");
    cliente.orElse(null).setApellido("Tupiza");
    cliente.orElse(null).setDireccion("Av Quito");
    cliente.orElse(null).setTelefono("09858421257");
    cliente.orElse(null).setCorreo("joset@correo.com");

    clienteDAO.save(cliente.orElse(null));
}

@Test
    public void delete(){
        clienteDAO.deleteById(39);

}

}
