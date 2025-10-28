package sc302072x.service;

import sc302072x.entity.Carteira;
import sc302072x.entity.Posicao;
import sc302072x.repository.CarteiraRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CarteiraService {

    private final CarteiraRepository repo;

    public CarteiraService(CarteiraRepository repo) {
        this.repo = repo;
    }

    public Page<Carteira> listar(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Optional<Carteira> buscar(Integer id) {
        return repo.findById(id);
    }

    public Carteira salvar(Carteira c) {
        return repo.save(c);
    }

    public void remover(Integer id) {
        repo.deleteById(id);
    }

    public Carteira adicionarPosicao(Integer id, Posicao p) {
        var c = repo.findById(id).orElseThrow();
        c.getPosicoes().add(p);
        return repo.save(c);
    }

    public void removerPosicao(Integer idCarteira, Integer idPosicao) {
        var c = repo.findById(idCarteira).orElseThrow();
        c.getPosicoes().removeIf(pp -> Objects.equals(pp.getId(), idPosicao));
        repo.save(c);
    }
}
