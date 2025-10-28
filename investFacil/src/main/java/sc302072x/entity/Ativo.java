package sc302072x.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ativo")

public abstract class Ativo {
    @Id
    private String ticker;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "classe_id") // chave estrangeira na tabela "ativo"
    private ClasseAtivo classeAtivo;
    public Ativo() {
    }

    public Ativo(String ticker, String nome, ClasseAtivo classeAtivo) {
        this.ticker = ticker;
        this.nome = nome;
        this.classeAtivo = classeAtivo;
    }

    @Override
    public String toString() {
        return "Ativo{" +
                "ticker='" + ticker + '\'' +
                ", nome='" + nome + '\'' +
                ", classeAtivo=" + classeAtivo +
                '}';
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ClasseAtivo getClasseAtivo() {
        return classeAtivo;
    }

    public void setClasseAtivo(ClasseAtivo classeAtivo) {
        this.classeAtivo = classeAtivo;
    }
}
