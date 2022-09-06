package codeAcademy.bookswakeus.books;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RequestMapping("/books")
@Controller
public class BooksController {

    private final BooksService booksService;

    @GetMapping
    public String getBooks(Model model) {
        List<Book> books = booksService.getBooks();
        model.addAttribute("books", books);
        return "books";
    }


    @GetMapping("/create")
    public String openBookForm(Model model){

        model.addAttribute("book", new Book());
        return "bookForm";
    }

    @PostMapping("/create")
    public String createBook(Book book, Model model){
        booksService.createBook(book);
        model.addAttribute("books", booksService.getBooks());
        String message = "Book '" + book.getTitle() + "' successfully created";
        model.addAttribute("message", message);
        return "books";
    }


    @GetMapping("/{id}")
    public String openBook(@PathVariable UUID id, Model model) {

        model.addAttribute("book", booksService.getBook(id));

        return "bookForm";
    }

    @PostMapping("/{id}")
    public String updateBook(Book book, Model model){

        booksService.updateBook(book);
        String message = "Book '" + book.getTitle() + "' successfully updated";
        model.addAttribute("message", message);

        return getBooks(model);
    }

    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable UUID id, Model model){


        Book book = booksService.getBook(id);
        booksService.deleteBook(id);
        String message = "Book '" + book.getTitle() + "' successfully deleted";
        model.addAttribute("message", message);

        return getBooks(model);

    }

    @GetMapping("/search")
    public String searchBook(@RequestParam String input, Model model){

        List<Book> filteredBooks = booksService.findAllBooksByTitle(input);
        model.addAttribute("books", filteredBooks);

        return "books";
    }


}
