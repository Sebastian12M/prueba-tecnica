import { Injectable } from '@angular/core';
import { Alquiler, Camara, Product } from '../interfaces/product';
import { map, Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {


  private url:string='http://localhost:8080/api/pruebatecnica/camaras';
  private urlAlquiler:string='http://localhost:8080/api/pruebatecnica/alquiler'
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

  public insertarAlquiler(alquiler:Alquiler):Observable<Product>{
    return this.http.post<Product>(this.urlAlquiler,alquiler);
  }

}
