package ma.enset.facial_recognition_spring.web;

import lombok.AllArgsConstructor;
import ma.enset.facial_recognition_spring.entities.PresentAndAbsent;
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

    @GetMapping("/principal/student")
    public String getpage(Model model ,
                          @RequestParam(name = "d", defaultValue = "2022-05-20") String d,
                          @RequestParam(name = "t1", defaultValue = "21:30:20") String t1,
                          @RequestParam(name = "t2", defaultValue = "22:46:20") String t2) throws ParseException {
        List<PresentAndAbsent> presentAndAbsentList = facialService.getPresentsAndAbsent(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d+" "+t1), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d+" "+t2));

        Collections.sort(presentAndAbsentList, new Comparator<PresentAndAbsent>() {
            @Override
            public int compare(PresentAndAbsent o1, PresentAndAbsent o2) {
                return (((PresentAndAbsent)o1).getLastname()+" "+o1.getFirstname())
                        .compareTo(((PresentAndAbsent)o2).getLastname()+" "+o2.getFirstname());
            }
        });

        model.addAttribute("presentAndAbsents",presentAndAbsentList);

        return "pp";
    }
    @GetMapping("form")
    public String getform(){

        return "form";
    }
}
