package ma.enset.facial_recognition_spring.trucAjax;

import lombok.AllArgsConstructor;
import ma.enset.facial_recognition_spring.entities.PresentAndAbsent;
import ma.enset.facial_recognition_spring.entities.Student;
import ma.enset.facial_recognition_spring.service.FacialService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

/*
@AllArgsConstructor
public class AjaxSearch {
    FacialService facialService;
    @PostMapping("/students/search")
    public ResponseEntity<?> getSearchResultViaAjax(Errors errors) {


        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);

        }

        List<PresentAndAbsent> students = facialService.getAllStudent(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t1), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t2));
        if (students.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(students);

        return ResponseEntity.ok(result);

    }
}
*/
