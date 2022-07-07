package com.sofka.appointment;

import com.sofka.employee.Stylist;
import java.util.Date;

public class AestheticAppointment extends Appointment{

    private Stylist stylist;

    public AestheticAppointment(String patientClinicalNumber, Date date, Stylist stylist) {
        super(patientClinicalNumber, date);
        this.stylist = stylist;
    }
}
