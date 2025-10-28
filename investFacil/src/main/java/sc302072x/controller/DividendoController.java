package sc302072x.controller;

import sc302072x.dto.DividendoDTO;
import sc302072x.entity.Dividendo;
import sc302072x.mapper.DividendoMapper;
import sc302072x.service.DividendoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/dividendos")
public class DividendoController {

    private final DividendoService service;
    private final DividendoMapper mapper;

    public DividendoController(DividendoService service, DividendoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<DividendoDTO> listar() {
        return service.listar().stream().map(mapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public DividendoDTO buscar(@PathVariable Integer id) {
        Dividendo d = service.buscar(id).orElseThrow();
        return mapper.toDTO(d);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DividendoDTO criar(@Valid @RequestBody DividendoDTO dto) {
        Dividendo d = mapper.toEntity(dto);
        return mapper.toDTO(service.salvar(d));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        service.remover(id);
    }
}
