package com.sofka.appointment;

import java.util.Date;

public class SurgeryAppointment extends MedicalAppointment{

    private String specialty;

    public SurgeryAppointment(
            String patientClinicalNumber,
            Date date,
            String veterinarianId,
            String specialty)
    {
        super(patientClinicalNumber, date, veterinarianId);
        this.specialty = specialty;
    }
}
