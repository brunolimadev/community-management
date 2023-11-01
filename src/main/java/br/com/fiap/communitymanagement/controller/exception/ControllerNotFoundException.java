package br.com.fiap.communitymanagement.controller.exception;

public class ControllerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ControllerNotFoundException(String messga) {
        super(messga);
    }
}
