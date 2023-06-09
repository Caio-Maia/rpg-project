package main.java.business.model;

import main.java.business.model.enums.Atributo;

public class Status {
    private Integer id;
    private Atributo atributo;
    private String valor;
    private Boolean temModificador;

    public Status() {}

    public Status(Integer id, Atributo atributo, String valor, Boolean temModificador) {
        this.id = id;
        this.atributo = atributo;
        this.valor = valor;
        this.temModificador = temModificador;
    }

    public Status(Atributo atributo, String valor, Boolean temModificador) {
        this.atributo = atributo;
        this.valor = valor;
        this.temModificador = temModificador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Boolean getTemModificador() {
        return temModificador;
    }

    public void setTemModificador(Boolean temModificador) {
        this.temModificador = temModificador;
    }
}
