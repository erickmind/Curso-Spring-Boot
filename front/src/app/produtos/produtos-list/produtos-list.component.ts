import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ProdutoService } from '../produto.service';


@Component({
  selector: 'app-produtos-list',
  templateUrl: './produtos-list.component.html',
  styleUrls: ['./produtos-list.component.scss']
})
export class ProdutosListComponent implements OnInit {

  isShow : boolean = true;
  minhaClasse : String = '';
  produtoSelecionadoPai : any;

  produtos : any;

  constructor( private produtoService : ProdutoService, private Router : Router, private toastr : ToastrService) { }

  ngOnInit(): void {
    this.produtoService.getAll()
    .subscribe(
      ( resposta ) => {this.produtos = resposta;
        //console.log( resposta );  
      },
      ( error )  => {alert( error.status )
      }
    );
  }

  onTabelaClick(){
    this.isShow = !this.isShow;
  }

  onSelectedBox( selecionado ){
    //alert( selecionado );
    this.minhaClasse = selecionado;
  }

  maisDetalhes( produto ){
    //alert( produto.nome );
    this.produtoSelecionadoPai = produto;
  }

  receberEventoPai( valor ){
    alert( valor ); 
  }

  editar( produto ){
    this.Router.navigate( ['produtos', produto.id] );
  }

  deletar( id ){
    this.produtoService.delete( id)
    .subscribe(
      ( response ) => {
        //alert('Produto deletado com sucesso');

        //Achar posicao do elemento no vetor produtos
        let index = this.produtos.findIndex( x => {return x.id == id});

        this.produtos.splice(index, 1);
        
        this.toastr.success('Produto deletado com sucesso!');
      },
      (error) => {
        this.toastr.error( 'Erro ao deletar produto!' );
      }
    );
  }

}
