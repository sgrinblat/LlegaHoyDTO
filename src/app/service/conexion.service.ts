import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { Persona } from '../persona';
import { User } from '../user';

@Injectable({
  providedIn: 'root'
})
export class ConexionService {

  // Esta URL obtiene los datos del formulario y de los usuarios de la base de datos
  private baseURL = "http://localhost:8080/formulario/personas"
  private baseURLUser = "http://localhost:8080/usuarios/personas"
  private baseURLRegister = "http://localhost:8080/usuarios/registros"

  constructor(private httpClient: HttpClient) { }

  // este método nos sirve para obtener a las personas que mandaron el formulario
  obtenerListaDelFormulario():Observable<Persona[]> {
    return this.httpClient.get<Persona[]>(`${this.baseURL}`);
  }

  // este método nos sirve para guardar un formulario
  guardarFormulario(persona: Persona) : Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, persona);
  }

  // -------------------------------------------

  // método para loguear usuario
  loginUser(user: User): Observable<object> {
    return this.httpClient.post(`${this.baseURLUser}`, user)
  }

  // método para registrar un usuario
  registerUser(user : User): Observable<object> {
    return this.httpClient.post(`${this.baseURLRegister}`, user);

  }
// método para mostrar usuarios registrados
  obtenerUsuariosRegistrados():Observable<User[]> {
    return this.httpClient.get<User[]>(`${this.baseURLUser}`);
  }


}
