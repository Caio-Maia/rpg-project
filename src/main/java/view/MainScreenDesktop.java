package main.java.view;

import main.java.business.control.*;
import main.java.view.screenStates.LoginScreenState;
import main.java.view.screenStates.ScreenState;

public class MainScreenDesktop {

    private static MainScreenDesktop instance;
    private ArmaManager armaManager;
    private AtaqueManager ataqueManager;
    private EquipamentoManager equipamentoManager;
    private ItemManager itemManager;
    private MagiaManager magiaManager;
    private PartidaManager partidaManager;
    private PersonagemManager personagemManager;
    private StatusManager statusManager;
    private TalentoManager talentoManager;
    private UsuarioManager usuarioManager;
    private LoginManager loginManager;

    private ScreenState screenState;

    public static void main(String[] args) {
        MainScreenDesktop.getInstance();
    }

    private MainScreenDesktop() {
        armaManager = ArmaManager.getInstance();
        ataqueManager = AtaqueManager.getInstance();
        equipamentoManager = EquipamentoManager.getInstance();
        itemManager = ItemManager.getInstance();
        magiaManager = MagiaManager.getInstance();
        partidaManager = PartidaManager.getInstance();
        personagemManager = PersonagemManager.getInstance();
        statusManager = StatusManager.getInstance();
        talentoManager = TalentoManager.getInstance();
        usuarioManager = UsuarioManager.getInstance();
        loginManager = LoginManager.getInstance();
        setScreenState(new LoginScreenState());
    }

    public static MainScreenDesktop getInstance() {
        if (instance == null) {
            instance = new MainScreenDesktop();
        }
        return instance;
    }

    public void setScreenState(ScreenState screenState) {
        if (this.screenState != null) {
            this.screenState.fechaTela();
        }

        this.screenState = screenState;
        screenState.handleTela(this);
    }

    public ArmaManager getArmaManager() {
        return armaManager;
    }

    public AtaqueManager getAtaqueManager() {
        return ataqueManager;
    }

    public EquipamentoManager getEquipamentoManager() {
        return equipamentoManager;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public MagiaManager getMagiaManager() {
        return magiaManager;
    }

    public PartidaManager getPartidaManager() {
        return partidaManager;
    }

    public PersonagemManager getPersonagemManager() {
        return personagemManager;
    }

    public StatusManager getStatusManager() {
        return statusManager;
    }

    public TalentoManager getTalentoManager() {
        return talentoManager;
    }

    public UsuarioManager getUsuarioManager() {
        return usuarioManager;
    }

    public LoginManager getLoginManager() {
        return loginManager;
    }
}
