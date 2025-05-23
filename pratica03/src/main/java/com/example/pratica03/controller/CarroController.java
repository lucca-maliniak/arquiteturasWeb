package com.example.pratica03.controller;

import com.example.pratica03.model.Carro;
import com.example.pratica03.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<Carro> listar() {
        return carroService.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carro criar(@Valid @RequestBody Carro carro) {
        return carroService.criar(carro);
    }

    @PutMapping("/{id}")
    public Carro atualizar(@PathVariable Long id, @Valid @RequestBody Carro carro) {
        return carroService.atualizar(id, tarefa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        carroService.excluir(id);
    }
}