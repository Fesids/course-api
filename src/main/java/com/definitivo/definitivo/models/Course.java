package com.definitivo.definitivo.models;


import com.definitivo.definitivo.DTO.CourseDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "courses")
@Data
public class Course {

    /*@ManyToMany(mappedBy = "courses")

    private Set<Author> authors = new HashSet<>();*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, updatable = true)
    private String title;

    /*@Column(name = "price", nullable = false, updatable = true)
    private int price;*/

    @Column(name = "category", nullable = false, updatable = true)
    private String category;

    @Column(name = "rating", nullable = false, updatable = false)
    private int rating;

    @Column(name = "img",nullable = true, updatable = true)
    private String img;

    @Column(name = "price", nullable = false, updatable = true)
    private BigDecimal price;

    public Course(String title, BigDecimal price, String category, int rating) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.rating = rating;
    }

    public Course(CourseDto courseDto){
        this.title = courseDto.title();
        this.category = courseDto.category();
        this.rating = courseDto.rating();
        this.img = courseDto.img();
        this.price =  courseDto.price();

    }
}
