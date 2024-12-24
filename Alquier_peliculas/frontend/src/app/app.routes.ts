import { Routes } from '@angular/router';
import { DetallesComponent } from './products/components/detalles/detalles.component';
import { ProductComponent } from './products/components/product/product.component';
import { FormComponent } from './products/components/form/form.component';
import { FormComponentCliente } from './clientes/components/form/form.component';
import { FormCamaraComponent } from './products/components/form-camara/form-camara.component';
import { FormRegistroComponent } from './products/components/form-registro/form-registro.component';

export const routes: Routes = [
  {path: 'detalles/:id', component:DetallesComponent},
  {path: 'camaras', component:ProductComponent},
  {path: 'devolucion', component:FormComponent},
  {path: 'registrar-cliente', component:FormComponentCliente},
  {path: 'editar-camara/:id', component:FormCamaraComponent},
  {path: 'registrar-camara', component:FormRegistroComponent},
  {path: '', redirectTo: 'camaras', pathMatch: 'full' },
  {path:'alquiler/:id', component:FormComponent}
];

