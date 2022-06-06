package com.example.elfabis.Service.ServiceImp;

import com.example.elfabis.Entity.Plan;
import com.example.elfabis.Repository.PlanRepository;
import com.example.elfabis.Service.PlanService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class PlanServiceImp implements PlanService {
    PlanRepository planRepository;

    @Override
    public List<Plan> listAllPlans() {
        return planRepository.findAll();
    }

    @Override
    public Plan getPlanById(Integer planId) {
        return planRepository.getById(planId);
    }

    @Override
    public Plan updatePlan(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public void deletePlan(Integer planId) {
        planRepository.deleteById(planId);
    }

    @Override
    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }
}
