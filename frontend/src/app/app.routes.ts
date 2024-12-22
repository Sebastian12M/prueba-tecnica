import { Routes } from '@angular/router';
import { DetallesComponent } from './products/components/detalles/detalles.component';
import { ProductComponent } from './products/components/product/product.component';
import { FormComponent } from './products/components/form/form.component';

export const routes: Routes = [
  {path: 'detalles/:id', component:DetallesComponent},
  {path: 'camaras', component:ProductComponent},
  { path: '', redirectTo: 'camaras', pathMatch: 'full' },
  {path:'alquiler/:id', component:FormComponent}
];

