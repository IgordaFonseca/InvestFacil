package sc302072x.repository;

import sc302072x.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> { Optional<Usuario> findByEmail(String email);}