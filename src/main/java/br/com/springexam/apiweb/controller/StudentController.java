package br.com.springexam.apiweb.controller;

import br.com.springexam.apiweb.model.Student;
import br.com.springexam.apiweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.POST, value ="/students")
    public ResponseEntity<List<Student>> insert(@RequestBody List<Student> studentList) {
        studentService.save(studentList);
        System.out.println("Students: " + studentList.toString() + " saved!");
        return new ResponseEntity<>(studentList, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/students")
    public ResponseEntity<Collection<Student>> getAll(){
        Collection<Student> students = studentService.selectAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/students/{id}")
    public ResponseEntity<Student> getById(@PathVariable int id) {
        Student result = studentService.selectById(id);
        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
    public ResponseEntity<Student> delete(@PathVariable int id) {
        Student student = studentService.selectById(id);
        if(student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.delete(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/students")
    public ResponseEntity<Student> update(@RequestBody Student student) {
        Student result = studentService.selectById(student.getStudentId());
        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.update(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
