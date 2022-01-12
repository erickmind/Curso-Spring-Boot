import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProdutoFormComponent } from './produto-form/produto-form.component';
import { ProdutosListComponent } from './produtos-list/produtos-list.component';

const routes: Routes = [
  { path: '' , component : ProdutosListComponent },
  { path: 'novo' , component : ProdutoFormComponent},
  { path: 'deletar/:id' , component : ProdutoFormComponent},
  { path: ':id' , component : ProdutoFormComponent} // :id sera o nome da variavel da rota que para ser utilizado no formulario
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProdutosRoutingModule { }
