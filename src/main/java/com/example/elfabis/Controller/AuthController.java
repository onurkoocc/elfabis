package com.example.elfabis.Controller;

import com.example.elfabis.Entity.Academician;
import com.example.elfabis.Entity.ERole;
import com.example.elfabis.Entity.Role;
import com.example.elfabis.Payload.Request.LoginRequest;
import com.example.elfabis.Payload.Request.SignupRequest;
import com.example.elfabis.Payload.Response.JwtResponse;
import com.example.elfabis.Payload.Response.MessageResponse;
import com.example.elfabis.Repository.AcademicianRepository;
import com.example.elfabis.Repository.RoleRepository;
import com.example.elfabis.Security.Jwt.JwtUtils;
import com.example.elfabis.Security.Service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AcademicianRepository academicianRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (academicianRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (academicianRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        Academician academician = new Academician(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        String strRole = signUpRequest.getRole();
        Role role = new Role();

        if (strRole.equalsIgnoreCase("mudekmember")) {
            Role adminRole = roleRepository.findByName(ERole.MUDEKMEMBER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            role.setRole(adminRole);

        } else if (strRole.equalsIgnoreCase("commisioner")) {
            Role userRole = roleRepository.findByName(ERole.COMMISSIONER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            role.setRole(userRole);
        } else {
            Role userRole = roleRepository.findByName(ERole.LECTURER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            role.setRole(userRole);
        }
        academician.setRole(role);
        academicianRepository.save(academician);

        return ResponseEntity.ok(new

                MessageResponse("User registered successfully!"));
    }
}
