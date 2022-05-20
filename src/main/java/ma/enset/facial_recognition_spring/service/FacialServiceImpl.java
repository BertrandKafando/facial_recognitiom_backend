package ma.enset.facial_recognition_spring.service;

import lombok.AllArgsConstructor;
import ma.enset.facial_recognition_spring.entities.Present;
import ma.enset.facial_recognition_spring.entities.Student;
import ma.enset.facial_recognition_spring.repositories.PresentRepository;
import ma.enset.facial_recognition_spring.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class FacialServiceImpl implements FacialService {
    private PresentRepository presentRepository;
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    @Override
    public List<Present> getAllPresent() {
        return presentRepository.findAll();
    }

    @Override
    public List<Present> getAllPresentStudent(Date t1,Date t2) {

        return presentRepository.findPresentsBetweenTwoDate(t1,t2);
    }

    @Override
    public List<Student> getAllAbsentStudent(Date t1, Date t2) {
        List<Student>students=getAllStudent();
        List<Present>presents=getAllPresentStudent(t1,t2);
        List<Student> absents=new ArrayList<>();

       students.forEach(
               student -> {
                   if(!presents.contains(student)) {
                       absents.add(student);
                   }
               }
       );
        return absents;
    }
}
