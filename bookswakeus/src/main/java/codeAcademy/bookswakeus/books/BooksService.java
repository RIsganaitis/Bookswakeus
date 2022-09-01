package codeAcademy.bookswakeus.books;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BooksService {

    private final BooksRepo booksRepo;

    public List<Book> getBooks() {

        return booksRepo.getBooks();
    }
}
