package main.java.business.model;

import main.java.business.model.enums.Atributo;

public class Arma {

    private Integer id;
    private String nome;
    private String requisito;
    private Atributo atributo;
    private String dano;
    private String propriedades;

    public Arma() {}

    public Arma(Integer id, String nome, String requisito, Atributo atributo, String dano, String propriedades) {
        this.id = id;
        this.nome = nome;
        this.requisito = requisito;
        this.atributo = atributo;
        this.dano = dano;
        this.propriedades = propriedades;
    }

    public Arma(String nome, String requisito, Atributo atributo, String dano, String propriedades) {
        this.nome = nome;
        this.requisito = requisito;
        this.atributo = atributo;
        this.dano = dano;
        this.propriedades = propriedades;
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

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
    }

    public String getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(String propriedades) {
        this.propriedades = propriedades;
    }
}
