import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm! : FormGroup;
  loading = false;
  submitted = false;
  returnUrl! : string;
  error = '';

  constructor(private formBuilder : FormBuilder,
    private route : ActivatedRoute,
    private router : Router) {

      this.returnUrl = '/home';
     }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username : ['', Validators.required],
      password : ['', Validators.required]
    })
  }

  get f(){
    return this.loginForm.controls
  }

  onSubmit(){
    this.submitted = true;

    if ( this.loginForm.invalid ){
      return;
    }

    this.loading = true;
  }

}
