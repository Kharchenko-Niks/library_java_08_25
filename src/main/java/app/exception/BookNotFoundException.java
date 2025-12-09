package app.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super(String.format("Книга с идентификатором %d не найден", id));
    }
}
