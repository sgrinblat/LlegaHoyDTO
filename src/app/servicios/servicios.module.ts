import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { HomepageModule } from '../homepage/homepage.module';
import { ServiciosPageComponent } from './serviciosPage/serviciosPage.component';


@NgModule({
  declarations: [
    ServiciosPageComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HomepageModule
  ]
})
export class ServiciosModule { }
