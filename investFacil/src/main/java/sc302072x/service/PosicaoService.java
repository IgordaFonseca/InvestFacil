package sc302072x.service;

import sc302072x.entity.Posicao;
import sc302072x.entity.TipoTransacao;
import sc302072x.entity.Transacao;
import sc302072x.repository.PosicaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PosicaoService {

    private final PosicaoRepository repo;

    public PosicaoService(PosicaoRepository repo) {
        this.repo = repo;
    }

    public List<Posicao> listar() {
        return repo.findAll();
    }

    public Optional<Posicao> buscar(Integer id) {
        return repo.findById(id);
    }

    public Posicao salvar(Posicao p) {
        return repo.save(p);
    }

    public void remover(Integer id) {
        repo.deleteById(id);
    }

    public Posicao aplicarTransacao(Integer idPosicao, Transacao t) {
        var p = repo.findById(idPosicao).orElseThrow();
        p.getTransacoes().add(t);
        if (t.getTipo() == TipoTransacao.COMPRA) {
            p.setQuantidade(p.getQuantidade() + t.getQuantidade());
        }
        if (t.getTipo() == TipoTransacao.VENDA) {
            p.setQuantidade(p.getQuantidade() - t.getQuantidade());
        }
        return repo.save(p);
    }

    public void removerTransacao(Integer idPosicao, Integer idTransacao) {
        var p = repo.findById(idPosicao).orElseThrow();
        p.getTransacoes().removeIf(tx -> Objects.equals(tx.getId(), idTransacao));
        repo.save(p);
    }
}
