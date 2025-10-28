package sc302072x.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "renda_variavel")
@PrimaryKeyJoinColumn(name = "ticker")
public class RendaVariavel extends Ativo {

    @Column(length = 100)
    private String setor;

    @Column(length = 50)
    private String bolsa;

    private Float valorAtual;

    public RendaVariavel() {}

    public RendaVariavel(String ticker, String nome, ClasseAtivo classeAtivo,
                         String setor, String bolsa, Float valorAtual) {
        super(ticker, nome, classeAtivo);
        this.setor = setor;
        this.bolsa = bolsa;
        this.valorAtual = valorAtual;
    }

    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }

    public String getBolsa() { return bolsa; }
    public void setBolsa(String bolsa) { this.bolsa = bolsa; }

    public Float getValorAtual() { return valorAtual; }
    public void setValorAtual(Float valorAtual) { this.valorAtual = valorAtual; }
}
