package com.example.elfabis.Service;

import com.example.elfabis.Entity.Academician;

import java.util.List;

public interface AcademicianService {
    List<Academician> listAllAcademician();

    Academician getAcademicianById(Long id);
}
