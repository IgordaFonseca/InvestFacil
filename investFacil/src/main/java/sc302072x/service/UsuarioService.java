package sc302072x.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sc302072x.dto.UsuarioDTO;
import sc302072x.entity.Usuario;
import sc302072x.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> buscarPorCpf(String cpf) {
        return usuarioRepository.findById(cpf);
    }

    @Transactional
    public Usuario salvar(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setCpf(dto.cpf());
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        // senha criptografada com BCrypt
        usuario.setSenha(passwordEncoder.encode(dto.senha()));

        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Optional<Usuario> atualizar(String cpf, UsuarioDTO dto) {
        return usuarioRepository.findById(cpf).map(existente -> {
            existente.setNome(dto.nome());
            existente.setEmail(dto.email());
            existente.setSenha(passwordEncoder.encode(dto.senha()));
            return usuarioRepository.save(existente);
        });
    }

    @Transactional
    public boolean excluirSeExistir(String cpf) {
        if (usuarioRepository.existsById(cpf)) {
            usuarioRepository.deleteById(cpf);
            return true;
        }
        return false;
    }
}
