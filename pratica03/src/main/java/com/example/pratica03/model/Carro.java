package com.example.pratica03.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Entity
@Document(collection = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 

    @NotNull
    @Size(min = 3, max = 100)
    private String modelo;

    @Size(max = 500)
    private String descricao;

    private LocalDateTime dataCompra;
}