package com.petersen.llegahoy.repositories;

import com.petersen.llegahoy.entidades.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface iFormularioRepo extends JpaRepository <Formulario, Long> {

    Optional<Formulario> findByEmailFormulario(String mail);
}
