package com.sofka.appointment;

import java.util.Date;

public abstract class Appointment {

    protected String patientClinicalNumber;
    protected Status status;
    protected Date date;

    public Appointment(String patientClinicalNumber, Date date) {
        this.patientClinicalNumber = patientClinicalNumber;
        this.date = date;
        this.status = Status.NOT_STARTED;
    }
}
