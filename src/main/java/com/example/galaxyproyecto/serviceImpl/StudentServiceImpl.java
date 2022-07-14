package com.example.galaxyproyecto.serviceImpl;

import com.example.galaxyproyecto.model.Student;
import com.example.galaxyproyecto.repository.IStudentRepository;
import com.example.galaxyproyecto.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.galaxyproyecto.util.QueryUtil.getLike;

@Service
public class StudentServiceImpl implements IStudentService {

    
        @Autowired
        private IStudentRepository studentRepository;

        @Override
        public List<Student> findAll() {

            //return StudentRepository.findAll();
            return studentRepository.findAllCustom();
        }

        @Override
        public Student add(Student student) {

            return studentRepository.save(student);
        }

        @Override
        public Optional<Student> findById(Integer id) {

            return studentRepository.findById(id);
        }

        @Override
        public Student update(Student student) {

            Optional<Student> optStudent = studentRepository.findById(student.getIdStudent());

            if (optStudent.isPresent()) {
                Student retStudent = optStudent.get();
                BeanUtils.copyProperties(student, retStudent);
                return studentRepository.save(retStudent);
            }
            return null;
        }

        @Override
        public Student delete(Integer id) {
            Optional<Student> optStudent = studentRepository.findById(id);

            if (optStudent.isPresent()) {
                Student retStudent = optStudent.get();
                retStudent.setState(0);
                return studentRepository.save(retStudent);
            }
            return null;
        }

        @Override
        public List<Student> findByLikeName(Student student) {

            return studentRepository.findByLikeName(getLike(student.getName()));
        }

        @Override
        public Page<Student> findByLikeNamePaging(Pageable pageable, String name) {
            return studentRepository.findByLikeNamePaging(pageable,getLike(name));
        }
    }
