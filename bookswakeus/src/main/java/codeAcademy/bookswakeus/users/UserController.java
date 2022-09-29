package codeAcademy.bookswakeus.users;


import codeAcademy.bookswakeus.books.Book;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@AllArgsConstructor
@Controller
@RequestMapping("/public/signup")
public class UserController {

    @GetMapping
    public String getUserForm(Model model){
        model.addAttribute("user", new User());
        return "signupform";
    }

    @PostMapping
    public String createUser(@Valid User user, BindingResult errors, RedirectAttributes redirectAttributes){

        if(errors.hasErrors()){
            return "signUpForm";
        }

        redirectAttributes.addFlashAttribute("Success");
        return "redirect:/public/books";
    }

}
