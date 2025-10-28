package org.service;

import org.entity.Transacao;
import org.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    private final TransacaoRepository repo;

    public TransacaoService(TransacaoRepository repo) {
        this.repo = repo;
    }

    public List<Transacao> listar() {
        return repo.findAll();
    }

    public Optional<Transacao> buscar(Integer id) {
        return repo.findById(id);
    }

    public Transacao salvar(Transacao t) {
        return repo.save(t);
    }

    public void remover(Integer id) {
        repo.deleteById(id);
    }
}
