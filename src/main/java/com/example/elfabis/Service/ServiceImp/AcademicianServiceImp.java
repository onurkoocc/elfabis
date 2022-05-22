package com.example.elfabis.Service.ServiceImp;

import com.example.elfabis.Entity.Academician;
import com.example.elfabis.Entity.ERole;
import com.example.elfabis.Entity.Role;
import com.example.elfabis.Payload.Request.UserInfoRequest;
import com.example.elfabis.Repository.AcademicianRepository;
import com.example.elfabis.Repository.RoleRepository;
import com.example.elfabis.Service.AcademicianService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class AcademicianServiceImp implements AcademicianService {
    @Autowired
    AcademicianRepository academicianRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public List<Academician> listAllAcademicians(){
        return academicianRepository.findAll();
    }

    @Override
    public Academician getAcademicianById(Integer id){
        return academicianRepository.getById(id);
    }

    @Override
    public Academician createAcademician(UserInfoRequest academician){
        Academician userTmp = new Academician(academician.getName(),
                academician.getEmail(),
                academician.getUsername(),
                encoder.encode(academician.getPassword()));
        String strRole = academician.getRole();
        Role role = new Role();

        if(strRole.equalsIgnoreCase("MUDEKMEMBER")){
            Role adminRole = roleRepository.findByName(ERole.MUDEKMEMBER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            role.setRole(adminRole);
        }else if (strRole.equalsIgnoreCase("COMMISSIONER")){
            Role userRole = roleRepository.findByName(ERole.COMMISSIONER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            role.setRole(userRole);
        }else{
            Role userRole = roleRepository.findByName(ERole.LECTURER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            role.setRole(userRole);
        }

        userTmp.setRole(role);
        userTmp = academicianRepository.save(userTmp);
        return userTmp;
    }
    @Override
    public void deleteAcademician(Integer academicianId){
        academicianRepository.deleteById(academicianId);
    }
    @Override
    public Academician updateAcademician(UserInfoRequest academician){
        Academician userTmp = academicianRepository.getById(academician.getId());
        userTmp.setName(academician.getName());
        userTmp.setUsername(academician.getUsername());
        userTmp.setEmail(academician.getEmail());

        String strRole = academician.getRole();
        Role role = new Role();

        if(strRole.equalsIgnoreCase("MUDEKMEMBER")){
            Role adminRole = roleRepository.findByName(ERole.MUDEKMEMBER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            role.setRole(adminRole);
        }else if (strRole.equalsIgnoreCase("COMMISSIONER")){
            Role userRole = roleRepository.findByName(ERole.COMMISSIONER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            role.setRole(userRole);
        }else{
            Role userRole = roleRepository.findByName(ERole.LECTURER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            role.setRole(userRole);
        }

        userTmp.setRole(role);
        userTmp = academicianRepository.save(userTmp);
        return userTmp;
    }
}
