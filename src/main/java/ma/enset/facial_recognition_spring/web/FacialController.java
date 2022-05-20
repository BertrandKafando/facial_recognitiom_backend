package ma.enset.facial_recognition_spring.web;

import lombok.AllArgsConstructor;
import ma.enset.facial_recognition_spring.entities.Student;
import ma.enset.facial_recognition_spring.service.FacialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.rmi.CORBA.Stub;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@AllArgsConstructor
public class FacialController {
    FacialService facialService;
    @GetMapping("/absents")
    List<Student>getAbsents(@RequestParam(name = "t1") String t1,
                            @RequestParam(name = "t2") String t2) throws ParseException {

   List<Student>  absents=   facialService.getAllAbsentStudent( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t1), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t2));
       return  absents;
    }

    @GetMapping("/presents")
    List<Student>getpresents(@RequestParam(name = "t1") String t1,
                            @RequestParam(name = "t2") String t2) throws ParseException {
        List<Student>  presents=   facialService.getAllPresents( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t1), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t2));
        return  presents;
    }
}
