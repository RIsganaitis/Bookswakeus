package codeAcademy.bookswakeus.books.repos;

import codeAcademy.bookswakeus.books.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

@Profile("!mocked-db")
public interface JpaBooksRepos extends JpaRepository<Book, UUID>, BooksRepo{
    List<Book> findByTitleContainingIgnoreCase(String title);
}
