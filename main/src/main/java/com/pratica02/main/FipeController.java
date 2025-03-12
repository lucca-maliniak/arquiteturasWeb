package com.pratica02.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratica02.service.Service;

@RestController
@RequestMapping("/fipe")
public class FipeController {
    static Service service = new Service();
    
    @GetMapping("/{tipoVeiculo}/marcas")
    public static String obterMarcasPorTipo(@PathVariable String tipoVeiculo) {
        return service.obterMarcasPorTipo(tipoVeiculo);
    };
    
    @GetMapping("/{tipoVeiculo}/marcas/{idMarca}/modelos")
    public static String obterModelosPorMarca(@PathVariable String tipoVeiculo, @PathVariable String idMarca) {
        return service.obterModelosPorMarca(tipoVeiculo, idMarca);
    };
    
    @GetMapping("/{tipoVeiculo}/marcas/{idMarca}/modelos/{idModelo}/ano")
    public static String obterAnoPorModelo(@PathVariable String tipoVeiculo, @PathVariable String idMarca, @PathVariable String idModelo) {
        return service.obterAnoPorModelo(tipoVeiculo, idMarca, idModelo);
    };
    
    @GetMapping("/{tipoVeiculo}/marcas/{idMarca}/modelos/{idModelo}/ano/{ano}")
    public static String obterInformacoesFipe(@PathVariable String tipoVeiculo, @PathVariable String idMarca, @PathVariable String idModelo, @PathVariable String ano) {
        return service.obterInformacoesFipe(tipoVeiculo, idMarca, idModelo, ano);
    };
    
    @GetMapping("/{tipoVeiculo}/marcas/{idMarca}/ano")
    public static String obterAnoVeiculoPorMarca(@PathVariable String tipoVeiculo, @PathVariable String idMarca) {
        return service.obterAnoVeiculoPorMarca(tipoVeiculo, idMarca);
    };
    
    @GetMapping("/{tipoVeiculo}/marcas/{idMarca}/ano/{ano}/modelos")
    public static String obterModeloVeiculoPorMarcaEAno(@PathVariable String tipoVeiculo, @PathVariable String idMarca, @PathVariable String ano) {
        return service.obterModeloVeiculoPorMarcaEAno(tipoVeiculo, idMarca, ano);
    };
}
