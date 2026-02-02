package com.distribuida.principal;

import com.distribuida.model.Autor;

public class AutorPrincipal {

    public static void main(String[] args){

        Autor autor = new Autor(1,"Charles ","Perraul","Francia","Av Francia E32","00 33 1 40 00 00 00.","charlesp@correo.com");

        System.out.println(autor.toString());
    }
}
