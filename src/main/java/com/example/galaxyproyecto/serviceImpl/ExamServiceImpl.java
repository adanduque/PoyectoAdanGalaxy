package com.example.galaxyproyecto.serviceImpl;

import com.example.galaxyproyecto.model.Exam;
import com.example.galaxyproyecto.model.Exam;
import com.example.galaxyproyecto.repository.IExamRepository;
import com.example.galaxyproyecto.repository.IExamRepository;
import com.example.galaxyproyecto.service.IExamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.galaxyproyecto.util.QueryUtil.getLike;

@Service
public class ExamServiceImpl implements IExamService {
    @Autowired
    private IExamRepository examRepository;

    @Override
    public List<Exam> findAll() {
        return examRepository.findAllCustom();
    }

    @Override
    public Exam add(Exam exam) {

        return examRepository.save(exam);
    }

    @Override
    public Optional<Exam> findById(Integer id) {

        return examRepository.findById(id);
    }

    @Override
    public Exam update(Exam exam) {

        Optional<Exam> optExam = examRepository.findById(exam.getIdExam());

        if (optExam.isPresent()) {
            Exam retExam = optExam.get();
            BeanUtils.copyProperties(exam, retExam);
            return examRepository.save(retExam);
        }
        return null;
    }

    @Override
    public Exam delete(Integer id) {
        Optional<Exam> optExam = examRepository.findById(id);

        if (optExam.isPresent()) {
            Exam retExam = optExam.get();
            retExam.setState(0);
            return examRepository.save(retExam);
        }
        return null;
    }

    @Override
    public List<Exam> findByLikeName(Exam exam) {

        return examRepository.findByLikeName(getLike(exam.getName()));
    }

    @Override
    public Page<Exam> findByLikeNamePaging(Pageable pageable, String name) {
        return examRepository.findByLikeNamePaging(pageable,getLike(name));
    }
}

