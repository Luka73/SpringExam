package br.com.springexam.apiweb.service;

import br.com.springexam.apiweb.model.Student;
import br.com.springexam.apiweb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> save(List<Student> studentList) {
        return studentRepository.saveAll(studentList);
    }

    public Student update(Student student) {
        return studentRepository.save(student);
    }

    public Student selectById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> selectAll(){
        return studentRepository.findAll();
    }

    public void delete(Student student) {
        studentRepository.delete(student);
    }
}
