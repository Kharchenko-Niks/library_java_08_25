package app.controller;

import app.domain.Reader;
import app.service.ReaderService;

import java.util.List;

public class ReaderController {
    private final ReaderService service = new ReaderService();

    // Сохранить читателя
    public Reader save(String name){
        Reader reader = new Reader(name);
        return service.save(reader);
    }
    //Вернуть всех читателей
    public List<Reader> getAll(){
        return service.getAllActiveReaders();
    }

    // Вернуть читателя по ID
    public void getById(String id){
        Long numId = Long.parseLong(id);
        service.getActiveReaderById(numId);

    }

    // Удалить читателя по ID
    public void deleteById (String id){
        Long numId = Long.parseLong(id);
        service.deleteById(numId);
    }

}
