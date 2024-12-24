import { Component, Input } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Router } from '@angular/router';
import { Camara, CamaraInsert, Marca, Pelicula } from '../../interfaces/product';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form-registro',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './form-registro.component.html',
  styleUrl: './form-registro.component.css'
})

export class FormRegistroComponent {

  

  public camara:CamaraInsert={
    modelo: '',
    marca: '',
    soporteFlash: false,
    peliculas: [],
    estado: 'DISPONIBLE'
  }



    peliculas:Pelicula[]=[];

    peliculaEncontrada:boolean=false;

    marcas:Marca[]=[];

    validacion:boolean=false;

  constructor(private service:ProductService, private router:Router){}

    ngOnInit():void{
      this.findAllPeliculasj();
      this.findAllMarcas();

    }


    findAllMarcas(){
        this.service.findAllMarcas().subscribe(
          data=>{
            this.marcas=data;
            console.log('Marcas cargadas:', data);
            return data;
          },
          error => {
            console.error('Error al cargar marcas:', error);
            return [];
          }
        )
    }



    findAllPeliculasj(){
      this.service.findAllPeliculas().subscribe(
        data => {
          this.peliculas = data;
          console.log('Peliculas cargadas:', data);
        },
        error => {
          console.error('Error al cargar peliculas:', error);
        }
      );
    }

    insertarCamara(){
      this.service.insertarCamara(this.camara).subscribe(
        data=>{
          this.validacion=true;
          console.log('Camara Insertdada',data);
        },
        error =>{
          this.validacion=false;
          console.log('Erro al insertar', error);
        }
      )
    }


    onSubmit(){
      console.log('Cámara:', this.camara);
    }
}
