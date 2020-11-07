package br.com.springexam.apiweb.service;

import br.com.springexam.apiweb.model.Teacher;
import br.com.springexam.apiweb.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> save(List<Teacher> teacherList) {
        return teacherRepository.saveAll(teacherList);
    }

    public Teacher update(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher selectById(int id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public List<Teacher> selectAll(){
        return teacherRepository.findAll();
    }

    public void delete(Teacher teacher) {
        teacherRepository.delete(teacher);
    }
}
