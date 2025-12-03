package com.distribuida.dao;


import com.distribuida.model.Factura;
import com.distribuida.model.FacturaDetalle;
import com.distribuida.model.Libro;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class FacturaDetalleTestIntegracion {


    @Autowired
    private FacturaDAO facturaDAO;

    @Autowired
    private FacturaDetalleDAO facturaDetalleDAO;

    @Autowired
    private  LibroDAO libroDAO;


    @Test
    public void testFacturaDetalleFindAll(){
        List<FacturaDetalle> facturaDetalles = facturaDetalleDAO.findAll();
        assertNotNull(facturaDetalles);
        assertTrue(facturaDetalles.size()> 0);
        facturaDetalles.forEach(System.out::println);
    }

    @Test
    public void testFacturaDetalleFindOne() {
        Optional<FacturaDetalle> facturaDetalle = facturaDetalleDAO.findById(1);

        assertTrue(facturaDetalle.isPresent());
        assertEquals(1, facturaDetalle.orElse(null).getIdFacturaDetalle());
        assertEquals(2, facturaDetalle.orElse(null).getCantidad());
        assertEquals(new BigDecimal("30.84"), facturaDetalle.orElse(null).getSubtotal());


        System.out.println(facturaDetalle.toString());
    }

    @Test
    public void testFacturaDetalleSave() {

        Optional<Factura> factura = facturaDAO.findById(1);
        assertTrue(factura.isPresent());


        Optional<Libro> libros = libroDAO.findById(1);
        assertTrue(libros.isPresent());


        FacturaDetalle facturaDetalle = new FacturaDetalle();
        facturaDetalle.setIdFacturaDetalle(0);
        facturaDetalle.setCantidad(5);
        facturaDetalle.setSubtotal(new BigDecimal("30.84"));
        facturaDetalle.setFactura(factura.orElse(null));
        facturaDetalle.setLibro(libros.orElse(null));


        FacturaDetalle facturadetalleGuardado = facturaDetalleDAO.save(facturaDetalle);


        assertNotNull(facturadetalleGuardado);
        assertEquals(5, facturadetalleGuardado.getCantidad());
        assertEquals(new BigDecimal("30.84"), facturadetalleGuardado.getSubtotal());
        assertEquals("FAC-0001", facturadetalleGuardado.getFactura().getNumFactura());
        assertEquals("Spring in Action", facturadetalleGuardado.getLibro().getTitulo());
    }

    @Test
    public void testFacturaDetalleUpdate() {


        Optional<FacturaDetalle> facturaDetalle = facturaDetalleDAO.findById(302);
        assertTrue(facturaDetalle.isPresent());


        facturaDetalle.orElse(null).setCantidad(10);
        facturaDetalle.orElse(null).setSubtotal(new BigDecimal("35.95")); // ✔ BigDecimal


        FacturaDetalle detalleActualizado = facturaDetalleDAO.save(facturaDetalle.orElse(null));


        assertNotNull(detalleActualizado);
        assertEquals(10, detalleActualizado.getCantidad());
        assertEquals(new BigDecimal("35.95"), detalleActualizado.getSubtotal());


        assertNotNull(detalleActualizado.getFactura());
        assertNotNull(detalleActualizado.getLibro());
        assertEquals("FAC-0001", detalleActualizado.getFactura().getNumFactura());
        assertEquals("Spring in Action", detalleActualizado.getLibro().getTitulo());
    }

    @Test
    public void testFacturaDetalleDelet(){
        if (facturaDetalleDAO.existsById(302)){
            facturaDetalleDAO.deleteById(302);
        }
        assertFalse(facturaDetalleDAO.existsById(302)," El dato fue eliminado");
    }


}
