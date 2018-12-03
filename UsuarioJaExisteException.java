package model;

public class UsuarioJaExisteException extends Exception {

    public UsuarioJaExisteException() {
    }

    public UsuarioJaExisteException(String msg) {
        super(msg);
    }

}
