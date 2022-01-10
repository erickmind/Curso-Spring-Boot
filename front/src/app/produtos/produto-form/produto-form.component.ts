import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ProdutoService } from '../produto.service';

@Component({
  selector: 'app-produto-form',
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.scss']
})
export class ProdutoFormComponent implements OnInit {

  formulario! : FormGroup;

  constructor( private activatedRoute : ActivatedRoute,
    private produtoService : ProdutoService,
    private formBuilder : FormBuilder
      ) {

        this.formulario = this.formBuilder
        .group(
          {
            emailControl : [ null , [ Validators.required, Validators.minLength( 8 ) ] ],
            passwordControl : [ null, [ Validators.required ] ]
          }
        );

       }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(
      (rotaParams) => {
        console.log( rotaParams?.['id'] );
        this.get( rotaParams?.['id'] );
      }
    );
  }

  isFieldValid( nomeField ){
    return !this.formulario.get( nomeField )?.valid && this.formulario.get( nomeField )?.touched;
  }

  private get( id ){
    this.produtoService.get( id )
    .subscribe(
      ( response ) => {
        console.log( response );
      }
    );
  }

  onSubmit(){
    alert( "asasaa" );
  }

}
