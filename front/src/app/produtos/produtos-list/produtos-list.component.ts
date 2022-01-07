import { Component, OnInit } from '@angular/core';
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

  constructor( private produtoService : ProdutoService ) { }

  ngOnInit(): void {
    this.produtoService.getAll()
    .subscribe(
      ( resposta ) => {
        //console.log( resposta );
        this.produtos = resposta;
      },
      ( error ) => {
        alert( error.status );
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

  voltarHome(){
    
  }

}
