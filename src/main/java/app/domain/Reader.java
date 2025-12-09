package app.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reader {
    private Long id;
    private String name;
    private  boolean active;

    private final List<Book> takenBooks = new ArrayList<>();

    public Reader(String name) {
        this.name = name;
    }
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(id, reader.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format(
                "Reader: id - %d, name - %s, active - %s",
                id,
                name,
                active ? "yes":"no"
        );
    }



}
