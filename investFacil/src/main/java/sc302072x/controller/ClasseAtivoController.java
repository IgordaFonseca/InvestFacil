package sc302072x.controller;

import sc302072x.dto.ClasseAtivoDTO;
import sc302072x.entity.ClasseAtivo;
import sc302072x.mapper.ClasseAtivoMapper;
import sc302072x.service.ClasseAtivoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClasseAtivoController {

    private final ClasseAtivoService service;
    private final ClasseAtivoMapper mapper;

    public ClasseAtivoController(ClasseAtivoService service, ClasseAtivoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ClasseAtivoDTO> listar() {
        return service.listar().stream().map(mapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public ClasseAtivoDTO buscar(@PathVariable Integer id) {
        ClasseAtivo c = service.buscar(id).orElseThrow();
        return mapper.toDTO(c);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClasseAtivoDTO criar(@Valid @RequestBody ClasseAtivoDTO dto) {
        ClasseAtivo c = mapper.toEntity(dto);
        return mapper.toDTO(service.salvar(c));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        service.remover(id);
    }
}

