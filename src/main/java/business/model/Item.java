package main.java.business.model;

public class Item {

    private Integer id;
    private String nome;
    private String descricao;
    private Boolean temUsos;
    private Integer quantidadeUsos;
    private Integer quantidade;

    public Item() {}

    public Item(Integer id, String nome, String descricao, Boolean temUsos, Integer quantidadeUsos, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.temUsos = temUsos;
        this.quantidadeUsos = quantidadeUsos;
        this.quantidade = quantidade;
    }

    public Item(String nome, String descricao, Boolean temUsos, Integer quantidadeUsos, Integer quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.temUsos = temUsos;
        this.quantidadeUsos = quantidadeUsos;
        this.quantidade = quantidade;
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

    public Boolean getTemUsos() {
        return temUsos;
    }

    public void setTemUsos(Boolean temUsos) {
        this.temUsos = temUsos;
    }

    public Integer getQuantidadeUsos() {
        return quantidadeUsos;
    }

    public void setQuantidadeUsos(Integer quantidadeUsos) {
        this.quantidadeUsos = quantidadeUsos;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
