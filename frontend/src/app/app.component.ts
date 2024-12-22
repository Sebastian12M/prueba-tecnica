import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProductComponent } from "./products/components/product/product.component";
import { HttpClientModule } from '@angular/common/http';
import { DetallesComponent } from "./products/components/detalles/detalles.component";
import { NavComponent } from "./shared/components/nav/nav.component";
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ProductComponent, HttpClientModule, DetallesComponent, RouterOutlet, NavComponent,FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title:string = 'Hola mundo desde angular';
  enabled:boolean = true;
  cursos:string[]=['angular','react','php'];


  public cambiarEstado():void{
    if(this.enabled){
      this.enabled=false;
    }else{
      this.enabled=true;
    }
  }
}
