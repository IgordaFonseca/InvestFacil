package org.service;

import org.entity.*;
import org.repository.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service public class UsuarioService {
    private final UsuarioRepository repo; private final PasswordEncoder encoder;
    public UsuarioService(UsuarioRepository repo, PasswordEncoder encoder){ this.repo=repo; this.encoder=encoder; }
    public List<Usuario> listar(){ return repo.findAll(); }
    public Optional<Usuario> buscar(String cpf){ return repo.findById(cpf); }
    public Usuario salvar(Usuario u){ if (u.getSenha()!=null) u.setSenha(encoder.encode(u.getSenha())); return repo.save(u); }
    public void remover(String cpf){ repo.deleteById(cpf); }
    public Usuario adicionarCarteira(String cpf, Carteira c){ var u = repo.findById(cpf).orElseThrow(); u.getCarteiras().add(c); return repo.save(u); }
    public Optional<Usuario> buscarPorEmail(String email){ return repo.findByEmail(email); }
}