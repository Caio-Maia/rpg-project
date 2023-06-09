package main.java.business.model;

import java.io.Serializable;


public class Usuario implements Serializable {
	private static final long serialVersionUID = -3409171233621036055L;
	
	private Integer id;
	private String login, senha;
    
    public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

    public Usuario(Integer id, String login, String senha) {
        super();
        this.login = login;
        this.senha = senha;
        this.id = id;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

  
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
  
    
    public String toString(){
        return login +"\n"+senha;
    }

	
    
}
