import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-produto-detalhe',
  templateUrl: './produto-detalhe.component.html',
  styleUrls: ['./produto-detalhe.component.scss']
})
export class ProdutoDetalheComponent implements OnInit {

  @Input()
  produtoSelecionadoFilho : any;

  @Output()
  notificador = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  upperCaseNome(){
    return this.produtoSelecionadoFilho?.nome.toUpperCase() ?? 'padrão';
  }

  notificarPai(){
    this.notificador.emit( this.produtoSelecionadoFilho?.id ?? 'id inexistente');
  }
}
