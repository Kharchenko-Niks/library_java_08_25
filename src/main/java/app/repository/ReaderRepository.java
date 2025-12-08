package app.repository;

import app.domain.Book;
import app.domain.Reader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReaderRepository {

    // Список для хранения всех читателей
    private final List<Reader> database = new ArrayList<>();
    private long maxId;

    // Сохр нового читателя
    public Reader save(Reader reader){
        reader.setId(++maxId);
        database.add(reader);
        return reader;
    }

    // Вернуть всех читателей
    public List<Reader> findAll(){
        return database;
    }

    // Найти читателя по id
    public Reader findById(Long id){
        for (Reader reader : database){
            if (reader.getId().equals(id)){
                return reader;
            }
        }
        return null;
    }

    // "Удалить" читателя (делаем его неактивным)
    public void deleteById(Long id){
        Iterator<Reader> iterator = database.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getId().equals(id)){
                iterator.remove(); // полностью удаляем объект
                break;
            }
        }
    }
}
