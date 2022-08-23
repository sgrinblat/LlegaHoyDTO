import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ConexionService } from 'src/app/service/conexion.service';
import { User } from 'src/app/user';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  contactForm!: FormGroup;
  user : User = new User();

  constructor(private readonly fb: FormBuilder, private router: Router, private conexion : ConexionService) { }

  ngOnInit() {
    this.contactForm = this.initForm();
  }

  registrarUsuario() {
    console.log(this.user);
    this.conexion.registerUser(this.user).subscribe(dato =>{
      Swal.fire(
        'Registro exitoso',
        `Has registrado correctamente tu usuario. Bienvenido ${this.user.registerUsername}`,
        'success'
      )
      this.contactForm.reset();
    }, error => Swal.fire(
      'Error',
      `Lo sentimos, no se pudo registrar el usuario en este momento.`,
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
