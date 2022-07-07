package com.sofka.appointment;

import com.sofka.employee.Veterinary;

import java.util.Date;

public class MedicalAppointment extends Appointment{

    private Veterinary veterinary;

    public MedicalAppointment(String patientClinicalNumber, Date date, Veterinary veterinary) {
        super(patientClinicalNumber, date);
        this.veterinary = veterinary;
    }
}
