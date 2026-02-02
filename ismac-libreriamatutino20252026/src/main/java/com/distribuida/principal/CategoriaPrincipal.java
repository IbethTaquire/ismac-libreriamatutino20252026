package com.distribuida.principal;

import com.distribuida.model.Categoria;

public class CategoriaPrincipal {

    public static void main(String[] args){

        Categoria categoria =new Categoria(1,"Infantil","Cuento para niños de 4-5 años de edad");

        System.out.println(categoria.toString());

    }
}
