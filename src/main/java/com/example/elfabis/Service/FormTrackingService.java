package com.example.elfabis.Service;

import com.example.elfabis.Entity.FormTracking;

import java.text.Normalizer;
import java.util.List;

public interface FormTrackingService {
    List<FormTracking> listAllFormTrackings();

    FormTracking getFormTrackingById(Integer formTrackingId);

    FormTracking updateFormTracking(FormTracking formTracking);

    void deleteFormTracking(Integer formTrackingId);

    FormTracking createFormTracking(FormTracking formTracking);
}
