package br.com.springexam.apiweb.controller;

import br.com.springexam.apiweb.model.Student;
import br.com.springexam.apiweb.model.Teacher;
import br.com.springexam.apiweb.service.StudentService;
import br.com.springexam.apiweb.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(method = RequestMethod.POST, value ="/teachers")
    public ResponseEntity<List<Teacher>> insert(@RequestBody List<Teacher> teacherList) {
        teacherService.save(teacherList);
        System.out.println("Teachers: " + teacherList.toString() + " saved!");
        return new ResponseEntity<>(teacherList, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value ="/teachers")
    public ResponseEntity<Collection<Teacher>> getAll(){
        Collection<Teacher> teachers = teacherService.selectAll();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/teachers/{id}")
    public ResponseEntity<Teacher> getById(@PathVariable int id) {
        Teacher result = teacherService.selectById(id);
        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/teachers/{id}")
    public ResponseEntity<Teacher> delete(@PathVariable int id) {
        Teacher teacher = teacherService.selectById(id);
        if(teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        teacherService.delete(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/teachers")
    public ResponseEntity<Teacher> update(@RequestBody Teacher teacher) {
        Teacher result = teacherService.selectById(teacher.getTeacherId());
        if(result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        teacherService.update(teacher);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }
}
