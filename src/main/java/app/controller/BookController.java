package app.controller;

import app.domain.Book;
import app.service.BookService;

import java.util.List;

public class BookController {
    private final BookService service = BookService.getInstance();

    // Сохранить книгу
    public Book save(String title, String author){
        Book book = new Book(title, author);
        return service.save(book);
    }

    //Вернуть все книги
    public List<Book> getALL(){
        return service.getAllBooks();
    }

    //Вернуть книгу по ID
    public Book getById(String id){
        Long numId = Long.parseLong(id);
        return service.getBookById(numId);
    }

    // Удалить книгу по ID
    public void deleteById(String id){
        Long numId = Long.parseLong(id);
        service.deleteById(numId);
    }

    // Удалить книгу по названию
    public void deleteByTitles(String title){
        service.deleteByTitles(title);
    }

    // Восстановить удалённую книгу по ID
    public void restoreById(String id){
        Long numId = Long.parseLong(id);
        service.restoreById(numId);
    }

    // Вернуть общее количество активных книг
    public int getBooksCount(){
        return service.getBooksCount();
    }
}
