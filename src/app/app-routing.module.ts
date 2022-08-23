import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { SobreNosotrosComponent } from './nosotros/sobreNosotros/sobreNosotros.component';
import { MainpageComponent } from './homepage/mainpage/mainpage.component';
import { ServiciosPageComponent } from './servicios/serviciosPage/serviciosPage.component';
import { ContactoPageComponent } from './contacto/contactoPage/contactoPage.component';
import { LoginPageComponent } from './login/loginPage/loginPage.component';
import { ListaPersonasComponent } from './contacto/lista-personas/lista-personas.component';
import { RegisterComponent } from './login/register/register.component';

const routes: Routes = [
  {
    path: "",
    component: MainpageComponent,
    pathMatch: "full"
  },
  {
    path: "nosotros",
    component: SobreNosotrosComponent
  },
  {
    path: "servicios",
    component: ServiciosPageComponent
  },
  {
    path: "contacto",
    component: ContactoPageComponent
  },
  {
    path: "login",
    component: LoginPageComponent
  },
  {
    path: "registrar",
    component: RegisterComponent
  },
  {
    path: "formularios",
    component: ListaPersonasComponent
  },
]

@NgModule({
  imports: [
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class AppRoutingModule {}
