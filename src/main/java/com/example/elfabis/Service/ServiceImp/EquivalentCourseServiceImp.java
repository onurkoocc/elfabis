package com.example.elfabis.Service.ServiceImp;

import com.example.elfabis.Entity.Course;
import com.example.elfabis.Entity.EquivalentCourse;
import com.example.elfabis.Repository.CourseRepository;
import com.example.elfabis.Repository.EquivalentCourseRepository;
import com.example.elfabis.Service.EquivalentCourseService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class EquivalentCourseServiceImp implements EquivalentCourseService {
    EquivalentCourseRepository equivalentCourseRepository;

    @Override
    public List<EquivalentCourse> listAllEquivalentCourses() {
        return equivalentCourseRepository.findAll();
    }

    @Override
    public EquivalentCourse getEquivalentCourseById(Integer equivalentCourseId) {
        return equivalentCourseRepository.getById(equivalentCourseId);
    }

    @Override
    public EquivalentCourse updateEquivalentCourse(EquivalentCourse equivalentCourse) {
        return equivalentCourseRepository.save(equivalentCourse);
    }

    @Override
    public void deleteEquivalentCourse(Integer equivalentCourseId) {
        equivalentCourseRepository.deleteById(equivalentCourseId);
    }

    @Override
    public EquivalentCourse createEquivalentCourse(EquivalentCourse course) {
        return equivalentCourseRepository.save(course);
    }
}
