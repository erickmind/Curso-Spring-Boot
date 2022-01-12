import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  title = 'bla bla';
  minhaVariavel = "Angular 9";
  meuTexto; // Variavel global do metodo

  hoje = new Date();
  obj = { nome : 'Meu nome'};

  site = "http://grandeporte.com.br";

  getMinhaVariavel(){
    return 'Um texto';
  }

  onClick(){
    alert("Event Binding");
  }

  onKeyup( inputText ){
    //let cor = "Azul"; // para declarar variavel local do metodo, deve-se usar "let"
    this.meuTexto = inputText; // para usar variavel global da classe, deve-se usar "this."
    //console.log ( inputText );
  }

}
