package com.example.galaxyproyecto.serviceImpl;

import com.example.galaxyproyecto.model.CourseInscription;
import com.example.galaxyproyecto.repository.ICourseInscriptionRepository;
import com.example.galaxyproyecto.service.ICourseInscriptionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.galaxyproyecto.util.QueryUtil.getLike;

@Service
public class CourseInscriptionImpl implements ICourseInscriptionService {

    
        @Autowired
        private ICourseInscriptionRepository courseInscriptionRepository;

        @Override
        public List<CourseInscription> findAll() {

            //return CourseInscriptionRepository.findAll();
            return courseInscriptionRepository.findAllCustom();
        }

        @Override
        public CourseInscription add(CourseInscription course) {

            return courseInscriptionRepository.save(course);
        }

        @Override
        public Optional<CourseInscription> findById(Integer id) {

            return courseInscriptionRepository.findById(id);
        }

        @Override
        public CourseInscription update(CourseInscription course) {

            Optional<CourseInscription> optCourseInscription = courseInscriptionRepository.findById(course.getIdCourseInscription());

            if (optCourseInscription.isPresent()) {
                CourseInscription retCourseInscription = optCourseInscription.get();
                BeanUtils.copyProperties(course, retCourseInscription);
                return courseInscriptionRepository.save(retCourseInscription);
            }
            return null;
        }

        @Override
        public CourseInscription delete(Integer id) {
            Optional<CourseInscription> optCourseInscription = courseInscriptionRepository.findById(id);

            if (optCourseInscription.isPresent()) {
                CourseInscription retCourseInscription = optCourseInscription.get();
                retCourseInscription.setState(0);
                return courseInscriptionRepository.save(retCourseInscription);
            }
            return null;
        }


    }
