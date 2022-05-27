package ma.enset.facial_recognition_spring.trucAjax;

import lombok.AllArgsConstructor;
import ma.enset.facial_recognition_spring.entities.PresentAndAbsent;
import ma.enset.facial_recognition_spring.entities.Student;
import ma.enset.facial_recognition_spring.repositories.StudentRepository;
import ma.enset.facial_recognition_spring.service.FacialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
public class ControllerPrincipal {
    //FacialService facialService;
    //StudentRepository studentRepository;
    @GetMapping(path = "/principal")
    public String getPincipal(){
        return "principal";
    }

   /* @RequestMapping("")
    public String loadContent() {
        return "website";
    }

    @RequestMapping("content1")
    public String getContent1() {
        return "content :: content1";
    }

    @RequestMapping("content2")
    public String getContent2() {
        return "content :: content2";
    }*/
    /*List<Student> presentAndAbsents() throws ParseException {
        //List<PresentAndAbsent> presentAndAbsentList = facialService.getPresentsAndAbsent(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t1), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t2));
        return studentRepository.findAll();

    }*/
}
