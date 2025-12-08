package app.repository;

import app.domain.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookRepository {
    private final List<Book> database = new ArrayList<>();
    private long maxId; // последний использованный id

    // Сохранить новую книгу
    public Book save(Book book){
        book.setId(++maxId); // присвоить уникальный id
        database.add(book);  // добавить в список
        return book;
    }

    // Вернуть все книги
    public List<Book> findAll(){
        return database;
    }

    // Найти книгу по id
    public Book findById(Long id){
        for (Book book : database){
            if (book.getId().equals(id)){
                return book;
            }
        }
        return null;
    }

    // "Удалить" книгу (делаем её неактивной)
    public void deleteById(Long id){
        Iterator<Book> iterator = database.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getId().equals(id)){
                iterator.remove();
                break;
            }
        }
    }

}
