package model;

public class UsuarioNaoExisteException extends Exception {

    public UsuarioNaoExisteException() {
    }

    public UsuarioNaoExisteException(String message) {
        super(message);
    }

}
