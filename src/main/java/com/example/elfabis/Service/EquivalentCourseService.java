package com.example.elfabis.Service;

import com.example.elfabis.Entity.EquivalentCourse;

import java.util.List;

public interface EquivalentCourseService {
    List<EquivalentCourse> listAllEquivalentCourses();

    EquivalentCourse getEquivalentCourseById(Integer equivalentCourseId);

    EquivalentCourse updateEquivalentCourse(EquivalentCourse equivalentCourse);

    void deleteEquivalentCourse(Integer equivalentCourseId);

    EquivalentCourse createEquivalentCourse(EquivalentCourse equivalentCourse);
}
