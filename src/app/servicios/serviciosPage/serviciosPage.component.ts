import { Component, ElementRef, NgModule, OnInit, Renderer2, ViewChild } from '@angular/core';

@Component({
  selector: 'app-serviciosPage',
  templateUrl: './serviciosPage.component.html',
  styleUrls: ['./serviciosPage.component.css'],
})

export class ServiciosPageComponent {

  @ViewChild('postales') postales: ElementRef;
  @ViewChild('encomiendas') encomiendas: ElementRef;
  @ViewChild('adicionales') adicionales: ElementRef;
  @ViewChild('spinner') spinner: ElementRef;

  constructor (private renderer2: Renderer2) {

  }

  mostrarPostales() {
    const spinner = this.spinner.nativeElement;
    const postalesSeccion = this.postales.nativeElement;
    const encomiendasSeccion = this.encomiendas.nativeElement;
    const adicionalesSeccion = this.adicionales.nativeElement;

    this.renderer2.setStyle(spinner, 'display', 'block');
    this.renderer2.setStyle(encomiendasSeccion, 'display', 'none');
    this.renderer2.setStyle(adicionalesSeccion, 'display', 'none');

    setTimeout(() => {
      this.renderer2.setStyle(spinner, 'display', 'none');
      this.renderer2.setStyle(postalesSeccion, 'display', 'block');
    }, 700);
  }

  mostrarEncomiendas() {
    const spinner = this.spinner.nativeElement;
    const postalesSeccion = this.postales.nativeElement;
    const encomiendasSeccion = this.encomiendas.nativeElement;
    const adicionalesSeccion = this.adicionales.nativeElement;

    this.renderer2.setStyle(spinner, 'display', 'block');
    this.renderer2.setStyle(postalesSeccion, 'display', 'none');
    this.renderer2.setStyle(adicionalesSeccion, 'display', 'none');

    setTimeout(() => {
      this.renderer2.setStyle(spinner, 'display', 'none');
      this.renderer2.setStyle(encomiendasSeccion, 'display', 'block');
    }, 700);
  }

  mostrarAdicionales() {
    const spinner = this.spinner.nativeElement;
    const postalesSeccion = this.postales.nativeElement;
    const encomiendasSeccion = this.encomiendas.nativeElement;
    const adicionalesSeccion = this.adicionales.nativeElement;

    this.renderer2.setStyle(spinner, 'display', 'block');
    this.renderer2.setStyle(postalesSeccion, 'display', 'none');
    this.renderer2.setStyle(encomiendasSeccion, 'display', 'none');

    setTimeout(() => {
      this.renderer2.setStyle(spinner, 'display', 'none');
      this.renderer2.setStyle(adicionalesSeccion, 'display', 'block');
    }, 700);
  }


}
