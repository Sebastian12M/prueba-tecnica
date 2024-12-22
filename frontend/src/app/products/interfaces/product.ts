export interface Product{
  nombre:string
  precio:number
  cantidad:number
}

export interface Marca {
  id: number;
  nombre: string;
  direccion: string;
}

export interface Pelicula {
  id: number;
  marca: string;
  nombre: string;
  sensibilidadIso: number;
  formato: string;
}

export interface Camara {
  id: number;
  modelo: string;
  marca: Marca;
  soporteFlash: boolean;
  peliculas: Pelicula[];
  estado: string;
}

export interface Cliente{
  id:number;
  cedula:string;
  nombre:string;
  correo:string;
  diasMulta:number;
}

export interface Alquiler{
  camara:number;
  cliente:number;
  fechaEntrega:Date;
  estado:boolean;

}
