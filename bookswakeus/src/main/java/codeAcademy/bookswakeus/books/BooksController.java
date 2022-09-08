package codeAcademy.bookswakeus.books;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RequestMapping("/books")
@Controller
public class BooksController {

    private final BooksService booksService;

    @GetMapping
    public String getBooks(Pageable pageable, Model model) {
        Page<Book> books = booksService.getBooks(pageable);
        model.addAttribute("books", books);
        return "books";
    }


    @GetMapping("/create")
    public String openBookForm(Model model){

        model.addAttribute("book", new Book());
        return "bookForm";
    }

    @PostMapping("/create")
    public String createBook(Book book, RedirectAttributes redirectAttributes){
        booksService.createBook(book);
        String message = "Book '" + book.getTitle() + "' successfully created";
        redirectAttributes.addFlashAttribute("message", message);
//        redirectAttributes.addAttribute("message", message);


        return "redirect:/books";
    }


    @GetMapping("/{id}")
    public String openBook(@PathVariable UUID id, Model model) {

        model.addAttribute("book", booksService.getBook(id));

        return "bookForm";
    }

    @PostMapping("/{id}")
    public String updateBook(Book book, RedirectAttributes redirectAttributes){

        booksService.updateBook(book);
        String message = "Book '" + book.getTitle() + "' successfully updated";
        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/books";
    }

    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable UUID id, RedirectAttributes redirectAttributes){

        Book book = booksService.getBook(id);
        booksService.deleteBook(id);
        String message = "Book '" + book.getTitle() + "' successfully deleted";
        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/books";

    }

    @GetMapping("/search")
    public String searchBook(@RequestParam String input, Model model){

        List<Book> filteredBooks = booksService.findAllBooksByTitle(input);
        model.addAttribute("books", filteredBooks);

        return "books";
    }


}
