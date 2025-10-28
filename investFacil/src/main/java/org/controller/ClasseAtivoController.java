package org.controller;

import org.entity.ClasseAtivo;
import org.service.ClasseAtivoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClasseAtivoController {

    private final ClasseAtivoService service;

    public ClasseAtivoController(ClasseAtivoService service) {
        this.service = service;
    }

    // Listar todas as classes
    @GetMapping
    public List<ClasseAtivo> listar() {
        return service.listar();
    }

    // Buscar por id
    @GetMapping("/{id}")
    public ClasseAtivo buscar(@PathVariable Integer id) {
        return service.buscar(id).orElseThrow();
    }

    // Criar nova classe
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClasseAtivo criar(@Valid @RequestBody ClasseAtivo classe) {
        return service.salvar(classe);
    }

    // Remover classe
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        service.remover(id);
    }
}
