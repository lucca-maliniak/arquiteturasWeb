package com.pratica02.main;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratica02.model.Produto;
import com.pratica02.model.ProdutoInput;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private static List<Produto> listaProdutos = new ArrayList<>();

    @PostMapping
	public static String adicionarProdutos(@RequestBody ProdutoInput produtoInput) {
        Produto produto = new Produto(produtoInput);
        listaProdutos.add(produto);
        return "Produto cadastrado com sucesso!";
	}

    @GetMapping
	public static List<Produto> listarProdutos() {
        return listaProdutos;
	}

    @PutMapping("{id}")
	public static String alterarProduto(@PathVariable int id, @RequestBody ProdutoInput novoProduto) {
        Produto produtoSelecionado = 
            listaProdutos
                .stream()
                .filter((Produto produto) -> produto.getId() == id)
                .findFirst()
                .orElse(null);
        if (produtoSelecionado == null) {
            throw new NullPointerException("Produto não localizado");
        }
        produtoSelecionado.setNome(novoProduto.getNome());
        produtoSelecionado.setDescricao(novoProduto.getDescricao());

        return String.format("Produto %s alterado com sucesso!", produtoSelecionado.getNome());
	}

    @DeleteMapping("{id}")
	public static String removerProduto(@PathVariable int id) {
        Produto produtoSelecionado = 
            listaProdutos
                .stream()
                .filter((Produto produto) -> produto.getId() == id)
                .findFirst()
                .orElse(null);
        if (produtoSelecionado == null) {
            throw new NullPointerException("Produto não localizado");
        }
        listaProdutos.remove(produtoSelecionado);

        return String.format("Produto %s removido com sucesso!", produtoSelecionado.getNome());
	}
}
