package codeAcademy.bookswakeus.books.repos;

import codeAcademy.bookswakeus.books.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BooksRepo {

    Page<Book> findAll(Pageable pageable);

    void save(Book book);

    Optional<Book> findById(UUID id);

    void delete(Book bookToRemove);

    List<Book> findByTitleContainingIgnoreCase(String title);
}
