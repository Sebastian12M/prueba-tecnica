import { Component, Input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Cliente, Alquiler } from '../../interfaces/product';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent implements OnInit {
  hoy: string = '';
  maxFecha: string = '';
  @Input() id?:string;
  error:string = '';
  alquiler:Alquiler = {
    camara:0,
    cliente:0,
    fechaEntrega:new Date(),
    estado:false
  }

  constructor(private service:ProductService) { }

  ngOnInit(): void {
    const hoy = new Date();
    const maxFecha = new Date();
    maxFecha.setDate(hoy.getDate() + 6);

    this.hoy = hoy.toISOString().split('T')[0];
    this.maxFecha = maxFecha.toISOString().split('T')[0];
    if(this.id){
      this.alquiler.camara = +this.id;
    }
  }


  insertarAlquiler():void{
    this.service.insertarAlquiler(this.alquiler).subscribe(
      data=>{
        this.error='';
        console.log('Alquiler insertado:', data)
      },
      error=>{
        this.error=error.error;
        console.error('Error al insertar alquiler:', error)
      }
    )
  }


  onSubmit():void{
    console.log('Formulario enviado:', this.alquiler);
  }
}
