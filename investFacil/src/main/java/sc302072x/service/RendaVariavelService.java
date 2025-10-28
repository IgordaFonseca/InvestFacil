package sc302072x.service;

import sc302072x.entity.RendaVariavel;
import sc302072x.repository.RendaVariavelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RendaVariavelService {

    private final RendaVariavelRepository repo;

    public RendaVariavelService(RendaVariavelRepository repo) {
        this.repo = repo;
    }

    public List<RendaVariavel> listar() {
        return repo.findAll();
    }

    public Optional<RendaVariavel> buscar(String ticker) {
        return repo.findById(ticker);
    }

    public RendaVariavel salvar(RendaVariavel r) {
        return repo.save(r);
    }

    public void remover(String ticker) {
        repo.deleteById(ticker);
    }
}
