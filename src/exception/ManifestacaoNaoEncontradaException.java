package exception;

public class ManifestacaoNaoEncontradaException extends Exception {
    public ManifestacaoNaoEncontradaException() {
        super("Nenhuma manifestação encontrada :(");
    }

    public ManifestacaoNaoEncontradaException(String message) {
        super(message);
    }
}
