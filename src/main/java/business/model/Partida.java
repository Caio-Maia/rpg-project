package main.java.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Partida implements Serializable {
    private static final long serialVersionUID = -3409171233621036055L;

    private Integer id;
    private String nome;
    private Integer mestre;
    private List<Personagem> personagens;

    public Partida(String nome, Integer criador) {
        this.nome = nome;
        this.mestre = criador;
        this.personagens = new ArrayList<>();
    }

    public Partida(Integer id, String nome, Integer criador) {
        this.nome = nome;
        this.mestre = criador;
        this.personagens = new ArrayList<>();
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public Integer getMestre() {
        return mestre;
    }

    public Integer getId() {
        return id;
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }

    public void adicionarPersonagem(Integer criador, String nome) {
        if (criador != this.mestre && personagens.size() > 0) {
            System.out.println("Você já adicionou um personagem nesta partida.");
        }
        Personagem personagem = new Personagem(criador, nome, this.id);
        personagens.add(personagem);
    }
}
