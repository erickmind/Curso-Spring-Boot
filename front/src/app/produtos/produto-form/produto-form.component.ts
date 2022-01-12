import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ProdutoService } from '../produto.service';

@Component({
  selector: 'app-produto-form',
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.scss']
})
export class ProdutoFormComponent implements OnInit {

  formulario! : FormGroup;
  id_produto! : number;
  isEdition : boolean = false;

  buttonText : string = 'Salvar';

  constructor( private activatedRoute : ActivatedRoute,
    private produtoService : ProdutoService,
    private formBuilder : FormBuilder,
    private router : Router,
    private toastr : ToastrService
      ) {

        this.formulario = this.formBuilder
        .group(
          {
            nome : [ null , [ Validators.required ] ],
            preco : [ null, [ Validators.required ] ]
          }
        );

       }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(
      (rotaParams) => {

        if(rotaParams?.['id']){
        //console.log( rotaParams?.['id'] );
          this.id_produto = rotaParams?.['id']
          this.get( rotaParams?.['id'] );
          this.buttonText = 'Alterar';
          this.isEdition = true;
        }
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
        // Passamos um objeto para patchValue = { nome: P1, preco: 100} vindo da API
        this.formulario.patchValue( response );
      }
    );
  }

  onSubmit(){
    if (this.isEdition){
      this.produtoService.update( this.id_produto, this.formulario.value ).
      subscribe(
        ( response ) => {
          this.toastr.info(' Produto editado com sucesso! ');
          this.router.navigate(['produtos']);
        }
      );
    }else{
      this.produtoService.create( this.formulario.value )
      .subscribe(
        ( response ) => {
          this.toastr.success(' Produto criado com sucesso! ');
          this.router.navigate(['produtos']);
        }
      );
    }
  }
}
