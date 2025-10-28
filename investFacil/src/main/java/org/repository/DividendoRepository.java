package org.repository;

import org.entity.Dividendo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DividendoRepository extends JpaRepository<Dividendo, Integer> {}