package codeAcademy.bookswakeus.books.repos;

import codeAcademy.bookswakeus.books.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class MockedBooksRepo {


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

        Integer index = getIndex(book.getId());
        if (index != null){
            bookList.set(index, book);
        }
    }

    public void delete(UUID id) {

        Integer index = getIndex(id);
        if (index != null){
            bookList.remove(index.intValue());
        }

    }

    private Integer getIndex(UUID id) {

        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(id)){
                return i;
            }
        }
        return null;
    }



}
