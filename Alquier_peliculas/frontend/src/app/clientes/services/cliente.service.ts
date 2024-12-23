import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente, ClienteInsert } from '../../products/interfaces/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  url:string='http://localhost:8080/api/pruebatecnica/clientes';

  constructor(private http:HttpClient) { }


  insertarCliente(cliente:ClienteInsert):Observable<ClienteInsert>{
    return this.http.post<ClienteInsert>(this.url,cliente)
  }

}
