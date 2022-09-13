package codeAcademy.bookswakeus.users;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@AllArgsConstructor
@Controller
@RequestMapping("/signup")
public class UserController {

    @GetMapping
    public String getUserForm(){
        return "signupform";
    }

    @PostMapping
    public String createUser(RedirectAttributes redirectAttributes){

        redirectAttributes.addFlashAttribute("Success");
        return "redirect:/books";
    }

}
