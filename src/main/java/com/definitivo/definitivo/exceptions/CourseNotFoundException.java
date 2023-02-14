package com.definitivo.definitivo.exceptions;

public class CourseNotFoundException extends RuntimeException{

    private static long serialVersionUID = 50712359L;

    public CourseNotFoundException(String message){
        super(message);
    }
}
