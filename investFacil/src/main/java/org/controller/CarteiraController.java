package org.controller;

import org.entity.Carteira;
import org.entity.Posicao;
import org.service.CarteiraService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/carteiras")
public class CarteiraController {

    private final CarteiraService service;

    public CarteiraController(CarteiraService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Carteira> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public Carteira buscar(@PathVariable Integer id) {
        return service.buscar(id).orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carteira criar(@Valid @RequestBody Carteira carteira) {
        return service.salvar(carteira);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        service.remover(id);
    }

    @PostMapping("/{id}/posicoes")
    @ResponseStatus(HttpStatus.CREATED)
    public Carteira adicionarPosicao(@PathVariable Integer id,
                                     @Valid @RequestBody Posicao posicao) {
        return service.adicionarPosicao(id, posicao);
    }

    @DeleteMapping("/{id}/posicoes/{idPosicao}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPosicao(@PathVariable Integer id,
                               @PathVariable Integer idPosicao) {
        service.removerPosicao(id, idPosicao);
    }
}
