package app.exception;

public class BookSaveException extends RuntimeException {
    public BookSaveException(String message) {
        super(message);
    }
}
