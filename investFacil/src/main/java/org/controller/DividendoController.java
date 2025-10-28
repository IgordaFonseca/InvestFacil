package org.controller;

import org.entity.Dividendo;
import org.service.DividendoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/dividendos")
public class DividendoController {

    private final DividendoService service;

    public DividendoController(DividendoService service) {
        this.service = service;
    }

    // Listar todos dividendos
    @GetMapping
    public List<Dividendo> listar() {
        return service.listar();
    }

    // Buscar por id
    @GetMapping("/{id}")
    public Dividendo buscar(@PathVariable Integer id) {
        return service.buscar(id).orElseThrow();
    }

    // Criar novo dividendo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dividendo criar(@Valid @RequestBody Dividendo dividendo) {
        return service.salvar(dividendo);
    }

    // Remover dividendo
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        service.remover(id);
    }
}
