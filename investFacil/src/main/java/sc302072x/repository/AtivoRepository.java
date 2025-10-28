package sc302072x.repository;

import sc302072x.entity.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtivoRepository extends JpaRepository<Ativo, String> {}