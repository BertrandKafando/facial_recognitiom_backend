package ma.enset.facial_recognition_spring.trucAjax;

import lombok.AllArgsConstructor;
import ma.enset.facial_recognition_spring.entities.PresentAndAbsent;
import ma.enset.facial_recognition_spring.service.FacialService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@AllArgsConstructor
public class RestControllerPrincipal {
    FacialService facialService;

   /* @PostMapping("/students")
    public ResponseEntity<?> getStudentsViaAjax(String t1,String t2,Errors errors) throws ParseException{

        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);

        }

        List<PresentAndAbsent> students = facialService.getPresentsAndAbsent(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t1), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t2));
        if (students.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(students);

        return ResponseEntity.ok(result);

    }*/



    @GetMapping("/students")
    public List<PresentAndAbsent> getAllStudents(Model model ,
                          @RequestParam(name = "d", defaultValue = "2022-05-20") String d,
                          @RequestParam(name = "t1", defaultValue = "21:30:20") String t1,
                          @RequestParam(name = "t2", defaultValue = "22:46:20") String t2) throws ParseException {
        return facialService.getPresentsAndAbsent(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d+" "+t1), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d+" "+t2));

        /*List<PresentAndAbsent> presentAndAbsentList = facialService.getPresentsAndAbsent(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d+" "+t1), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(d+" "+t2));

        Collections.sort(presentAndAbsentList, new Comparator<PresentAndAbsent>() {
            @Override
            public int compare(PresentAndAbsent o1, PresentAndAbsent o2) {
                return (((PresentAndAbsent)o1).getLastname()+" "+o1.getFirstname())
                        .compareTo(((PresentAndAbsent)o2).getLastname()+" "+o2.getFirstname());
            }
        });

        model.addAttribute("presentAndAbsents",presentAndAbsentList);*/
    }

}
