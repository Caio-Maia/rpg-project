package main.java.business.model;

public class Equipamento {

    private Integer id;
    private String nome;
    private String defesa;
    private String requisito;

    public Equipamento(Integer id, String nome, String defesa, String requisito) {
        this.id = id;
        this.nome = nome;
        this.defesa = defesa;
        this.requisito = requisito;
    }

    public Equipamento(String nome, String defesa, String requisito) {
        this.nome = nome;
        this.defesa = defesa;
        this.requisito = requisito;
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

    public String getDefesa() {
        return defesa;
    }

    public void setDefesa(String defesa) {
        this.defesa = defesa;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }
}
