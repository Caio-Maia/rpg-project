package main.java.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Partida implements Serializable {
    private static final long serialVersionUID = -3409171233621036055L;

    private Integer id;
    private String nome;
    private Integer mestre;

    public Partida() {}

    public Partida(String nome, Integer criador) {
        this.nome = nome;
        this.mestre = criador;
    }

    public Partida(Integer id, String nome, Integer criador) {
        this.nome = nome;
        this.mestre = criador;
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
}
