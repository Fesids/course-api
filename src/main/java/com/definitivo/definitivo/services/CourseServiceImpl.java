package com.definitivo.definitivo.services;

import com.definitivo.definitivo.DTO.CourseDto;
import com.definitivo.definitivo.exceptions.CourseNotFoundException;
import com.definitivo.definitivo.models.Course;
import com.definitivo.definitivo.repository.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(CourseDto courseDto) {
        return courseRepository.save(new Course(courseDto));
    }

    @Override
    public Optional<Course> getCourseById(long courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Course getByTitle(String title) {
        return courseRepository.findCourseByTitle(title).get();
    }


    @Override
    public Iterable<Course> getCourseByCategory(String category) {
       return courseRepository.findCourseByCategory(category);
    }

    @Override
    public Page<Course> getCourses(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return courseRepository.findAll(pageable);
    }

    @Override
    public Course updateCourse(Long courseId, CourseDto course) {
        Course oldcourse = courseRepository.findById(courseId).get();
        oldcourse.setRating(course.rating());
        oldcourse.setTitle(course.title());
        oldcourse.setCategory(course.category());
        oldcourse.setImg(course.img());
        oldcourse.setPrice(course.price());
        return oldcourse;


    }

    @Override
    public void deleteCourseById(long id) {
        courseRepository.deleteById(id);
    }
}
