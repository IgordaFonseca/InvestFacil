package org.service;

import org.entity.ClasseAtivo;
import org.repository.ClasseAtivoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasseAtivoService {

    private final ClasseAtivoRepository repo;

    public ClasseAtivoService(ClasseAtivoRepository repo) {
        this.repo = repo;
    }

    // Listar todas as classes de ativo
    public List<ClasseAtivo> listar() {
        return repo.findAll();
    }

    // Buscar por ID
    public Optional<ClasseAtivo> buscar(Integer id) {
        return repo.findById(id);
    }

    // Salvar (criar/atualizar)
    public ClasseAtivo salvar(ClasseAtivo classe) {
        return repo.save(classe);
    }

    // Remover
    public void remover(Integer id) {
        repo.deleteById(id);
    }
}

