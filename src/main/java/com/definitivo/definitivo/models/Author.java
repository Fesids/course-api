package com.definitivo.definitivo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity
@Table(name = "authors")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author {

    /*@ManyToMany
    @JoinTable(name = "AUTHORS_COURSES",
        joinColumns = {
            @JoinColumn(name="author_id", referencedColumnName = "id", nullable = false, updatable = false)
        }, inverseJoinColumns = {
            @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = false, updatable = false)
    })
    @JsonIgnore
    private Set<Course> courses = new HashSet<>();
*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", updatable = true, nullable = false)
    private String name;

    @Column(name = "surname", updatable = true, nullable = true)
    private String surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
