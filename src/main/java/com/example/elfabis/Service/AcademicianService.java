package com.example.elfabis.Service;

import com.example.elfabis.Entity.Academician;
import com.example.elfabis.Payload.Request.UserInfoRequest;
import org.apache.catalina.User;

import java.util.List;

public interface AcademicianService {
    List<Academician> listAllAcademicians();

    Academician getAcademicianById(Integer id);

    Academician createAcademician(UserInfoRequest academician);

    void deleteAcademician(Integer academicianId);

    Academician updateAcademician(UserInfoRequest academician);
}
