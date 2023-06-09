package main.java.view.screenStates;

import main.java.view.MainScreenDesktop;

public interface ScreenState {
    void handleTela (MainScreenDesktop screen);
    void fechaTela();
}
