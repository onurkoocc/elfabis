package com.example.elfabis.Service;

import com.example.elfabis.Entity.GivenCourse;

import java.util.List;

public interface GivenCourseService {
    List<GivenCourse> listAllGivenCourses();

    GivenCourse createGivenCourse(GivenCourse givenCourse);

    void deleteGivenCourse(Integer givenCourseId);

    GivenCourse updateGivenCourse(GivenCourse givenCourse);

    GivenCourse getGivenCourseById(Integer givenCourseId);
}