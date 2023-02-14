package com.definitivo.definitivo.services;

import com.definitivo.definitivo.DTO.CourseDto;
import com.definitivo.definitivo.models.Course;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface CourseService {

    Course createCourse(CourseDto courseDto);

    Optional<Course> getCourseById(long courseId);

    Course getByTitle(String title);


    Iterable<Course> getCourseByCategory(String category);

    Page<Course> getCourses(int page, int size);

    Course updateCourse(Long courseId, CourseDto course);

    void deleteCourseById(long id);

}
