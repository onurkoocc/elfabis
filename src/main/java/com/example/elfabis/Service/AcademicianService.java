package com.example.elfabis.Service;

import com.example.elfabis.Entity.Academician;
import com.example.elfabis.Payload.Request.UserInfoRequest;

import java.util.List;

public interface AcademicianService {
    List<Academician> listAllAcademicians();

    List<Academician> listAllCommissioners();

    Academician getAcademicianById(Integer id);

    Academician createAcademician(UserInfoRequest academician);

    void deleteAcademician(Integer academicianId);

    Academician updateAcademician(UserInfoRequest academician);
}
