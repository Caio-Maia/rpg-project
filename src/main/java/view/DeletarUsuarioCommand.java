package main.java.view;

public class DeletarUsuarioCommand implements Command{

    private MainScreenDesktop mainScreen;
    private Integer id;

    public DeletarUsuarioCommand(MainScreenDesktop mainScreenDesktop, Integer id) {
        this.mainScreen = mainScreenDesktop;
        this.id = id;
    }

    @Override
    public void execute() {
        this.mainScreen.usuarioManager.deleteUsuario(id);
        this.mainScreen.deletarUsuario();
    }
}
