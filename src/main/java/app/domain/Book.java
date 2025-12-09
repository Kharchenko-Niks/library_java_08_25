package app.domain;

import java.util.Objects;

public class Book {
    private Long id;
    private String title;
    private String author;
    private boolean active = true;

    public Book( String title, String author) {
        this.title = title;
        this.author = author;
    }



    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format(
                "Book: id - %d, title - %s, author - %s, active - %s",
                id,
                title,
                author,
                active ? "yes" : "no"

        );
    }
}
