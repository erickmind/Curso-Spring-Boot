import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
];

@NgModule({
  imports: [RouterModule.forChild(routes)], // forChild porque é um módulo filho
  exports: [RouterModule]
})
export class SharedRoutingModule { }
