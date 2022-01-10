import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProdutoFormComponent } from './produto-form/produto-form.component';
import { ProdutosListComponent } from './produtos-list/produtos-list.component';

const routes: Routes = [
  { path: 'produtos' , component : ProdutosListComponent },
  { path: 'produtos/novo' , component : ProdutoFormComponent},
  { path: 'produtos/deletar/:id' , component : ProdutoFormComponent},
  { path: 'produtos/:id' , component : ProdutoFormComponent} // :id sera o nome da variavel da rota que para ser utilizado no formulario
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProdutosRoutingModule { }
