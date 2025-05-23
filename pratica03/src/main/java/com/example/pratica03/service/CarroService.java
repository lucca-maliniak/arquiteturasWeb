package com.example.pratica03.service;

import com.example.pratica03.model.Carro;
import com.example.pratica03.repository.CarroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> listar() {
        return carroRepository.findAll();
    }

    public Carro criar(@Valid Carro carro) {
        carro.setDataCompra(java.time.LocalDateTime.now());
        return carroRepository.save(carro);
    }

    public Carro atualizar(Long id, @Valid Carro carroAtualizado) {
        Optional<Carro> carroOptional = carroRepository.findById(id);
        if (carroOptional.isEmpty()) {
            throw new RuntimeException("Carro não encontrado!");
        }
        Carro carro = carroOptional.get();
        carro.setModelo(carroAtualizado.getModelo());
        carro.setDescricao(carroAtualizado.getDescricao());
        return carroRepository.save(carro);
    }

    public void excluir(Long id) {
        carroRepository.deleteById(id);
    }
}