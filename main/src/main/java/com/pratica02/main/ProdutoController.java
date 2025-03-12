package com.pratica02.main;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratica02.domain.Produto;

@RestController
public class ProdutoController {
    private static List<Produto> listaProdutos = new ArrayList<>();

    @PostMapping("/produtos")
	public static void adicionarProdutos(@RequestBody Produto produto) {
        listaProdutos.add(produto);
	}

    @GetMapping("/produtos")
	public static List<Produto> listarProdutos() {
        return listaProdutos;
	}

    @PutMapping("/produtos/{id}")
	public static void alterarProduto(@PathVariable int id, @RequestBody Produto novoProduto) {
        Produto produtoSelecionado = 
            listaProdutos
                .stream()
                .filter((Produto produto) -> produto.getId() == id)
                .findFirst()
                .orElse(null);
        produtoSelecionado.setNome(novoProduto.getNome());
        produtoSelecionado.setDescricao(novoProduto.getDescricao());
	}

    @DeleteMapping("/produtos/{id}")
	public static void removerProduto(@PathVariable int id) {
        Produto produtoSelecionado = 
            listaProdutos
                .stream()
                .filter((Produto produto) -> produto.getId() == id)
                .findFirst()
                .orElse(null);
        listaProdutos.remove(produtoSelecionado);
	}
}
