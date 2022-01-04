import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produtos-list',
  templateUrl: './produtos-list.component.html',
  styleUrls: ['./produtos-list.component.scss']
})
export class ProdutosListComponent implements OnInit {

  isShow : boolean = true;
  minhaClasse : String = '';

  produtos = [
    {id: 1, nome: 'Produto 1', preco: 100},
    {id: 2, nome: 'Produto 2', preco: 200},
    {id: 3, nome: 'Produto 3', preco: 300},
    {id: 4, nome: 'Produto 4', preco: 400}
  ];

  constructor() { }

  ngOnInit(): void {
  }

  onTabelaClick(){
    this.isShow = !this.isShow;
  }

  onSelectedBox( selecionado ){
    //alert( selecionado );
    this.minhaClasse = selecionado;
  }

}
