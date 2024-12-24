import { Component, Input } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Camara, Marca, Pelicula } from '../../interfaces/product';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form-camara',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './form-camara.component.html',
  styleUrl: './form-camara.component.css'
})
export class FormCamaraComponent {

  public camara:Camara={
    id: 0,
    modelo: '',
    marca: {id: 0,nombre: '',direccion: ''},
    soporteFlash: false,
    peliculas: [],
    estado: ''
  }

  @Input() id?:string;

  peliculas:Pelicula[]=[];

  peliculaEncontrada:boolean=false;

  marcas:Marca[]=[];

  validacion:boolean=false;

  constructor(private service:ProductService, private router:Router){}

  ngOnInit():void{
    if(this.id){
      this.findByd(Number(this.id));
      this.findAllPeliculasj();
      this.findAllMarcas();
    }
  }

  findByd(id:number):void{
    this.service.findById(id).subscribe(
      data => {

        this.camara = data;
        console.log('Cámara cargada:', this.camara);
      },
      error => {
        console.error('Error al cargar cámara:', error);
      }
    );
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

  updateCamara(){
    this.service.updateCamara(this.camara).subscribe(
      data => {
        this.validacion=true;
        console.log('Cámara actualizada:', data);
      },
      error => {
        console.error('Error al actualizar cámara:', error);
      }
    );
  }


  onInit(){
    console.log('Cámara:', this.camara);
  }

}
