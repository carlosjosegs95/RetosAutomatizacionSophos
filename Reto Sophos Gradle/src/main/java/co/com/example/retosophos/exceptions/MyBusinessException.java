package co.com.example.retosophos.exceptions;

/**
 * Clase que maneja las excepciones
 */

public class MyBusinessException extends RuntimeException{

    public MyBusinessException(String message) {
        super(message);
    }

}
