package main.java.business.model;

import java.io.Serializable;

public class Personagem implements Serializable {
    private static final long serialVersionUID = -3409171233621036055L;

    private Integer id;
    private Integer criador;
    private String nome;
    private Integer partida;

    public Personagem(Integer criador, String nome, Integer partida) {
        this.criador = criador;
        this.nome = nome;
        this.partida = partida;
    }

    public Personagem(Integer id,Integer criador, String nome, Integer partida) {
        this.criador = criador;
        this.nome = nome;
        this.partida = partida;
        this.id = id;
    }

    public Integer getCriador() {
        return criador;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPartida() {
        return partida;
    }

    public Integer getId() {
        return id;
    }
}
