package com.sofka.appointment;

import com.sofka.util.Utility;

import java.time.LocalDate;
import java.util.UUID;

public class Appointment {

    private UUID id;
    private String patientClinicalNumber;
    private Status status;
    private LocalDate date;

    private AppointmentType appointmentType;

    private String responsible;

    private Utility utility = new Utility();

    public Appointment(String patientClinicalNumber,
                       LocalDate date,
                       AppointmentType appointmentType,
                       String responsible)
    {
        this.patientClinicalNumber = patientClinicalNumber;
        this.date = date;
        this.appointmentType = appointmentType;
        this.responsible = responsible;
        this.id = UUID. randomUUID();
        this.status = Status.NOT_STARTED;
    }

    public UUID getId() {
        return id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String getResponsible() {
        return responsible;
    }

    public LocalDate getDate() {
        return date;
    }

    public void displayAppointment(){
        utility.displayData("ID: "+ this.id
                + " | Patient ID:" + this.patientClinicalNumber
                + " | Date:" + this.date.toString()
                + " | Type: "+ this.appointmentType.toString().toLowerCase()
                + " | Status: "+ this.status.toString().toLowerCase());
    }
}
