package sc302072x.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "renda_variavel")
public class RendaVariavel extends Ativo {
    private String setor;
    private String bolsa;
    private float valorAtual;

    public RendaVariavel(String ticker, String nome, ClasseAtivo classeAtivo, String setor, String bolsa, float valorAtual) {
        super(ticker, nome, classeAtivo);
        this.setor = setor;
        this.bolsa = bolsa;
        this.valorAtual = valorAtual;
    }

    @Override
    public String toString() {
        return "RendaVariavel{" +
                "setor='" + setor + '\'' +
                ", bolsa='" + bolsa + '\'' +
                ", valorAtual=" + valorAtual +
                '}';
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getBolsa() {
        return bolsa;
    }

    public void setBolsa(String bolsa) {
        this.bolsa = bolsa;
    }

    public float getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(float valorAtual) {
        this.valorAtual = valorAtual;
    }
}
