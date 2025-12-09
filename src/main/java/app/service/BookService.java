package app.service;

import app.domain.Book;
import app.exception.BookNotFoundException;
import app.exception.BookSaveException;
import app.repository.BookRepository;

import java.util.List;

public class BookService {
    private static  BookService instance;

    private final BookRepository repository = new BookRepository();

    private BookService(){

    }

    public static BookService getInstance(){
        if (instance == null){
            instance = new BookService();
        }
        return instance;
    }

    // Сохр книги
    public Book save(Book book){
        if (book == null){
            throw new BookSaveException("Книга не может быть null");
        }
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()){
            throw new BookSaveException("Название книги не должно быть пустым");
        }
        if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()){
            throw new BookSaveException("Автор книги не должен быть пустым");
        }
        book.setActive(true);
        return repository.save(book);
    }

    // Вернуть все книги
    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    // Вернуть книгу по ID

    public Book getBookById (Long id){
        Book book = repository.findById(id);
        if (book == null){
            throw new BookNotFoundException(id);
        }
        return book;
    }

    // Удалить книгу по ID
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    // Количество книг
    public int getBooksCount (){
        return repository.findAll().size();
    }

    public void deleteByTitles(String title){
        getAllBooks()
                .stream()
                .filter(b -> b.getTitle().equals(title))
                .forEach(b -> b.setActive(false));

    }
    public void restoreById(Long id){
        Book book = repository.findById(id);
        if (book != null){
            book.setActive(true);
        }else{
            throw new RuntimeException("Книга с id " + id + " не найдена");
        }
    }

}
