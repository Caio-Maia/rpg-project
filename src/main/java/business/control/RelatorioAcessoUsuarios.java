package main.java.business.control;

import main.java.business.model.Usuario;

import java.util.Map;

public abstract class RelatorioAcessoUsuarios {

    public void gerarRelatorio(Map<Integer, Usuario> usuarios, Map<Integer, Integer> acessos) {
        registrarCabecalho();
        registrarDados(usuarios, acessos);
        registrarRodape();
    }

    protected abstract void registrarCabecalho();

    protected abstract void registrarDados(Map<Integer, Usuario> usuarios, Map<Integer, Integer> acessos);

    protected abstract void registrarRodape();
}
