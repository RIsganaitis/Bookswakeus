package codeAcademy.bookswakeus.books;

import codeAcademy.bookswakeus.books.errors.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(CustomException.class)
    public String handleCustomException(){
        return "error/customExceptionPage";
    }


//    nutriminti empty spaces
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    private final CompanyInfo companyInfo;

    @ModelAttribute("companyInfo")
    public CompanyInfo addCompanyDataModel(){
        return companyInfo;
    }

}
