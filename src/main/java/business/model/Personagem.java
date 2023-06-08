package main.java.business.model;

import java.io.Serializable;
import java.util.List;

public class Personagem implements Serializable {
    private static final long serialVersionUID = -3409171233621036055L;

    private Integer id;
    private Integer criador;
    private String nome;
    private Integer partida;
    private String ancestralidade;
    private String classe;
    private String dinheiro;
    private List<Integer> statusesId;
    private List<Integer> equipamentosId;
    private List<Integer> itensId;
    private List<Integer> talentosId;

    public Personagem(Integer criador, String nome, Integer partida, String ancestralidade, String classe, String dinheiro, List<Integer> statusesId, List<Integer> equipamentosId, List<Integer> itensId, List<Integer> talentosId) {
        this.criador = criador;
        this.nome = nome;
        this.partida = partida;
        this.ancestralidade = ancestralidade;
        this.classe = classe;
        this.dinheiro = dinheiro;
        this.statusesId = statusesId;
        this.equipamentosId = equipamentosId;
        this.itensId = itensId;
        this.talentosId = talentosId;
    }

    public Personagem(Integer id, Integer criador, String nome, Integer partida, String ancestralidade, String classe, String dinheiro, List<Integer> statusesId, List<Integer> equipamentosId, List<Integer> itensId, List<Integer> talentosId) {
        this.id = id;
        this.criador = criador;
        this.nome = nome;
        this.partida = partida;
        this.ancestralidade = ancestralidade;
        this.classe = classe;
        this.dinheiro = dinheiro;
        this.statusesId = statusesId;
        this.equipamentosId = equipamentosId;
        this.itensId = itensId;
        this.talentosId = talentosId;
    }

    public Integer getCriador() {
        return criador;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPartida() {
        return partida;
    }

    public Integer getId() {
        return id;
    }

    public String getAncestralidade() {
        return ancestralidade;
    }

    public void setAncestralidade(String ancestralidade) {
        this.ancestralidade = ancestralidade;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(String dinheiro) {
        this.dinheiro = dinheiro;
    }

    public List<Integer> getStatusesId() {
        return statusesId;
    }

    public void setStatusesId(List<Integer> statusesId) {
        this.statusesId = statusesId;
    }

    public List<Integer> getEquipamentosId() {
        return equipamentosId;
    }

    public void setEquipamentosId(List<Integer> equipamentosId) {
        this.equipamentosId = equipamentosId;
    }

    public List<Integer> getItensId() {
        return itensId;
    }

    public void setItensId(List<Integer> itensId) {
        this.itensId = itensId;
    }

    public List<Integer> getTalentosId() {
        return talentosId;
    }

    public void setTalentosId(List<Integer> talentosId) {
        this.talentosId = talentosId;
    }
}
