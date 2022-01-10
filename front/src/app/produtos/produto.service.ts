import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor( private http : HttpClient) {}

  getAll(){
    // return [
    //   {id: 1, nome: 'Produto 1', preco: 100},
    //   {id: 2, nome: 'Produto 2', preco: 200},
    //   {id: 3, nome: 'Produto 3', preco: 300},
    //   {id: 4, nome: 'Produto 4', preco: 400}
    // ];
    return this.http.get('http://localhost:8080/produtos');
  }

  create( produto ){
    return this.http.post(`http://localhost:8080/produtos`, produto);
  }

  get( id ){
    return this.http.get(`http://localhost:8080/produtos/${id}`);
  }

  update( id, produto ){
    return this.http.put(`http://localhost:8080/produtos/${id}`, produto);
  }

  delete( id ){
    return this.http.delete(`http://localhost:8080/produtos/${id}`);
  }
}
