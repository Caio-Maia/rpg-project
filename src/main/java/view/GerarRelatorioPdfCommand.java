package main.java.view;

public class GerarRelatorioPdfCommand implements Command{
    private MainScreenDesktop mainScreenDesktop;

    public GerarRelatorioPdfCommand(MainScreenDesktop mainScreenDesktop) {
        this.mainScreenDesktop = mainScreenDesktop;
    }

    @Override
    public void execute() {
        this.mainScreenDesktop.loginManager.gerarRelatorioPDF();
        this.mainScreenDesktop.gerarRelatorio();
    }
}
