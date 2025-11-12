package com.distribuida.principal;

import com.distribuida.model.Cliente;

public class ClientePrincipal {
    public static void main(String[] args){

        Cliente cliente = new Cliente(1
                ,"1728171503"
                ,"Erick"
                ,"Chiran"
                ,"Av Quito Selva Alegre"
                ,"0985842125"
                ,"erick@correo.com");

        System.out.println(cliente.toString());

    }
}
