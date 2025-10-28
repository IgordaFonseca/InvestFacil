package org.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;

public class Posicao {
    private int id;
    private Ativo ativo;
    private int quantidade;
    private float precoMedio;
    private float valorTotal;
    private LocalDate dataAtualizacao;
    private LinkedList<Transacao> transacoes;
    private LinkedList<Dividendo> dividendos;

    public Posicao(int id, Ativo ativo, int quantidade, float precoMedio, float valorTotal) {
        this.id = id;
        this.ativo = ativo;
        this.quantidade = quantidade;
        this.precoMedio = precoMedio;
        this.valorTotal = valorTotal;
        this.dataAtualizacao = LocalDate.now();
        transacoes = new LinkedList<>();
        dividendos = new LinkedList<>();
    }


    public void addTransacao(Transacao transacao){
        transacoes.add(transacao);
        calcularValorTotal(transacao);
        addQuantidade(transacao.getQuantidade());
        calcularPrecoMedio(transacao);
        atualizarDataAtualizacao();
    }

    public void removerTransacao(Transacao transacao){
        transacoes.remove(transacao);
        calcularValorTotal(transacao);
        removerQuantidade(transacao.getQuantidade());
        calcularPrecoMedio(transacao);
        atualizarDataAtualizacao();
    }

    public void removerTransacao(int idTrnsacao){
        for(Transacao t: transacoes){
            if(t.getId()==idTrnsacao){
                calcularValorTotal(t);
                removerQuantidade(t.getQuantidade());
                calcularPrecoMedio(t);
                transacoes.remove(t);
                atualizarDataAtualizacao();
            }
        }
    }

    public void listarTransacoes(){
        for(Transacao t:transacoes){
            t.toString();
        }
    }

    public void calcularValorTotal(Transacao t){
        if(t.getTipo()==TipoTransacao.COMPRA){
            this.valorTotal += t.getPrecoTotal();
        }
        else{
            this.valorTotal -= t.getPrecoTotal();

        }
    }

    public void calcularPrecoMedio(Transacao t){
        this.precoMedio = getValorTotal()/getQuantidade();

    }

    public void addQuantidade(int quantidadeCompra){
        this.quantidade += quantidadeCompra;
    }

    public void removerQuantidade(int quantidadeVenda){
        this.quantidade -= quantidadeVenda;
    }

    public void adicioarDividendo(Dividendo dividendo){
        dividendos.add(dividendo);
        atualizarDataAtualizacao();
    }

    public void removerDividndo(Dividendo dividendo){
        dividendos.remove(dividendo);
        atualizarDataAtualizacao();
    }

    public void removerDividendo(int idDividendo){
        for(Dividendo d: dividendos){
            if(d.getId()==idDividendo){
                dividendos.remove(d);
                atualizarDataAtualizacao();
            }
        }
    }

    public void atualizarDataAtualizacao(){
        this.dataAtualizacao = LocalDate.now();
    }

    public float calcularRentabilidade(){
        float rentabilidade = 0;
        if(ativo instanceof RendaFixa){
            for(Transacao t: transacoes){
                Period periodo = Period.between(LocalDate.now(), t.getData());
                rentabilidade += (t.getPrecoUnitario()*(periodo.getMonths()*(((RendaFixa) ativo).getTaxa())/12));
            }
        }
        else{
            rentabilidade += (precoMedio * quantidade) - ((RendaVariavel) ativo).getValorAtual();
            for(Dividendo d: dividendos){
                rentabilidade += d.getValorPago()*quantidade;
            }
        }

        return rentabilidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoMedio() {
        return precoMedio;
    }

    public void setPrecoMedio(float precoMedio) {
        this.precoMedio = precoMedio;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public LinkedList<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(LinkedList<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public LinkedList<Dividendo> getDividendos() {
        return dividendos;
    }

    public void setDividendos(LinkedList<Dividendo> dividendos) {
        this.dividendos = dividendos;
    }

}



