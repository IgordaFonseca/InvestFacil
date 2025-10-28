package sc302072x.controller;

import sc302072x.dto.UsuarioDTO;
import sc302072x.dto.CarteiraDTO;
import sc302072x.entity.Usuario;
import sc302072x.entity.Carteira;
import sc302072x.mapper.UsuarioMapper;
import sc302072x.mapper.CarteiraMapper;
import sc302072x.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioMapper usuarioMapper;
    private final CarteiraMapper carteiraMapper;

    public UsuarioController(UsuarioService service,
                             UsuarioMapper usuarioMapper,
                             CarteiraMapper carteiraMapper) {
        this.service = service;
        this.usuarioMapper = usuarioMapper;
        this.carteiraMapper = carteiraMapper;
    }

    // Listar todos usuários
    @GetMapping
    public List<UsuarioDTO> listar() {
        return service.listar().stream()
                .map(usuarioMapper::toDTO)
                .toList();
    }

    // Buscar por CPF
    @GetMapping("/{cpf}")
    public UsuarioDTO buscar(@PathVariable String cpf) {
        Usuario u = service.buscar(cpf).orElseThrow();
        return usuarioMapper.toDTO(u);
    }

    // Criar novo usuário
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO criar(@Valid @RequestBody UsuarioDTO dto) {
        Usuario entity = usuarioMapper.toEntity(dto);
        Usuario salvo = service.salvar(entity);
        return usuarioMapper.toDTO(salvo);
    }

    // Remover usuário
    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable String cpf) {
        service.remover(cpf);
    }

    // Adicionar carteira ao usuário
    @PostMapping("/{cpf}/carteiras")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO adicionarCarteira(@PathVariable String cpf,
                                        @Valid @RequestBody CarteiraDTO dto) {
        Carteira carteira = carteiraMapper.toEntity(dto);
        Usuario atualizado = service.adicionarCarteira(cpf, carteira);
        return usuarioMapper.toDTO(atualizado);
    }
}

