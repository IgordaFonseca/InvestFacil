package sc302072x.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "renda_fixa")
@PrimaryKeyJoinColumn(name = "ticker")
public class RendaFixa extends Ativo {


    private Float taxa;

    private LocalDate vencimento;

    @Column(length = 50)
    private String indexador;

    public RendaFixa() {}

    public RendaFixa(String ticker, String nome, ClasseAtivo classeAtivo,
                     Float taxa, LocalDate vencimento, String indexador) {
        super(ticker, nome, classeAtivo);
        this.taxa = taxa;
        this.vencimento = vencimento;
        this.indexador = indexador;
    }

    public Float getTaxa() { return taxa; }
    public void setTaxa(Float taxa) { this.taxa = taxa; }

    public LocalDate getVencimento() { return vencimento; }
    public void setVencimento(LocalDate vencimento) { this.vencimento = vencimento; }

    public String getIndexador() { return indexador; }
    public void setIndexador(String indexador) { this.indexador = indexador; }
}
