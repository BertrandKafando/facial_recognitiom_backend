package ma.enset.facial_recognition_spring.service;

import lombok.AllArgsConstructor;
import ma.enset.facial_recognition_spring.entities.Etat;
import ma.enset.facial_recognition_spring.entities.Present;
import ma.enset.facial_recognition_spring.entities.PresentAndAbsent;
import ma.enset.facial_recognition_spring.entities.Student;
import ma.enset.facial_recognition_spring.repositories.PresentRepository;
import ma.enset.facial_recognition_spring.repositories.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.coyote.http11.Constants.a;

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
        List<Student> absents = new ArrayList<>();

       students.forEach(
               student -> {
                   int i=0;

                   for (int j=0;j<presents.size();j++){
                       String na1=presents.get(j).getFirstname();
                       String na2=student.getFirstname();

                       if (na2.equals(na1) ){
                           System.out.println("okokokokkokok");
                           i++;
                       }
                   }
                   if(i==0){
                       System.out.println("abs");
                       absents.add(student);
                   }

               }
       );



        return absents;
    }
    @Override
    public List<Student> getAllPresents(Date t1, Date t2) {
        List<Student>students=getAllStudent();
        List<Present>presents=getAllPresentStudent(t1,t2);
        List<Student> pres = new ArrayList<>();

        students.forEach(
                student -> {
                    int i=0;

                    for (int j=0;j<presents.size();j++){
                        String na1=presents.get(j).getFirstname();
                        String na2=student.getFirstname();

                        if (na2.equals(na1) ){
                            System.out.println("okokokokkokok");
                            i++;
                        }
                    }
                    if(i>0){
                        System.out.println("abs");
                        pres.add(student);
                    }

                }
        );



        return pres;
    }

    @Override
    public List<PresentAndAbsent> getPresentsAndAbsent(Date t1, Date t2) {
        List<PresentAndAbsent> presentAndAbsentList = new ArrayList<>();
        List<Student> presents = getAllPresents(t1, t2);
        List<Student> absents = getAllAbsentStudent(t1, t2);
        presents.forEach(p->{
          PresentAndAbsent presentAndAbsent = new PresentAndAbsent();
          BeanUtils.copyProperties(p,presentAndAbsent);
          presentAndAbsent.setEtat(Etat.PRESENT);
          presentAndAbsentList.add(presentAndAbsent);
        });
        absents.forEach(p->{
            PresentAndAbsent presentAndAbsent = new PresentAndAbsent();
            BeanUtils.copyProperties(p,presentAndAbsent);
            presentAndAbsent.setEtat(Etat.ABSENT);
            presentAndAbsentList.add(presentAndAbsent);
        });
        return presentAndAbsentList;
    }
}
