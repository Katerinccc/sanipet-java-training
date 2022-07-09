package com.sofka.appointment;

import java.time.LocalDate;
import java.util.UUID;

public class Appointment {

    private UUID id;
    private String patientClinicalNumber;
    private Status status;
    private LocalDate date;

    private AppointmentType appointmentType;

    public Appointment(String patientClinicalNumber, LocalDate date, AppointmentType appointmentType) {
        this.patientClinicalNumber = patientClinicalNumber;
        this.date = date;
        this.appointmentType = appointmentType;
        this.id = UUID. randomUUID();
        this.status = Status.NOT_STARTED;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }
}
