package codeAcademy.bookswakeus.books;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        return getBooks(model);
    }


}
