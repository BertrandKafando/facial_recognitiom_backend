package ma.enset.facial_recognition_spring;

import ma.enset.facial_recognition_spring.entities.Present;
import ma.enset.facial_recognition_spring.entities.Student;
import ma.enset.facial_recognition_spring.repositories.PresentRepository;
import ma.enset.facial_recognition_spring.repositories.StudentRepository;
import ma.enset.facial_recognition_spring.service.FacialService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class FacialRecognitionSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacialRecognitionSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner (FacialService facialService,
                                         StudentRepository studentRepository,
                                         PresentRepository presentRepository){

        return args -> {


            facialService.getAllAbsentStudent(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-05-20 21:30:20"),
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-05-20 22:46:20")).forEach( p->{
                System.out.println(p);
            });
        };

    }

}
