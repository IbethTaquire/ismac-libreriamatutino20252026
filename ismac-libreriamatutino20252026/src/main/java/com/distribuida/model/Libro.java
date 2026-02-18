package com.distribuida.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue
    @Column(name = "id_libro" )
    private int idLibro;
    @Column(name = "titulo" )
    private String titulo;
    @Column(name = "editorial" )
    private String editorial;
    @Column(name = "num_paginas" )
    private int numPaginas;
    @Column(name = "edicion" )
    private String edicion;
    @Column(name = "idioma" )
    private String idioma;
    @Column(name = "fecha_publicacion" )
    private Date fechaPublicacion;
    @Column(name = "descripcion" )
    private String descripcion;
    @Column(name = "tipo_pasta" )
    private String tipoPasta;
    @Column(name = "isbn" )
    private String iSBN;
    @Column(name = "num_ejemplares" )
    private int numEjemplares;
    @Column(name = "portada" )
    private String portada;
    @Column(name = "presentacion" )
    private String presentacion;
    @Column(name = "precio" )
    private Double precio;

    //Inyeccion
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

     public Libro (){ }

    public Libro(int idLibro, String titulo, String editorial, int numPaginas, String edicion, String idioma, Date fechaPublicidad, String descripcion, String tipoPasta, String iSBN, int numEjemplares, String portada, String presentacion, Double precio, FacturaDetalle facturaDetalle, Categoria categoria, Autor autor) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.editorial = editorial;
        this.numPaginas = numPaginas;
        this.edicion = edicion;
        this.idioma = idioma;
        this.fechaPublicacion = fechaPublicidad;
        this.descripcion = descripcion;
        this.tipoPasta = tipoPasta;
        this.iSBN = iSBN;
        this.numEjemplares = numEjemplares;
        this.portada = portada;
        this.presentacion = presentacion;
        this.precio = precio;
        this.categoria = categoria;
        this.autor = autor;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Date getFechaPublicidad() {
        return fechaPublicacion;
    }

    public void setFechaPublicidad(Date fechaPublicidad) {
        this.fechaPublicacion = fechaPublicidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoPasta() {
        return tipoPasta;
    }

    public void setTipoPasta(String tipoPasta) {
        this.tipoPasta = tipoPasta;
    }

    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String isbn) {
        this.iSBN = isbn;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", numPaginas=" + numPaginas +
                ", edicion='" + edicion + '\'' +
                ", idioma='" + idioma + '\'' +
                ", fechaPublicidad=" + fechaPublicacion +
                ", descripcion='" + descripcion + '\'' +
                ", tipoPasta='" + tipoPasta + '\'' +
                ", isbn='" + iSBN + '\'' +
                ", numEjemplares=" + numEjemplares +
                ", portada='" + portada + '\'' +
                ", presentacion='" + presentacion + '\'' +
                ", precio=" + precio +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }
}
