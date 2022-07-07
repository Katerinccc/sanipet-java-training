package com.sofka.appointment;

import com.sofka.employee.Veterinary;

import java.util.Date;

public class SurgeryAppointment extends MedicalAppointment{

    private String surgeryType;

    public SurgeryAppointment(String patientClinicalNumber,
                              Date date,
                              Veterinary veterinary,
                              String surgeryType) {
        super(patientClinicalNumber, date, veterinary);
        this.surgeryType = surgeryType;
    }
}
