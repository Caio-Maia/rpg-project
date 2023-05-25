package main.java.view;

public class GerarRelatorioHtmlCommand implements Command{
    private MainScreenDesktop mainScreenDesktop;

    public GerarRelatorioHtmlCommand(MainScreenDesktop mainScreenDesktop) {
        this.mainScreenDesktop = mainScreenDesktop;
    }

    @Override
    public void execute() {
        this.mainScreenDesktop.loginManager.gerarRelatorioHtml();
        this.mainScreenDesktop.gerarRelatorio();
    }
}
