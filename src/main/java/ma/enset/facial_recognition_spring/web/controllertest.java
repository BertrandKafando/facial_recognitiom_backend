package ma.enset.facial_recognition_spring.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@AllArgsConstructor
public class controllertest {
    @GetMapping("/home")
    public String gethome(){
        return "home1";
    }
}
