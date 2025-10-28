package org.controller;

import org.entity.Usuario;
import org.entity.Carteira;
import org.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // Listar todos
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    // Buscar por CPF
    @GetMapping("/{cpf}")
    public Usuario buscar(@PathVariable String cpf) {
        return service.buscar(cpf).orElseThrow();
    }

    // Criar novo usuário
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario criar(@Valid @RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }

    // Remover usuário
    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable String cpf) {
        service.remover(cpf);
    }

    // Adicionar carteira a um usuário
    @PostMapping("/{cpf}/carteiras")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario adicionarCarteira(@PathVariable String cpf,
                                     @Valid @RequestBody Carteira carteira) {
        return service.adicionarCarteira(cpf, carteira);
    }
}
