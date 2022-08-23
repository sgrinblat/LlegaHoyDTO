package com.petersen.llegahoy.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String userPassword;
}
