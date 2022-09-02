package codeAcademy.bookswakeus.books;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Repository
public class BooksRepo {


    private final List<Book> bookList = new ArrayList<>();

    public List<Book> getAll(){
        return bookList;
    }


    public void save(Book book) {
        bookList.add(book);
    }

    public Book getById(UUID id) {

        return bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
