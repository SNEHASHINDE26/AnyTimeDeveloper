package controller;

import exception.ResourceNotFoundException;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.StudentRepository;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/students")
public class StudentController  {

    @Autowired
   private StudentRepository studentRepository;

    @GetMapping
    public List<Student>getAllStudents(){
        return studentRepository.findAll();
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }
    @GetMapping("{Id}")
    public ResponseEntity<Student>getStudentById(@PathVariable int Id){
        Student student=studentRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Student Not Exist with Id:"+Id));
        return ResponseEntity.ok(student);
    }
    @PutMapping("{Id}")
    public ResponseEntity<Student>updateStudent(@PathVariable int Id,@RequestBody Student studentDetails){
        Student updateStudent = studentRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Student Not Exist with Id "+Id));
        updateStudent.setName(studentDetails.getName());
        updateStudent.setBranch(studentDetails.getBranch());
        studentRepository.save(updateStudent);
        return ResponseEntity.ok(updateStudent);

    }
    @DeleteMapping("{Id}")
    public ResponseEntity<HttpStatus>deleteStudent(@PathVariable int Id){
        Student student =studentRepository.findById(Id).orElseThrow(()->new ResourceNotFoundException("Student Not Exist with Id"+Id));
        studentRepository.delete(student);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
