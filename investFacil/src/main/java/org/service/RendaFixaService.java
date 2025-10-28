package org.service;

import org.entity.RendaFixa;
import org.repository.RendaFixaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RendaFixaService {

    private final RendaFixaRepository repo;

    public RendaFixaService(RendaFixaRepository repo) {
        this.repo = repo;
    }

    public List<RendaFixa> listar() {
        return repo.findAll();
    }

    public Optional<RendaFixa> buscar(String ticker) {
        return repo.findById(ticker);
    }

    public RendaFixa salvar(RendaFixa r) {
        return repo.save(r);
    }

    public void remover(String ticker) {
        repo.deleteById(ticker);
    }
}
