package com.ozgurbayrasa.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    // Initialize given course code value.
    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix = theCourseCode.value();
    }

    // Makes validation
    // If course starts with coursePrefix return true.
    // Else false.

    // Make sure you're doing null control.
    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        if(theCode == null){
            return true;
        }
        return theCode.startsWith(coursePrefix);
    }
}
