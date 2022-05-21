package com.example.elfabis.Service.ServiceImp;

import com.example.elfabis.Entity.Academician;
import com.example.elfabis.Repository.AcademicianRepository;
import com.example.elfabis.Service.AcademicianService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class AcademicianServiceImp implements AcademicianService {
    @Autowired
    AcademicianRepository academicianRepository;

    @Override
    public List<Academician> listAllAcademician(){
        return academicianRepository.findAll();
    }

    @Override
    public Academician getAcademicianById(Long id){
        return academicianRepository.getById(id.intValue());
    }
}
