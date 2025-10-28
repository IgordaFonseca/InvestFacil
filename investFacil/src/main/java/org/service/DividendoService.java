package org.service;

import org.entity.Dividendo;
import org.repository.DividendoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DividendoService {

    private final DividendoRepository repo;

    public DividendoService(DividendoRepository repo) {
        this.repo = repo;
    }

    public List<Dividendo> listar() {
        return repo.findAll();
    }

    public Optional<Dividendo> buscar(Integer id) {
        return repo.findById(id);
    }

    public Dividendo salvar(Dividendo d) {
        return repo.save(d);
    }

    public void remover(Integer id) {
        repo.deleteById(id);
    }
}
