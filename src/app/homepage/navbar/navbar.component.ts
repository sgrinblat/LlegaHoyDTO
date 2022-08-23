import { Component, OnInit, Renderer2, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  @ViewChild('switch') switch : ElementRef;


  constructor( private renderer2 : Renderer2) { }

  ngOnInit() {

    const SWITCH_BOTON = document.querySelector("#switch");

    if(localStorage.getItem("dark-mode") === "true") {
      document.body.classList.add("dark");
      SWITCH_BOTON.classList.add("active");
    } else {
      document.body.classList.remove("dark");
      SWITCH_BOTON.classList.remove("active");
    }
  }

  cambiarTema () {

    document.body.classList.toggle("dark");
    const switchButton = this.switch.nativeElement;

    this.renderer2.addClass(switchButton, 'active');

    if(document.body.classList.contains("dark")){
      localStorage.setItem("dark-mode", "true");
    } else {
      localStorage.setItem("dark-mode", "false");
      this.renderer2.removeClass(switchButton, 'active');
  }
  }

}
