package codeAcademy.bookswakeus.helloworld;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Task {

    @GetMapping("/task/{pathWar}")
    public String task(@PathVariable String pathWar, @RequestParam String reqPar){
//        System.out.println(pathWar + reqPar);
        return "task";
    }
}
