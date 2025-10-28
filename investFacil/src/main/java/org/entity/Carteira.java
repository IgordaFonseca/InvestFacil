package org.entity;

import java.time.LocalDate;
import java.util.LinkedList;

public class Carteira {
    private int id;
    private String nome;
    private LocalDate dataCriacao;
    private LinkedList<Posicao> posicoes;

    public Carteira(int id, String nome, LocalDate dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.posicoes = new LinkedList<>();
    }

    public void alterarNome(String nome){
        this.setNome(nome);
    }

    public void adicionarPosicao(Posicao posicao){
        posicoes.add(posicao);
    }

    public void removerPosicao(Posicao posicao){
        posicoes.remove(posicao);
    }

    public void removerPosicao(int idPosicao){
        for(Posicao p: posicoes){
            if(p.getId()== idPosicao){
                posicoes.remove(p);
            }
        }
    }


    @Override
    public String toString() {
        return "Carteira{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LinkedList<Posicao> getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(LinkedList<Posicao> posicoes) {
        this.posicoes = posicoes;
    }
}

