package org.controller;

import org.entity.Posicao;
import org.entity.Transacao;
import org.service.PosicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posicoes")
public class PosicaoController {

    private final PosicaoService service;

    public PosicaoController(PosicaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Posicao> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Posicao buscar(@PathVariable Integer id) {
        return service.buscar(id).orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Posicao criar(@Valid @RequestBody Posicao posicao) {
        return service.salvar(posicao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        service.remover(id);
    }

    @PostMapping("/{id}/transacoes")
    @ResponseStatus(HttpStatus.CREATED)
    public Posicao aplicarTransacao(@PathVariable Integer id,
                                    @Valid @RequestBody Transacao transacao) {
        return service.aplicarTransacao(id, transacao);
    }

    @DeleteMapping("/{id}/transacoes/{idTransacao}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerTransacao(@PathVariable Integer id,
                                 @PathVariable Integer idTransacao) {
        service.removerTransacao(id, idTransacao);
    }
}
