package com.sparta.spartatraineesimulator.model.course;

import java.util.List;

public enum Course { //courses in the academy
    JAVA,
    C_SHARP,
    DATA,
    DEVOPS,
    BUSINESS,
    NONE;

    private static final List<Course> VALUES = List.of(values()); //using generalised list to store the enums in it
    private static final int COURSES_SIZE = 5; //size of the courses list- a constant
    private static final CourseRandomGenerator COURSE_RANDOM_GENERATOR =
            new CourseRandomGenerator(0); //using a long seed (will also test it later)

    public String getCourse() { //will use this in testing
        return switch (this) {
            case JAVA -> "Java";
            case C_SHARP -> "C#";
            case DATA -> "Data";
            case DEVOPS -> "DevOps";
            case BUSINESS -> "Business";
            case NONE -> "None";
        };
    }

    public static Course randomCourseType() { //selecting a random course
        return VALUES.get(COURSE_RANDOM_GENERATOR.inRange(0, COURSES_SIZE-1)); //getting a random value/course from the list of courses (within our range)
    }
}
