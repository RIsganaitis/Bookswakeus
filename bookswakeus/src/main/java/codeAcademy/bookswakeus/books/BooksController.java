package codeAcademy.bookswakeus.books;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

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
    public String openBookForm(){

        return "bookForm";
    }

    @PostMapping("/create")
    public String createBook(Book book, Model model){
        model.addAttribute("books", Arrays.asList(book));

        return "books";
    }


}
