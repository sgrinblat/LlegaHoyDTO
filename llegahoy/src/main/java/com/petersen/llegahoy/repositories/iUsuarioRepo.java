package com.petersen.llegahoy.repositories;

import com.petersen.llegahoy.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface iUsuarioRepo extends JpaRepository <Usuario, String> {

}
