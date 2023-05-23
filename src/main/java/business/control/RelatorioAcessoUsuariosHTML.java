package main.java.business.control;

import main.java.business.model.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class RelatorioAcessoUsuariosHTML extends RelatorioAcessoUsuarios {

    PrintWriter writer;

    @Override
    protected void registrarCabecalho() {
        try {
            writer = new PrintWriter(new FileWriter("relatorio.html"));
            writer.println("<html><head><title>Relatório de Acesso dos Usuários</title></head><meta charset=\"utf-8\"><body>");
            writer.println("<h1>Relatório de Acesso dos Usuários</h1>");

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String timestamp = now.format(formatter);
            writer.println("<p>Data e Hora de Geração do Relatório: " + timestamp + "</p>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void registrarDados(Map<Integer, Usuario> usuarios, Map<Integer, Integer> acessos) {
        writer.println("<table>");
        writer.println("<tr><th>Usuário</th><th>Número de Acessos</th></tr>");
        for (Map.Entry<Integer, Integer> entry : acessos.entrySet()) {
            int usuarioId = entry.getKey();
            int numeroAcessos = entry.getValue();
            Usuario usuario = usuarios.get(usuarioId);
            if (usuario != null) {
                writer.println("<tr><td>" + usuario.getLogin() +"</td>" + "<td>" + numeroAcessos+"</td></tr>");
            }
        }
        writer.println("</table>");
    }

    @Override
    protected void registrarRodape() {
        writer.println("</body></html>");
        writer.close();
    }
}