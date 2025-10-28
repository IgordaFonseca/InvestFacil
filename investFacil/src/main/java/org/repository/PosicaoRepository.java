package org.repository;

import org.entity.Posicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosicaoRepository extends JpaRepository<Posicao, Integer> {}