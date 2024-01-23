package service;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
        List<Student> studentList = new ArrayList<>();

        {
            studentList.add(new Student(1, "Rohini", "CSE"));
            studentList.add(new Student(2, "Vaishu", "IT"));
            studentList.add(new Student(3, "Pooja", "ELECTRICAL"));

            studentRepository.saveAll(studentList);
        }
    }


