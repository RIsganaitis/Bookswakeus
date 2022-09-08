package codeAcademy.bookswakeus.books;

import codeAcademy.bookswakeus.books.repos.JpaBooksRepos;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class BooksService {

    private final JpaBooksRepos booksRepo;

    public Page<Book> getBooks(Pageable pageable) {

        return booksRepo.findAll(pageable);
    }

    public void createBook(Book book) {

        UUID bookId = UUID.randomUUID();
        book.setId(bookId);

        booksRepo.save(book);
    }

    public Book getBook(UUID id) {

        return booksRepo.findById(id).orElse(null);
    }

    public void updateBook(Book book) {
        booksRepo.save(book);
    }

    public Book deleteBook(UUID id) {

        Book bookToRemove = getBook(id);
        booksRepo.delete(bookToRemove);
        return bookToRemove;
    }

    public List<Book> findAllBooksByTitle(String title) {
        return booksRepo.findByTitleContainingIgnoreCase(title);
    }
}
