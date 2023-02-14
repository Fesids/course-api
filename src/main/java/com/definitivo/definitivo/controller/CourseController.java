package com.definitivo.definitivo.controller;

import com.definitivo.definitivo.DTO.CourseDto;
import com.definitivo.definitivo.models.Course;
import com.definitivo.definitivo.repository.CourseRepository;
import com.definitivo.definitivo.services.CourseService;
import com.definitivo.definitivo.services.CourseServiceImpl;
import com.definitivo.definitivo.utils.GeralUtillities;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/api/courses")
@Tag(name = "Course Controller", description =
"This rest controller provides action to manage course services")
public class CourseController {

    private CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository){

        this.courseRepository = courseRepository;
    }

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Provides all courses avaible in the Course tracker app")
    @ResponseBody
    public ResponseEntity<Page<Course>> index(@RequestParam int page, @RequestParam int size){
        Page<Course> data = courseService.getCourses(page, size);
        return ResponseEntity.ok().body(data);
    }

    @PostMapping("/course/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(description = "")
    public ResponseEntity<Course> createCourseController(@RequestBody CourseDto course){
        Course newCourse = courseService.createCourse(course);
        URI uri = GeralUtillities.toUri("/course/save");
        return ResponseEntity.created(uri).body(newCourse);
    }


    @GetMapping("/course/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    @Operation(summary = "Provides course details for the supplied course id from the Course Tracker ap")
    public ResponseEntity<Optional<Course>> getCourseById(@PathVariable("id") long courseId){
        var coruse = courseService.getCourseById(courseId);
        return ResponseEntity.ok().body(coruse);
    }

    @GetMapping("course/category/{name}")
    public ResponseEntity<Iterable<Course>> getCourseByCategory(@PathVariable("name") String name){
        var courses = courseService.getCourseByCategory(name);
        return ResponseEntity.ok().body(courses);
    }

    @GetMapping("course/title/{title}")
    public ResponseEntity<Course> getCourseByTitle(@PathVariable("title") String title){
        var course = courseService.getByTitle(title);
        return ResponseEntity.ok().body(course);
    }
    @PutMapping("course/update/{id}")
    @Transactional
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @Operation(description = "update course using his releated id in the Course tracker app")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") long courseId, @RequestBody CourseDto course){
       Course data = courseService.updateCourse(courseId, course);
       return ResponseEntity.ok().body(data);
    }

    @DeleteMapping("course/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteCourseById(@PathVariable("id") Long courseId){

        courseService.deleteCourseById(courseId);
        return  ResponseEntity.ok().build();
    }
}
