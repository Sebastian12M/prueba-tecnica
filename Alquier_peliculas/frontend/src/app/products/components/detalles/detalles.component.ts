import { Component, Input } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { ProductService } from '../../services/product.service';
import { Camara } from '../../interfaces/product';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-detalles',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './detalles.component.html',
  styleUrl: './detalles.component.css'
})
export class DetallesComponent {
  constructor(private service:ProductService, private router:Router){}

  public camara?:Camara;
  @Input() id?:string;

  ngOnInit():void{
    if(this.id){
      this.findByd(+this.id);
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

  goFormulario(id?:number):void{
    this.router.navigate(['/alquiler',id]);
  }





}
