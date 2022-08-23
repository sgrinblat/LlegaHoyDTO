import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';

import { AppComponent } from './app.component';
import { HomepageModule } from './homepage/homepage.module';
import { AppRoutingModule } from './app-routing.module';
import { NosotrosModule } from './nosotros/nosotros.module';
import { ContactoModule } from './contacto/contacto.module';
import { LoginModule } from './login/login.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    [SweetAlert2Module.forRoot()],
    AppRoutingModule,
    HomepageModule,
    ContactoModule,
    NosotrosModule,
    LoginModule

  ],
  exports: [
    ReactiveFormsModule,
    FormsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
