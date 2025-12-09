package app.service;

import app.domain.Reader;
import app.exception.ReaderNotFoundException;
import app.exception.ReaderSaveException;
import app.repository.ReaderRepository;

import java.util.List;

public class ReaderService {
    private final ReaderRepository repository = new ReaderRepository();

    //сохранить читателя
    public Reader save(Reader reader){
        if (reader == null){
            throw new ReaderSaveException("Покупатель не может быть null");
        }
        String name = reader.getName();
        if (name == null || name.trim().isEmpty()){
            throw new ReaderSaveException("Имя покупателя не должно быть пустым");
        }

        reader.setActive(true);
        return repository.save(reader);
    }
    // Получить всех активных читателей
    public List<Reader> getAllActiveReaders() {
        return repository.findAll()
                .stream()
                .filter(Reader::isActive)
                .toList();
    }


    // Получить одного активного читателя по ID
    public Reader getActiveReaderById(Long id) {
        Reader reader = repository.findById(id);
        if (reader == null || !reader.isActive()) {
            throw new ReaderNotFoundException(id);
        }
        return reader;
    }
    // Удалить читателя по ID (физическое удаление)
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    // Получить количество активных читателей
    public int getActiveReadersCount() {
        return getAllActiveReaders().size();
    }


}
