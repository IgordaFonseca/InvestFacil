package sc302072x.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sc302072x.dto.UsuarioDTO;
import sc302072x.entity.Usuario;
import sc302072x.service.UsuarioService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Usuario> buscar(@PathVariable String cpf) {
        return usuarioService.buscarPorCpf(cpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> criar(@Valid @RequestBody UsuarioDTO dto) {
        Usuario salvo = usuarioService.salvar(dto);
        return ResponseEntity
                .created(URI.create("/api/usuarios/" + salvo.getCpf()))
                .body(salvo);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Usuario> atualizar(@PathVariable String cpf,
                                             @Valid @RequestBody UsuarioDTO dto) {
        return usuarioService.atualizar(cpf, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> excluir(@PathVariable String cpf) {
        boolean removido = usuarioService.excluirSeExistir(cpf);
        return removido ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
