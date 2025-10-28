package sc302072x.service;

import sc302072x.entity.Ativo;
import sc302072x.entity.RendaFixa;
import sc302072x.entity.RendaVariavel;
import sc302072x.repository.AtivoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtivoService {

    private final AtivoRepository repo;

    public AtivoService(AtivoRepository repo) {
        this.repo = repo;
    }

    public List<Ativo> listar() {
        return repo.findAll();
    }

    public Optional<Ativo> buscar(String ticker) {
        return repo.findById(ticker);
    }

    public Ativo salvar(Ativo ativo) {
        return repo.save(ativo);
    }

    public void remover(String ticker) {
        repo.deleteById(ticker);
    }

    public RendaFixa salvarRendaFixa(RendaFixa rf) {
        return repo.save(rf);
    }

    public RendaVariavel salvarRendaVariavel(RendaVariavel rv) {
        return repo.save(rv);
    }
}
