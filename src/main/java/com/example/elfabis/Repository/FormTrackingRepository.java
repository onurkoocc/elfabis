package com.example.elfabis.Repository;

import com.example.elfabis.Entity.FormTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormTrackingRepository extends JpaRepository<FormTracking, Integer> {
}
