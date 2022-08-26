package codeAcademy.bookswakeus.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/hello/{pathWariable}")
    public String hello(@PathVariable int pathWariable, @RequestParam int requestParam){
        System.out.println("pathWariable: " + pathWariable);
        System.out.println("requestParam: " + requestParam);
        System.out.println(pathWariable + requestParam);
        return "hello";
    }
}
