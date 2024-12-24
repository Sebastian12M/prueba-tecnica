import { Component } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Camara, Product } from '../../interfaces/product';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [HttpClientModule,CommonModule,],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {

  constructor(private service:ProductService, private router:Router){

  }

  camaras:Camara[]=[]
  ngOnInit():void{
    this.cargarCamaras();
  }

  public verDetalles(camaraId:number){
    this.router.navigate(['/detalles',camaraId]);
  }

  public editarCamara(camaraId:number){
    this.router.navigate(['/editar-camara',camaraId]);
  }

  cargarCamaras(){
    this.service.findAll().subscribe(
      data => {
        this.camaras = data;
        console.log('Cámaras cargadas:', this.camaras);
      },
      error => {
        console.error('Error al cargar cámaras:', error);
      }
    );
  }

  cambiarEstado(id:number, estado:string){
    this.service.cambiarEstado(id, estado).subscribe(
      data=>{
        console.log("El estado se cambio", data)
        this.cargarCamaras()
      },
      error=>{
        console.log("El estado no cambio", error)
      }
    )
  }

}
