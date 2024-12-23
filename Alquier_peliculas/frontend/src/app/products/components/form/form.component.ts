import { Component, Input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Cliente, Alquiler } from '../../interfaces/product';
import { ProductService } from '../../services/product.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent implements OnInit {
  path?:string='';

  @Input() id?:string;

  error:string = '';

  alquiler:Alquiler = {
    camara:0,
    cliente:0,
    fechaEntrega:new Date(),
    estado:false
  }

  resultadoAlquiler:boolean = false;
  devolucionAlquiler:boolean = false;

  constructor(private service:ProductService, private activateRoute:ActivatedRoute) { }

  ngOnInit(): void {

    this.path = this.activateRoute.routeConfig?.path;
    console.log('Path:', this.path);

    if(this.id){
      this.alquiler.camara = +this.id;
    }
  }


  insertarAlquiler():void{
    console.log('Alquiler:', this.alquiler);
    this.service.insertarAlquiler(this.alquiler).subscribe(
      data=>{
        this.resultadoAlquiler = true;
        this.error='';
        console.log('Alquiler insertado:', data)
      },
      error=>{
        this.error=error.error;
        console.error('Error al insertar alquiler:', error)
      }
    )

    this.error='';
  }


  insertarEntrega(){
    this.service.insertarEntrega(this.alquiler).subscribe(
      data=>{
        this.devolucionAlquiler = true;
        this.error='';
        console.log('Entrega insertada:', data)
      },
      error=>{
        this.error=error.error;
        console.error('Error al insertar entrega:', error)
      }
    )
  }


  onSubmit():void{
    console.log('aLQUILER',this.alquiler)
    console.log('Formulario enviado:', this.alquiler);
  }
}
