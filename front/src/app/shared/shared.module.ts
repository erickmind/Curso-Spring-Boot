import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedRoutingModule } from './shared-routing.module';
import { FormErrorsComponent } from './form-errors/form-errors.component';
import { HighlightDirective } from './diretivas/highlight.directive';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

@NgModule({
  declarations: [
    FormErrorsComponent,
    HighlightDirective
  ],
  imports: [
    CommonModule,
    SharedRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot()
  ],
  exports:[
    FormErrorsComponent,
    HighlightDirective,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    ToastrModule
  ]
})
export class SharedModule { }
