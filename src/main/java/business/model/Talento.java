package main.java.business.model;

public class Talento {

    private Integer id;
    private String nome;
    private String descricao;
    private Boolean temConjuracoes;
    private Integer qteConjuracoesMax;
    private Integer qteConjuracoesRest;

    public Talento(Integer id, String nome, String descricao, Boolean temConjuracoes, Integer qteConjuracoesMax, Integer qteConjuracoesRest) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.temConjuracoes = temConjuracoes;
        this.qteConjuracoesMax = qteConjuracoesMax;
        this.qteConjuracoesRest = qteConjuracoesRest;
    }

    public Talento(String nome, String descricao, Boolean temConjuracoes, Integer qteConjuracoesMax, Integer qteConjuracoesRest) {
        this.nome = nome;
        this.descricao = descricao;
        this.temConjuracoes = temConjuracoes;
        this.qteConjuracoesMax = qteConjuracoesMax;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getTemConjuracoes() {
        return temConjuracoes;
    }

    public void setTemConjuracoes(Boolean temConjuracoes) {
        this.temConjuracoes = temConjuracoes;
    }

    public Integer getQteConjuracoesMax() {
        return qteConjuracoesMax;
    }

    public void setQteConjuracoesMax(Integer qteConjuracoesMax) {
        this.qteConjuracoesMax = qteConjuracoesMax;
    }

    public Integer getQteConjuracoesRest() {
        return qteConjuracoesRest;
    }

    public void setQteConjuracoesRest(Integer qteConjuracoesRest) {
        this.qteConjuracoesRest = qteConjuracoesRest;
    }
}
