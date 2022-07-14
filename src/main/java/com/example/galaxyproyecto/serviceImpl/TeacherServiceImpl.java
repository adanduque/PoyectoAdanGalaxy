package com.example.galaxyproyecto.serviceImpl;

import com.example.galaxyproyecto.model.Teacher;
import com.example.galaxyproyecto.repository.ITeacherRepository;
import com.example.galaxyproyecto.service.ITeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.example.galaxyproyecto.util.QueryUtil.*;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAll() {

        //return TeacherRepository.findAll();
        return teacherRepository.findAllCustom();
    }

    @Override
    public Teacher add(Teacher teacher) {

        return teacherRepository.save(teacher);
    }

    @Override
    public Optional<Teacher> findById(Integer id) {

        return teacherRepository.findById(id);
    }

    @Override
    public Teacher update(Teacher teacher) {

        Optional<Teacher> optTeacher = teacherRepository.findById(teacher.getIdTeacher());

        if (optTeacher.isPresent()) {
            Teacher retTeacher = optTeacher.get();
            BeanUtils.copyProperties(teacher, retTeacher);
            return teacherRepository.save(retTeacher);
        }
        return null;
    }

    @Override
    public Teacher delete(Integer id) {
        Optional<Teacher> optTeacher = teacherRepository.findById(id);

        if (optTeacher.isPresent()) {
            Teacher retTeacher = optTeacher.get();
            retTeacher.setState(0);
            return teacherRepository.save(retTeacher);
        }
        return null;
    }

    @Override
    public List<Teacher> findByLikeName(Teacher teacher) {

        return teacherRepository.findByLikeName(getLike(teacher.getName()));
    }

    @Override
    public Page<Teacher> findByLikeNamePaging(Pageable pageable, String name) {
        return teacherRepository.findByLikeNamePaging(pageable,getLike(name));
    }
}
