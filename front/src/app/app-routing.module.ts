import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PrimeiroComponent } from './primeiro/primeiro.component';
import { ProdutosListComponent } from './produtos/produtos-list/produtos-list.component';
import { SegundoComponent } from './segundo/segundo.component';

const routes: Routes = [
  { path: '' , component : HomeComponent},
  { path: 'home' , component : HomeComponent},
  { path: 'primeiro' , component : PrimeiroComponent},
  { path: 'segundo',  component: SegundoComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
