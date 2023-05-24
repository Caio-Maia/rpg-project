package main.java.view;

public class LogoutCommand implements Command{
    private MainScreenDesktop mainScreenDesktop;

    public LogoutCommand(MainScreenDesktop mainScreenDesktop) {
        this.mainScreenDesktop = mainScreenDesktop;
    }

    @Override
    public void execute() {
        this.mainScreenDesktop.loginManager.logout();
        this.mainScreenDesktop.realizarLogout();
    }
}
