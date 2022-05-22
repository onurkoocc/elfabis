package com.example.elfabis.Service.ServiceImp;

import com.example.elfabis.Entity.GivenCourse;
import com.example.elfabis.Repository.GivenCourseRepository;
import com.example.elfabis.Service.GivenCourseService;

import java.util.List;

public class GivenCourseServiceImp implements GivenCourseService {
    GivenCourseRepository givenCourseRepository;
    @Override
    public List<GivenCourse> listAllGivenCourses(){
        return givenCourseRepository.findAll();
    }
    @Override
    public GivenCourse createGivenCourse(GivenCourse givenCourse){
        return givenCourseRepository.save(givenCourse);
    }
    @Override
    public void deleteGivenCourse(Integer givenCourseId){
        givenCourseRepository.deleteById(givenCourseId);
    }
    @Override
    public GivenCourse updateGivenCourse(GivenCourse givenCourse){
        return givenCourseRepository.save(givenCourse);
    }
    @Override
    public GivenCourse getGivenCourseById(Integer givenCourseId){
        return givenCourseRepository.getById(givenCourseId);
    }
}
