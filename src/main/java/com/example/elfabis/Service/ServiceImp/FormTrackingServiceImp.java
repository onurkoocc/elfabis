package com.example.elfabis.Service.ServiceImp;

import com.example.elfabis.Entity.FormTracking;
import com.example.elfabis.Repository.FormTrackingRepository;
import com.example.elfabis.Service.FormTrackingService;

import java.util.List;

public class FormTrackingServiceImp implements FormTrackingService {
    FormTrackingRepository formTrackingRepository;
    @Override
    public List<FormTracking> listAllFormTracking(){
        return formTrackingRepository.findAll();
    }
    @Override
    public FormTracking getFormTrackingById(Integer formTrackingId){
        return formTrackingRepository.getById(formTrackingId);
    }
    @Override
    public FormTracking updateFormTracking(FormTracking formTracking){
        return formTrackingRepository.save(formTracking);
    }
    @Override
    public void deleteFormTracking(Integer formTrackingId){
        formTrackingRepository.deleteById(formTrackingId);
    }
    @Override
    public FormTracking createFormTracking(FormTracking formTracking){
        return formTrackingRepository.save(formTracking);
    }
}
