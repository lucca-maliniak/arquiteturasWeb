package com.example.pratica03.repository;

import com.example.tarefas.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {}