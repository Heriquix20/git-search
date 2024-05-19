package br.com.hcgv.gitsearch;

public class usuarioNaoEncontradoException extends Exception {

    private String message;

    public usuarioNaoEncontradoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
