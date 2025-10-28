package sc302072x.controller;

import sc302072x.dto.PosicaoDTO;
import sc302072x.dto.TransacaoDTO;
import sc302072x.entity.Posicao;
import sc302072x.entity.Transacao;
import sc302072x.mapper.PosicaoMapper;
import sc302072x.mapper.TransacaoMapper;
import sc302072x.service.PosicaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/posicoes")
public class PosicaoController {

    private final PosicaoService service;
    private final PosicaoMapper posicaoMapper;
    private final TransacaoMapper transacaoMapper;

    public PosicaoController(PosicaoService service,
                             PosicaoMapper posicaoMapper,
                             TransacaoMapper transacaoMapper) {
        this.service = service;
        this.posicaoMapper = posicaoMapper;
        this.transacaoMapper = transacaoMapper;
    }

    @GetMapping
    public List<PosicaoDTO> listar() {
        return service.listar().stream().map(posicaoMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public PosicaoDTO buscar(@PathVariable Integer id) {
        Posicao p = service.buscar(id).orElseThrow();
        return posicaoMapper.toDTO(p);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PosicaoDTO criar(@Valid @RequestBody PosicaoDTO dto) {
        Posicao p = posicaoMapper.toEntity(dto);
        return posicaoMapper.toDTO(service.salvar(p));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        service.remover(id);
    }

    @PostMapping("/{id}/transacoes")
    @ResponseStatus(HttpStatus.CREATED)
    public PosicaoDTO aplicarTransacao(@PathVariable Integer id,
                                       @Valid @RequestBody TransacaoDTO dto) {
        Transacao t = transacaoMapper.toEntity(dto);
        Posicao atualizado = service.aplicarTransacao(id, t);
        return posicaoMapper.toDTO(atualizado);
    }

    @DeleteMapping("/{id}/transacoes/{idTransacao}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerTransacao(@PathVariable Integer id,
                                 @PathVariable Integer idTransacao) {
        service.removerTransacao(id, idTransacao);
    }
}

