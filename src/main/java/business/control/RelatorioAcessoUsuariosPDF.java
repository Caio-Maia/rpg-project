package main.java.business.control;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import main.java.business.model.Usuario;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class RelatorioAcessoUsuariosPDF extends RelatorioAcessoUsuarios {

    private Document document;

    @Override
    protected void registrarCabecalho() {
        document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("relatorio.pdf"));
            document.open();

            document.add(new Paragraph("Relatório de Acesso dos Usuários"));

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String timestamp = now.format(formatter);
            document.add(new Paragraph("Data e Hora de Geração do Relatório: " + timestamp));

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void registrarDados(Map<Integer, Usuario> usuarios, Map<Integer, Integer> acessos) {
        try {
            document.add(new Paragraph("Usuários e Número de Acessos:"));

            for (Map.Entry<Integer, Integer> entry : acessos.entrySet()) {
                int usuarioId = entry.getKey();
                int numeroAcessos = entry.getValue();
                Usuario usuario = usuarios.get(usuarioId);
                if (usuario != null) {
                    document.add(new Paragraph("Usuário: " + usuario.getLogin() + ", Número de Acessos: " + numeroAcessos));
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void registrarRodape() {
        document.close();
    }
}