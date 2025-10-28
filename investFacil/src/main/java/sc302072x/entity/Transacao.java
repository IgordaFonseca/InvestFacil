package sc302072x.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name = "transacao")
public class Transacao {
    @Id
    private int id;
    private TipoTransacao tipo;
    private LocalDate data;
    private int quantidade;
    private float precoUnitario;
    private float taxa;
    private float precoTotal;

    private Ativo ativo;


    public Transacao(int id, TipoTransacao tipo, int quantidade, float precoUnitario, float taxa, Ativo ativo) {
        this.id = id;
        this.tipo = tipo;
        this.data = LocalDate.now();
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.taxa = taxa;
        this.ativo = ativo;
        calcularPrecoTotal();
    }

    public void alterarQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public void alterarPrecoUnitario(float precoUnitario){
        this.precoUnitario = precoUnitario;
    }

    public void calcularPrecoTotal(){
        precoTotal = quantidade * precoUnitario;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", data=" + data +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                ", taxa=" + taxa +
                ", precoTotal=" + precoTotal +
                ", ativo=" + ativo +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }
}
