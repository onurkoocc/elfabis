package com.example.elfabis.Service;

import com.example.elfabis.Entity.Plan;

import java.util.List;

public interface PlanService {
    List<Plan> listAllPlans();

    Plan getPlanById(Integer planId);

    Plan updatePlan(Plan plan);

    void deletePlan(Integer planId);

    Plan createPlan(Plan plan);
}
