package com.distribuida.principal;

import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import com.distribuida.model.Libro;

import java.util.Date;

public class LibroPrincipal {

    public static void main (String[] ags){

        Libro  libro  = new Libro();
        libro.setIdLibro(1);
        libro.setTitulo("Caperucita Roja");
        libro.setEditorial("Editorial X");
        libro.setNumPaginas(300);
        libro.setEdicion("Primera");
        libro.setIdioma("Español");
        libro.setFechaPublicidad(new Date());
        libro.setDescripcion("Libro de Cuentos Infantiles");
        libro.setTipoPasta("Rústica");
        libro.setiSBN("1234567890");
        libro.setNumEjemplares(50);
        libro.setPortada("portada.jpg");
        libro.setPresentacion("Tapa blanda");
        libro.setPrecio(55.0);

        Categoria categoria =new Categoria(1,"Infantil","Cuento para niños de 4-5 años de edad");

        Autor autor = new Autor(1,"Charles ","Perraul","Francia","Av Francia E32","00 33 1 40 00 00 00.","charlesp@correo.com");


        //inyeccion
        libro.setCategoria(categoria);
        libro.setAutor(autor);

        System.out.println(autor.toString());
        System.out.println(categoria.toString());
        System.out.println(libro.toString());


    }

}
