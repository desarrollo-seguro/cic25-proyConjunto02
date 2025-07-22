package es.cic.curso25.cic25_proyConjunto02.controller;

public class CreacionSecurityException extends RuntimeException{

    public CreacionSecurityException() {
        super("Intento de creación en el update");
    }

    public CreacionSecurityException(String mensaje) {
        super(mensaje);
    }

    public CreacionSecurityException (String mensaje, Throwable throwable) {
        super(mensaje, throwable);
    }
}
