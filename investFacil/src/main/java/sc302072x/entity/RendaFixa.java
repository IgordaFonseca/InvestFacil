package sc302072x.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;
@Entity
@Table(name = "renda_fixa")
public class RendaFixa extends Ativo {
    private float taxa;
    private Date vencimento;
    private String indexador;

    public RendaFixa(String ticker, String nome, ClasseAtivo classeAtivo, float taxa, Date vencimento, String indexador) {
        super(ticker, nome, classeAtivo);
        this.taxa = taxa;
        this.vencimento = vencimento;
        this.indexador = indexador;
    }

    @Override
    public String toString() {
        return "RendaFixa{" +
                "taxa=" + taxa +
                ", vencimento=" + vencimento +
                ", indexador='" + indexador + '\'' +
                '}';
    }

    public void alterarTaxa(float taxa){
        this.taxa = taxa;
    }

    public void alterarVencimento(Date date){
        this.vencimento = date;
    }

    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public String getIndexador() {
        return indexador;
    }

    public void setIndexador(String indexador) {
        this.indexador = indexador;
    }
}
