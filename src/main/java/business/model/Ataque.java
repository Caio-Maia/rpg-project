package main.java.business.model;

import main.java.business.model.enums.TipoAtaque;

public class Ataque {

    private Integer id;
    private String nome;
    private String distancia;
    private TipoAtaque tipoAtaque;
    private TipoAtaque contraAtaque;
    private Integer dadiPerd;
    private String dano;
    private String critico;
    private String descricao;

    public Ataque() {}

    public Ataque(Integer id, String nome, String distancia, TipoAtaque tipoAtaque, TipoAtaque contraAtaque, Integer dadiPerd, String dano, String critico, String descricao) {
        this.id = id;
        this.nome = nome;
        this.distancia = distancia;
        this.tipoAtaque = tipoAtaque;
        this.contraAtaque = contraAtaque;
        this.dadiPerd = dadiPerd;
        this.dano = dano;
        this.critico = critico;
        this.descricao = descricao;
    }

    public Ataque(String nome, String distancia, TipoAtaque tipoAtaque, TipoAtaque contraAtaque, Integer dadiPerd, String dano, String critico, String descricao) {
        this.nome = nome;
        this.distancia = distancia;
        this.tipoAtaque = tipoAtaque;
        this.contraAtaque = contraAtaque;
        this.dadiPerd = dadiPerd;
        this.dano = dano;
        this.critico = critico;
        this.descricao = descricao;
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

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
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

    public Integer getDadiPerd() {
        return dadiPerd;
    }

    public void setDadiPerd(Integer dadiPerd) {
        this.dadiPerd = dadiPerd;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
