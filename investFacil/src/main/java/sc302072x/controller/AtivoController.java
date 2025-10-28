package sc302072x.controller;

import sc302072x.dto.RendaFixaDTO;
import sc302072x.dto.RendaVariavelDTO;
import sc302072x.dto.AtivoDTO;
import sc302072x.entity.RendaFixa;
import sc302072x.entity.RendaVariavel;
import sc302072x.mapper.RendaFixaMapper;
import sc302072x.mapper.RendaVariavelMapper;
import sc302072x.service.AtivoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/ativos")
public class AtivoController {

    private final AtivoService service;
    private final RendaFixaMapper rfMapper;
    private final RendaVariavelMapper rvMapper;

    public AtivoController(AtivoService service,
                           RendaFixaMapper rfMapper,
                           RendaVariavelMapper rvMapper) {
        this.service = service;
        this.rfMapper = rfMapper;
        this.rvMapper = rvMapper;
    }

    @GetMapping
    public List<AtivoDTO> listar() {
        return service.listar().stream()
                .map(a -> new AtivoDTO(a.getTicker(), a.getNome(),
                        a.getClasseAtivo() != null ? a.getClasseAtivo().getId() : null))
                .toList();
    }

    @PostMapping("/renda-fixa")
    @ResponseStatus(HttpStatus.CREATED)
    public RendaFixaDTO criarRendaFixa(@Valid @RequestBody RendaFixaDTO dto) {
        RendaFixa entity = rfMapper.toEntity(dto);
        return rfMapper.toDTO(service.salvarRendaFixa(entity));
    }

    @PostMapping("/renda-variavel")
    @ResponseStatus(HttpStatus.CREATED)
    public RendaVariavelDTO criarRendaVariavel(@Valid @RequestBody RendaVariavelDTO dto) {
        RendaVariavel entity = rvMapper.toEntity(dto);
        return rvMapper.toDTO(service.salvarRendaVariavel(entity));
    }

    @DeleteMapping("/{ticker}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable String ticker) {
        service.remover(ticker);
    }
}
