package ma.enset.facial_recognition_spring.trucAjax;

import lombok.Data;
import ma.enset.facial_recognition_spring.entities.PresentAndAbsent;

import java.util.List;

@Data
public class AjaxResponseBody {
    String msg;
    List<PresentAndAbsent> result;
}
