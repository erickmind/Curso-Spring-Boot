import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'bla bla';
  minhaVariavel = "Angular 9";
  meuTexto; // Variavel global do metodo

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
