package com.definitivo.definitivo.DTO;

public class AuthorCourseDto {

    private long id;
    private String authorName;
    private String courseName;
    private String title;

    public AuthorCourseDto(long id, String authorName, String courseName, String title) {
        this.id = id;
        this.authorName = authorName;
        this.courseName = courseName;
        this.title = title;
    }
}
