package infra;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import business.model.User;


public class PersistenceManager {

    private static volatile PersistenceManager instance;
    public static Logger logger = Logger.getLogger(PersistenceManager.class.getName());

    private PersistenceManager() {

        try {

            Handler hdConsole = new ConsoleHandler();
            Handler hdArquivo = new FileHandler("relatorioLog.txt");

            hdConsole.setLevel(Level.ALL);
            hdArquivo.setLevel(Level.ALL);

            PersistenceManager.logger.addHandler(hdConsole);
            PersistenceManager.logger.addHandler(hdArquivo);

            PersistenceManager.logger.setUseParentHandlers(false);


        } catch (IOException ex) {
            logger.severe("ocorreu um erro no arquivo durante a execução do programa");
        }
    }

    public static PersistenceManager getInstance() {
        PersistenceManager result = instance;
        if(result != null) {
            return result;
        }
        synchronized (PersistenceManager.class) {
            if (instance == null) {
                instance = new PersistenceManager();
            }
            return instance;
        }
    }

    public void saveData(String fileName, Object data) throws InfraException {
        File file = new File(fileName);
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(data);
            out.close();
        } catch (FileNotFoundException ex) {
            logger.severe("Arquivo não encontrado: " + fileName);
            throw new InfraException("Erro de persistência, contate o admin ou tente mais tarde");
        } catch (IOException ex) {
            logger.severe("Erro ao salvar dados no arquivo: " + fileName);
            throw new InfraException("Erro de persistência, contate o admin ou tente mais tarde");
        }
    }

    public <T> Map<String, T> loadData(String fileName) throws InfraException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new InfraException("Arquivo não encontrado: " + fileName);
        }
        try {
            ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
            Map<String, T> data = (Map<String, T>) objInput.readObject();
            objInput.close();
            return data;
        } catch (IOException | ClassNotFoundException ex) {
            logger.severe("Erro ao carregar dados do arquivo: " + fileName);
            throw new InfraException("Erro de persistência, contate o admin ou tente mais tarde");
        }
    }
}
