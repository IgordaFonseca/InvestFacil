package sc302072x.repository;

import sc302072x.entity.Posicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosicaoRepository extends JpaRepository<Posicao, Integer> {}