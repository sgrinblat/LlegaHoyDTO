import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { HomepageModule } from '../homepage/homepage.module';
import { SobreNosotrosComponent } from './sobreNosotros/sobreNosotros.component';



@NgModule({
  declarations: [
    SobreNosotrosComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HomepageModule
  ],
})
export class NosotrosModule { }
