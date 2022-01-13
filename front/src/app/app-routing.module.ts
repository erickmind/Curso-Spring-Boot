import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuardService } from './auth/guard.service';
import { HomeComponent } from './home/home.component';
import { PrimeiroComponent } from './primeiro/primeiro.component';
import { SegundoComponent } from './segundo/segundo.component';

const routes: Routes = [
  { path: '' , component : HomeComponent},
  { path: 'home' , component : HomeComponent},
  { path: 'primeiro' , component : PrimeiroComponent},
  { path: 'segundo',  component: SegundoComponent},
  
  { path: 'auth', 
    loadChildren : () => import( './auth/auth.module' ).then( m => m.AuthModule ) },

  // Lazy load
  { path: 'produtos', 
  loadChildren : () => import( './produtos/produtos.module' ).then( m => m.ProdutosModule ), canActivate : [ GuardService ] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // forRoot porque é o modulo raiz
  exports: [RouterModule]
})
export class AppRoutingModule { }
