import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PrimeiroComponent } from './primeiro/primeiro.component';
import { SegundoComponent } from './segundo/segundo.component';

const routes: Routes = [
  { path: '' , component : HomeComponent},
  { path: 'home' , component : HomeComponent},
  { path: 'primeiro' , component : PrimeiroComponent},
  { path: 'segundo',  component: SegundoComponent},

  // Lazy load
  { path: 'produtos', loadChildren : () => import( './produtos/produtos.module' ).then( m => m.ProdutosModule ) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // forRoot porque é o modulo raiz
  exports: [RouterModule]
})
export class AppRoutingModule { }
