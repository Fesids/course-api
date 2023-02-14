package com.definitivo.definitivo.repository;

import com.definitivo.definitivo.models.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    /*@Query(value = "select * from courses where category =:category", nativeQuery = true)
    Iterable<Course> findCourseByCategory(@Param("category") String category);*/

    Iterable<Course> findCourseByCategory(String category);

   Optional<Course> findCourseByTitle(String title);

}
