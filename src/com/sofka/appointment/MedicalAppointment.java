package com.sofka.appointment;

import java.util.Date;

public class MedicalAppointment extends Appointment{

    private String veterinarianId;

    public MedicalAppointment(String patientClinicalNumber, Date date, String veterinarianId) {
        super(patientClinicalNumber, date);
        this.veterinarianId = veterinarianId;
    }
}
