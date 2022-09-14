package codeAcademy.bookswakeus.books.errors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("makeerror")
public class FoultyController {

    @GetMapping
    public String makeError(){
        throw new CustomException();
    }

    @ExceptionHandler(CustomException.class)
    public String handleCustomException(){
        return "error/customExceptionPage";
    }
}
