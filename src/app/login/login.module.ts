import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';

import { HomepageModule } from '../homepage/homepage.module';
import { LoginPageComponent } from './loginPage/loginPage.component';
import { RegisterComponent } from './register/register.component';
import { Router, RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    LoginPageComponent,
    RegisterComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule,
    FormsModule,
    [SweetAlert2Module],
    HomepageModule
  ],
  exports: [
    ReactiveFormsModule,
    FormsModule
  ]
})
export class LoginModule { }
