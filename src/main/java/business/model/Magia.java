package main.java.business.model;

import main.java.business.model.enums.TipoAtaque;
import main.java.business.model.enums.TipoMagia;

public class Magia {

    private Integer id;
    private String nome;
    private String tradicao;
    private TipoMagia tipoMagia;
    private Integer nivel;
    private String alvo;
    private String dano;
    private String critico;
    private String duracao;
    private String efeito;
    private String descricao;
    private TipoAtaque tipoAtaque;
    private TipoAtaque contraAtaque;
    private Integer qteConjuracoesRest;

    public Magia(Integer id, String nome, String tradicao, TipoMagia tipoMagia, Integer nivel, String alvo, String dano, String critico, String duracao, String efeito, String descricao, TipoAtaque tipoAtaque, TipoAtaque contraAtaque, Integer qteConjuracoesRest) {
        this.id = id;
        this.nome = nome;
        this.tradicao = tradicao;
        this.tipoMagia = tipoMagia;
        this.nivel = nivel;
        this.alvo = alvo;
        this.dano = dano;
        this.critico = critico;
        this.duracao = duracao;
        this.efeito = efeito;
        this.descricao = descricao;
        this.tipoAtaque = tipoAtaque;
        this.contraAtaque = contraAtaque;
        this.qteConjuracoesRest = qteConjuracoesRest;
    }

    public Magia(String nome, String tradicao, TipoMagia tipoMagia, Integer nivel, String alvo, String dano, String critico, String duracao, String efeito, String descricao, TipoAtaque tipoAtaque, TipoAtaque contraAtaque, Integer qteConjuracoesRest) {
        this.nome = nome;
        this.tradicao = tradicao;
        this.tipoMagia = tipoMagia;
        this.nivel = nivel;
        this.alvo = alvo;
        this.dano = dano;
        this.critico = critico;
        this.duracao = duracao;
        this.efeito = efeito;
        this.descricao = descricao;
        this.tipoAtaque = tipoAtaque;
        this.contraAtaque = contraAtaque;
        this.qteConjuracoesRest = qteConjuracoesRest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTradicao() {
        return tradicao;
    }

    public void setTradicao(String tradicao) {
        this.tradicao = tradicao;
    }

    public TipoMagia getTipoMagia() {
        return tipoMagia;
    }

    public void setTipoMagia(TipoMagia tipoMagia) {
        this.tipoMagia = tipoMagia;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getAlvo() {
        return alvo;
    }

    public void setAlvo(String alvo) {
        this.alvo = alvo;
    }

    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
    }

    public String getCritico() {
        return critico;
    }

    public void setCritico(String critico) {
        this.critico = critico;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getEfeito() {
        return efeito;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoAtaque getTipoAtaque() {
        return tipoAtaque;
    }

    public void setTipoAtaque(TipoAtaque tipoAtaque) {
        this.tipoAtaque = tipoAtaque;
    }

    public TipoAtaque getContraAtaque() {
        return contraAtaque;
    }

    public void setContraAtaque(TipoAtaque contraAtaque) {
        this.contraAtaque = contraAtaque;
    }

    public Integer getQteConjuracoesRest() {
        return qteConjuracoesRest;
    }

    public void setQteConjuracoesRest(Integer qteConjuracoesRest) {
        this.qteConjuracoesRest = qteConjuracoesRest;
    }
}
