package com.sofka.appointment;

import java.util.Date;

public class AestheticAppointment extends Appointment{

    private String stylistId;

    public AestheticAppointment(String patientClinicalNumber, Date date, String stylistId) {
        super(patientClinicalNumber, date);
        this.stylistId = stylistId;
    }
}
