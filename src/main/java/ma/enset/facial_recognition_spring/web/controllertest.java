package ma.enset.facial_recognition_spring.web;

import lombok.AllArgsConstructor;
import ma.enset.facial_recognition_spring.entities.DateStudent;
import ma.enset.facial_recognition_spring.entities.PresentAndAbsent;
import ma.enset.facial_recognition_spring.entities.Student;
import ma.enset.facial_recognition_spring.service.FacialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Controller
@AllArgsConstructor
public class controllertest {
    FacialService facialService;


    @GetMapping("/form")

    public String getpage(Model model ,
                          @RequestParam(name = "d", defaultValue = "2022-05-20") String d,
                          @RequestParam(name = "t1", defaultValue = "21:30:20") String t1,
                          @RequestParam(name = "t2", defaultValue = "22:46:20") String t2,
                          @RequestParam(name = "aff", defaultValue = "") String aff) throws ParseException {
        List<PresentAndAbsent> presentAndAbsentList = facialService.getPresentsAndAbsent(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d+" "+t1+":00"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d+" "+t2+":00"));
        List<Student> absents = facialService.getAllAbsentStudent(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d+" "+t1+":00"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d+" "+t2+":00"));
        List<DateStudent> presents = facialService.getAllPresents(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d+" "+t1+":00"), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d+" "+t2+":00"));
        String aff1 = aff;
        String date = "Absence du "+d;
        String time = "De "+t1+" à "+t2;
        model.addAttribute("presentAndAbsents",presentAndAbsentList);
        model.addAttribute("absents",absents);
        model.addAttribute("presents",presents);
        model.addAttribute("aff",aff1);
        model.addAttribute("time",time);
        model.addAttribute("date1",date);
        return "pp";
    }
  /*  @GetMapping("form")
    public String getform(){

        return "form";
    }*/
}
