package app.exception;

public class ReaderNotFoundException extends RuntimeException {
    public ReaderNotFoundException(Long id) {
        super(String.format("Продукт с идентификатором %d не найден", id));
    }
}
