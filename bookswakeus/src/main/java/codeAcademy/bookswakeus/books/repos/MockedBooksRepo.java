package codeAcademy.bookswakeus.books.repos;

import codeAcademy.bookswakeus.books.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Repository
@Profile("mocked-db")
public class MockedBooksRepo implements  BooksRepo{


    private final List<Book> bookList = new ArrayList<>();

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return new PageImpl<>(bookList, pageable, bookList.size());
    }

    public void save(Book book) {

        Optional<Book> bookOptional = findById(book.getId());

        if (bookOptional.isPresent()){
            update(book);
        } else {
            createNewBook(book);
        }
    }

    private void createNewBook(Book book) {
        bookList.add(book);
    }

    @Override
    public Optional<Book> findById(UUID id) {
        return bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
    }

    @Override
    public void delete(Book bookToRemove) {
        getIndex(bookToRemove.getId()).
                ifPresent(index -> bookList.remove(index.intValue()));
    }

    @Override
    public List<Book> findByTitleContainingIgnoreCase(String title) {

        bookList.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .collect(toList());
        return null;
    }

    private void update(Book book) {
        getIndex(book.getId())
                .ifPresent(index -> bookList.set(index, book));
    }

    private Optional<Integer> getIndex(UUID id) {

        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(id)){
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }



}
