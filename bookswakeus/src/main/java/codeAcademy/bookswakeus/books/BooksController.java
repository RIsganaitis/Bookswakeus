package codeAcademy.bookswakeus.books;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.emptyList;

@Controller
public class BooksController {

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", emptyList());

        return "books";
    }
}
