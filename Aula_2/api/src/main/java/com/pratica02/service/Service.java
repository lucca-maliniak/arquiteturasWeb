package com.pratica02.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class Service {
    private final String apiBase = "https://fipe.parallelum.com.br/api/v2";

    private String _obterMarcasPorTipo = "/{vehicleType}/brands";
    private String _obterModelosPorMarca = "/{vehicleType}/brands/{brandId}/models";
    private String _obterAnoPorModelo = "/{vehicleType}/brands/{brandId}/models/{modelId}/years";
    private String _obterInformacoesFipe = "/{vehicleType}/brands/{brandId}/models/{modelId}/years/{yearId}";
    private String _obterAnoVeiculoPorMarca = "/{vehicleType}/brands/{brandId}/years";
    private String _obterModeloVeiculoPorMarcaEAno = "/{vehicleType}/brands/{brandId}/years/{yearId}/models";

    public Service(){}

    private String conexaoApi(String url, Object... parametros) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiBase + url);
        String finalUrl = builder.buildAndExpand(parametros).toUriString();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(finalUrl, String.class);

        String dados = "";
        if (response.getStatusCode().is2xxSuccessful()) {
            dados = response.getBody();
        } else {
            dados = "Não foi possível obter os dados! :(";
        }
        return dados;
    };

    public String obterMarcasPorTipo(String tipoVeiculo) {
        String marcas = this.conexaoApi(_obterMarcasPorTipo, tipoVeiculo);
        return marcas;
    }
    public String obterModelosPorMarca(String tipoVeiculo, String idMarca) {
        String modelos = this.conexaoApi(_obterModelosPorMarca, tipoVeiculo, idMarca);
        return modelos;
    }
    public String obterAnoPorModelo(String tipoVeiculo, String idMarca, String idModelo) {
        String ano = this.conexaoApi(_obterAnoPorModelo, tipoVeiculo, idMarca, idModelo);
        return ano;
    }
    public String obterInformacoesFipe(String tipoVeiculo, String idMarca, String idModelo, String ano) {
        String informacoesFipe = this.conexaoApi(_obterInformacoesFipe, tipoVeiculo, idMarca, idModelo, ano);
        return informacoesFipe;
    }
    public String obterAnoVeiculoPorMarca(String tipoVeiculo, String idMarca) {
        String ano = this.conexaoApi(_obterAnoVeiculoPorMarca, tipoVeiculo, idMarca);
        return ano;
    }
    public String obterModeloVeiculoPorMarcaEAno(String tipoVeiculo, String idMarca, String ano) {
        String modeloVeiculo = this.conexaoApi(_obterModeloVeiculoPorMarcaEAno, tipoVeiculo, idMarca, ano);
        return modeloVeiculo;
    }
}
