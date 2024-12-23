import { Component } from '@angular/core';
import { Cliente, ClienteInsert } from '../../../products/interfaces/product';
import { FormsModule } from '@angular/forms';
import { ClienteService } from '../../services/cliente.service';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})


export class FormComponentCliente {
  cliente:ClienteInsert = {
    cedula:'',
    nombre:'',
    correo:'',
    diasMulta:0
  }

  resultadoCliente:boolean = false;

  error:string = '';

  constructor(private service:ClienteService){

  }

  insertarCliente():void{
    this.service.insertarCliente(this.cliente).subscribe(
      data=>{
        this.resultadoCliente=true;
        console.log('Cliente insertado:', data)
      },
      error=>{
        this.error=error.error;
        console.error('Error al insertar cliente:', error)
      }
    )
    this.error='';
  }

  onSubmit():void{
    console.log('Cliente:', this.cliente);
  }

}
