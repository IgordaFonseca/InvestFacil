package sc302072x.controller;

import sc302072x.dto.CarteiraDTO;
import sc302072x.dto.PosicaoDTO;
import sc302072x.entity.Carteira;
import sc302072x.entity.Posicao;
import sc302072x.mapper.CarteiraMapper;
import sc302072x.mapper.PosicaoMapper;
import sc302072x.service.CarteiraService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/carteiras")
public class CarteiraController {

    private final CarteiraService service;
    private final CarteiraMapper carteiraMapper;
    private final PosicaoMapper posicaoMapper;

    public CarteiraController(CarteiraService service,
                              CarteiraMapper carteiraMapper,
                              PosicaoMapper posicaoMapper) {
        this.service = service;
        this.carteiraMapper = carteiraMapper;
        this.posicaoMapper = posicaoMapper;
    }

    @GetMapping
    public Page<CarteiraDTO> listar(Pageable pageable) {
        return service.listar(pageable).map(carteiraMapper::toDTO);
    }

    @GetMapping("/{id}")
    public CarteiraDTO buscar(@PathVariable Integer id) {
        Carteira c = service.buscar(id).orElseThrow();
        return carteiraMapper.toDTO(c);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarteiraDTO criar(@Valid @RequestBody CarteiraDTO dto) {
        Carteira c = carteiraMapper.toEntity(dto);
        return carteiraMapper.toDTO(service.salvar(c));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        service.remover(id);
    }

    @PostMapping("/{id}/posicoes")
    @ResponseStatus(HttpStatus.CREATED)
    public CarteiraDTO adicionarPosicao(@PathVariable Integer id,
                                        @Valid @RequestBody PosicaoDTO dto) {
        Posicao posicao = posicaoMapper.toEntity(dto);
        Carteira atualizado = service.adicionarPosicao(id, posicao);
        return carteiraMapper.toDTO(atualizado);
    }

    @DeleteMapping("/{id}/posicoes/{idPosicao}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPosicao(@PathVariable Integer id,
                               @PathVariable Integer idPosicao) {
        service.removerPosicao(id, idPosicao);
    }
}
