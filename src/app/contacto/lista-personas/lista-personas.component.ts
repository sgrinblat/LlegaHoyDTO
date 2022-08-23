import { Component, OnInit } from '@angular/core';
import { ConexionService } from 'src/app/service/conexion.service';
import { Persona } from '../../persona';
import { User } from '../../user';


@Component({
  selector: 'app-lista-personas',
  templateUrl: './lista-personas.component.html',
  styleUrls: ['./lista-personas.component.css']
})
export class ListaPersonasComponent implements OnInit {

  personas: Persona[];
  usuarios: User[];

  constructor(private conexion: ConexionService) { }

  ngOnInit(): void {
    this.obtenerPersonas();
    this.obtenerUsuarios();
  }

  private obtenerPersonas(){
    this.conexion.obtenerListaDelFormulario().subscribe(dato => {
      this.personas = dato;
    })
  }

  private obtenerUsuarios(){
    this.conexion.obtenerUsuariosRegistrados().subscribe(dato => {
      this.usuarios = dato;
    })
  }

}
