package codeAcademy.bookswakeus.books;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class BooksService {

    private final BooksRepo booksRepo;

    public List<Book> getBooks() {

        return booksRepo.getAll();
    }

    public void createBook(Book book) {

        UUID bookId = UUID.randomUUID();
        book.setId(bookId);

        booksRepo.save(book);
    }

    public Book getBook(UUID id) {

        return booksRepo.getById(id);
    }

    public void updateBook(Book book) {
        booksRepo.update(book);
    }

    public void deleteBook(UUID id) {
        booksRepo.delete(id);
    }
}
