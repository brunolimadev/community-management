package br.com.fiap.communitymanagement.controller.exception;

public class ControllerNotFoundException extends RuntimeException {

    public ControllerNotFoundException(String messga) {
        super(messga);
    }
}
