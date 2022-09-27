package codeAcademy.bookswakeus.favourites;

import codeAcademy.bookswakeus.books.Book;
import codeAcademy.bookswakeus.books.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

@AllArgsConstructor
@Controller
@RequestMapping("/favourites")
@SessionAttributes("favourites")
public class FavouriresController {

    private final BooksService booksService;

    @GetMapping
    public String getFavorites(@ModelAttribute Favourites favourites, Model model){

        model.addAttribute("favourites", favourites);

        return "favourites";
    }

    @ModelAttribute("favourites")
    Favourites initFavourites() {
        return new Favourites();
    }

    @PostMapping("/{id}")
    public String addToFavourites(@ModelAttribute Favourites favourites, @PathVariable UUID id){

        favourites.add(booksService.getBook(id));

        return "redirect:/books";
    }

}
