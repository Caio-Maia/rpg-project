package business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Partida implements Serializable {
    private static final long serialVersionUID = -3409171233621036055L;

    private String nome;
    private User mestre;
    private List<Personagem> personagens;

    public Partida(String nome, User criador) {
        this.nome = nome;
        this.mestre = criador;
        this.personagens = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public User getMestre() {
        return mestre;
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }

    public void adicionarPersonagem(User criador, String nome) {
        if (criador != this.mestre && personagens.size() > 0) {
            System.out.println("Você já adicionou um personagem nesta partida.");
        }
        Personagem personagem = new Personagem(criador, nome, this);
        personagens.add(personagem);
    }
}
