package codeAcademy.bookswakeus.books;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.emptyList;

@RequestMapping("/books")
@Controller
public class BooksController {

    @GetMapping
    public String getBooks(Model model) {
        model.addAttribute("books", Arrays.asList(new Book("book1", "author1",
                "description", new BigDecimal("1.5"))));

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
