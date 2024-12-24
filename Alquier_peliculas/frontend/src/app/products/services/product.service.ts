import { Injectable } from '@angular/core';
import { Alquiler, Camara, CamaraInsert, Marca, Pelicula, Product } from '../interfaces/product';
import { map, Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {


  private url:string='http://localhost:8080/api/pruebatecnica/camaras';
  private urlAlquiler:string='http://localhost:8080/api/pruebatecnica/alquiler'
  private urlDevolucion:string='http://localhost:8080/api/pruebatecnica/alquiler'
  private urlPeliculas:string='http://localhost:8080/api/pruebatecnica/peliculas'
  private urlMarcas:string='http://localhost:8080/api/pruebatecnica/marcas'
  private camara?:Camara;
  constructor(private http:HttpClient) { }

  public findAll():Observable<Camara[]>{
    return this.http.get<Camara[]>(this.url).pipe(
      map((response: any) => response as Camara[])
    )
  }

  public findById(id:number):Observable<Camara>{
    return this.http.get<Camara>(this.url+'/'+id);
  }

  public insertarAlquiler(alquiler:Alquiler):Observable<Alquiler>{
    return this.http.post<Alquiler>(this.urlAlquiler,alquiler);
  }

  public insertarEntrega(alquiler:Alquiler):Observable<Alquiler>{
    return this.http.put<Alquiler>(this.urlDevolucion,alquiler);
  }

  public findAllPeliculas():Observable<Pelicula[]>{
    return this.http.get<Pelicula[]>(this.urlPeliculas).pipe(
      map((response: any) => response as Pelicula[])
    )
  }

  findAllMarcas():Observable<Marca[]>{
    return this.http.get<Marca[]>(this.urlMarcas).pipe(
      map((response: any) => response as Marca[])
    )
  }

  updateCamara(camara:Camara):Observable<Camara>{
    return this.http.put<Camara>(this.url,camara);
  }

  insertarCamara(camara:CamaraInsert):Observable<CamaraInsert>{
    return this.http.post<CamaraInsert>(this.url,camara);
  }

  cambiarEstado(id:number, estado:string):Observable<Camara>{
    return this.http.patch<Camara>(this.url+'/'+id,estado);
  }

}
