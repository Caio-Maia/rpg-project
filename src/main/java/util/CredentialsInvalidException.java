package main.java.util;

public class CredentialsInvalidException extends UserException{

    public CredentialsInvalidException(){
        super("Invalid Credentials");
    }
    public CredentialsInvalidException(String Message){
        super(Message);
    }
}
