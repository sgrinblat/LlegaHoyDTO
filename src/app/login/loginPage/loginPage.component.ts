import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SwalComponent } from '@sweetalert2/ngx-sweetalert2';
import Swal from 'sweetalert2';
import { ConexionService } from 'src/app/service/conexion.service';
import { User } from '../../user';
import { LoginModule } from '../login.module';

@Component({
  selector: 'app-loginPage',
  templateUrl: './loginPage.component.html',
  styleUrls: ['./loginPage.component.css']
})
export class LoginPageComponent implements OnInit {


  contactForm!: FormGroup;
  user : User = new User();

  constructor(private readonly fb: FormBuilder, private router: Router, private conexion : ConexionService) { }

  ngOnInit() {
    this.contactForm = this.initForm();
  }

  loguearUsuario() {
    console.log(this.user);
    this.conexion.loginUser(this.user).subscribe(dato =>{
      Swal.fire(
        'Inicio exitoso',
        `Has ingresado con tu usuario. Bienvenido ${this.user.registerUsername}`,
        'success'
      )
      this.contactForm.reset();
    }, error => Swal.fire(
      'Error',
      `Lo sentimos, el usuario o la contraseña son incorrectos.`,
      'error'
      )
    )
  }

  initForm(): FormGroup {
    return this.fb.group({
      usuario: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(20)]],
      password: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(20)]]
    })
  }

}
