package com.lucianodev.ds_crud_desafio.repositories;

import com.lucianodev.ds_crud_desafio.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
