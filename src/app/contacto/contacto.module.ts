import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';

import { HomepageModule } from '../homepage/homepage.module';
import { ContactoPageComponent } from './contactoPage/contactoPage.component';
import { ListaPersonasComponent } from './lista-personas/lista-personas.component';


@NgModule({
  declarations: [
    ContactoPageComponent,
    ListaPersonasComponent,
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    [SweetAlert2Module],
    HomepageModule,
  ],
  exports: [
    ReactiveFormsModule,
    FormsModule,
  ]
})
export class ContactoModule { }
