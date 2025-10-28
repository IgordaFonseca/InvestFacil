package org.controller;

import org.entity.Ativo;
import org.entity.RendaFixa;
import org.entity.RendaVariavel;
import org.service.AtivoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/ativos")
public class AtivoController {

    private final AtivoService service;

    public AtivoController(AtivoService service) {
        this.service = service;
    }

    // Listar todos os ativos
    @GetMapping
    public List<Ativo> listar() {
        return service.listar();
    }

    // Buscar ativo por ticker
    @GetMapping("/{ticker}")
    public Ativo buscar(@PathVariable String ticker) {
        return service.buscar(ticker).orElseThrow();
    }

    // Criar ativo de renda fixa
    @PostMapping("/renda-fixa")
    @ResponseStatus(HttpStatus.CREATED)
    public RendaFixa criarRendaFixa(@Valid @RequestBody RendaFixa rf) {
        return service.salvarRendaFixa(rf);
    }

    // Criar ativo de renda variável
    @PostMapping("/renda-variavel")
    @ResponseStatus(HttpStatus.CREATED)
    public RendaVariavel criarRendaVariavel(@Valid @RequestBody RendaVariavel rv) {
        return service.salvarRendaVariavel(rv);
    }

    // Remover ativo
    @DeleteMapping("/{ticker}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable String ticker) {
        service.remover(ticker);
    }
}
