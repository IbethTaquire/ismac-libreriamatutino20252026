import { Autor } from "./autor.model"
import { Categoria } from "./categoria.model"

export interface Libro{

    idlibro: number
    titulo: string
    editorial: string
    numPaginas: string
    edicion: string
    idioma : string
    fechaPublicacion: Date
    descripcion : string
    tipoPasta: string
    iSBN: string
    numEjemplares: number
    portada: string
    presentacion: string
    precio : string
    categoria : Categoria
    autor : Autor

    [key:string]: any;
}