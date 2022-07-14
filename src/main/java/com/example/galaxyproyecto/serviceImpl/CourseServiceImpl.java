package com.example.galaxyproyecto.serviceImpl;

import com.example.galaxyproyecto.model.Course;
import com.example.galaxyproyecto.repository.ICourseRepository;
import com.example.galaxyproyecto.service.ICourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.galaxyproyecto.util.QueryUtil.getLike;

@Service
public class CourseServiceImpl implements ICourseService {

    
        @Autowired
        private ICourseRepository courseRepository;

        @Override
        public List<Course> findAll() {

            //return CourseRepository.findAll();
            return courseRepository.findAllCustom();
        }

        @Override
        public Course add(Course course) {

            return courseRepository.save(course);
        }

        @Override
        public Optional<Course> findById(Integer id) {

            return courseRepository.findById(id);
        }

        @Override
        public Course update(Course course) {

            Optional<Course> optCourse = courseRepository.findById(course.getIdCourse());

            if (optCourse.isPresent()) {
                Course retCourse = optCourse.get();
                BeanUtils.copyProperties(course, retCourse);
                return courseRepository.save(retCourse);
            }
            return null;
        }

        @Override
        public Course delete(Integer id) {
            Optional<Course> optCourse = courseRepository.findById(id);

            if (optCourse.isPresent()) {
                Course retCourse = optCourse.get();
                retCourse.setState(0);
                return courseRepository.save(retCourse);
            }
            return null;
        }

        @Override
        public List<Course> findByLikeName(Course course) {

            return courseRepository.findByLikeName(getLike(course.getName()));
        }

        @Override
        public Page<Course> findByLikeNamePaging(Pageable pageable, String name) {
            return courseRepository.findByLikeNamePaging(pageable,getLike(name));
        }
    }
