import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-produto-detalhe',
  templateUrl: './produto-detalhe.component.html',
  styleUrls: ['./produto-detalhe.component.scss']
})
export class ProdutoDetalheComponent implements OnInit {

  @Input()
  produtoSelecionadoFilho : any;

  constructor() { }

  ngOnInit(): void {
  }

  upperCaseNome(){
    return this.produtoSelecionadoFilho?.nome.toUpperCase() ?? 'padrão';
  }

}
