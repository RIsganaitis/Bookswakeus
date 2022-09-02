package codeAcademy.bookswakeus.books;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    public void update(Book book) {

        Integer index = null;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(book.getId())){
                index = i;
            }
        }
        if (index != null){
            bookList.set(index, book);
        }
    }
}
