package business.model;

import java.io.Serializable;

public class Personagem implements Serializable {
    private static final long serialVersionUID = -3409171233621036055L;

    private Usuario criador;
    private String nome;
    private Partida partida;

    public Personagem(Usuario criador, String nome, Partida partida) {
        this.criador = criador;
        this.nome = nome;
        this.partida = partida;
    }

    public Usuario getCriador() {
        return criador;
    }

    public String getNome() {
        return nome;
    }

    public Partida getPartida() {
        return partida;
    }
}
