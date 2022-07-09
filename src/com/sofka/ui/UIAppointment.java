package com.sofka.ui;

import com.sofka.appointment.Appointment;
import com.sofka.appointment.AppointmentType;
import com.sofka.appointment.Status;
import com.sofka.patient.Owner;
import com.sofka.patient.Patient;
import com.sofka.util.DataUserType;
import com.sofka.util.Utility;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UIAppointment {

    private Utility utility = new Utility();
    private Integer option = 0;
    private List<Appointment> appointments;
    private List<Patient> patients;

    public List<Appointment> appointmentMenu(List<Patient> patientsSanipet,
                                             List<Appointment> appointmentsSanipet){

        appointments = appointmentsSanipet;
        patients = patientsSanipet;

        do {
            utility.displayData("1. Create appointment");
            utility.displayData("2. Update appointment status");
            utility.displayData("3. Display appointments by date");
            utility.displayData("0. Return to main menu");
            option = (Integer) utility.getDataUser(DataUserType.INTEGER);
            options(option);
        }while (option != 0);

        return appointments;
    }

    private void options (int option) {

        utility.displayData("-------------------------------------------------------------------------------");

        switch (option) {
            case 1 -> registerAppointment();
            case 2 -> updateAppointment(appointments);
            case 3 -> displayAppointmentsDate();
            case 0 -> utility.displayData("You will be redirect to main menu.");
            default -> utility.displayData("Enter a valid option.");
        }

        utility.displayData("-------------------------------------------------------------------------------");
    }

    private void registerAppointment(){

        List<String> patientsId = patients.stream().map(Patient::getClinicNumber).toList();
        String idPatient;

        do {
            utility.displayData("Enter a valid patient´s ID to create the appointment");
            idPatient = (String) utility.getDataUser(DataUserType.TEXT);
        }while (!patientsId.contains(idPatient));

        Owner owner = getPatientOwner(idPatient);

        String ownerData = "DNI: " + owner.getDNI() + " Full name: "
                + owner.getName() + " " + owner.getSurname();

        utility.displayData("Enter date for the appointment in format yyyy-mm-dd:");
        LocalDate date = (LocalDate) utility.getDataUser(DataUserType.DATE);

        AppointmentType appointmentType = selectAppointmentType();

        Appointment newAppointment = new Appointment(idPatient, date, appointmentType,ownerData);
        appointments.add(newAppointment);

        utility.displayData("The appointment was created successfully, the ID generated is: "
                + newAppointment.getId());

    }

    private Owner getPatientOwner(String idPatient){

        Optional<Patient> optionalOwner = patients.stream()
                .filter(item -> item.getClinicNumber().equals(idPatient))
                .findFirst();

        if (optionalOwner.isEmpty()){
            utility.displayData("The patient do not exist");
            return null;
        }

        return optionalOwner.get().getOwner();

    }

    private AppointmentType selectAppointmentType(){

        AppointmentType appointmentType = null;

        utility.displayData("Select patient type:");
        utility.displayData("1. Medical");
        utility.displayData("2. Surgery:");
        utility.displayData("3. Aesthetic");

        do {
            option = (Integer) utility.getDataUser(DataUserType.INTEGER);
            switch (option){
                case 1 -> appointmentType = AppointmentType.MEDICAL;
                case 2 -> appointmentType = AppointmentType.SURGERY;
                case 3 -> appointmentType = AppointmentType.AESTHETIC;
                default -> utility.displayData("Select a valid option:");
            }
        }while (appointmentType == null);

        return appointmentType;
    }

    private void updateAppointment(List<Appointment> appointments) {

        Optional<Appointment> optionalAppointmentUpdate = getAppointment(appointments);
        if (optionalAppointmentUpdate.isEmpty()){
            return;
        }
        Appointment appointmentUpdate = optionalAppointmentUpdate.get();

        Status newStatus = changeStatus(appointmentUpdate);

        appointmentUpdate.setStatus(newStatus);

        utility.displayData("The Appointment with ID: " +
                appointmentUpdate.getId() + " was updated successfully.");

    }

    public Optional<Appointment> getAppointment(List<Appointment> appointments) {

        UUID finalUuidAppointment = validateAppointmentID(appointments);
        Optional<Appointment> optionalAppointmentUpdate = appointments
                .stream().filter(appointment -> appointment.getId().equals(finalUuidAppointment)).findFirst();

        if (optionalAppointmentUpdate.isEmpty()) {
            utility.displayData("ID not found.");
            return Optional.empty();
        }
        return optionalAppointmentUpdate;
    }

    private UUID validateAppointmentID(List<Appointment> appointments) {
        List<UUID> appointmentIds = appointments.stream().map(Appointment::getId).toList();
        String appointmentId;
        UUID uuidAppointment;

        do {
            utility.displayData("Enter a valid appointment´s ID to continue:");
            appointmentId = (String) utility.getDataUser(DataUserType.TEXT);
            uuidAppointment = UUID.fromString(appointmentId);
        }while (!appointmentIds.contains(uuidAppointment));
        return uuidAppointment;
    }

    private Status changeStatus(Appointment appointmentUpdate){

        Status status;

        utility.displayData("Select the new status for the Appointment:");
        utility.displayData("1. Finished");
        utility.displayData("2. Absent:");
        utility.displayData("3. Canceled");

        do {
            option = (Integer) utility.getDataUser(DataUserType.INTEGER);
            status = getStatus(appointmentUpdate);
        }while (status == null);

        return status;
    }

    private Status getStatus(Appointment appointmentUpdate) {
        Status status = null;
        switch (option){
            case 1 -> status = Status.FINISHED;
            case 2 -> status = Status.ABSENT;
            case 3 -> {
                if (validateCancelAppointment(appointmentUpdate)){
                    status = Status.CANCELED;
                }else {
                    utility.displayData("The appointment can not be canceled due to veterinary policies.");
                    utility.displayData("The status will change to absent.");
                    status = Status.ABSENT;
                }
            }
            default -> utility.displayData("Select a valid option:");
        }
        return status;
    }

    private boolean validateCancelAppointment(Appointment appointmentUpdate){

        LocalDate today = LocalDate.now();
        LocalDate appointmentDate = appointmentUpdate.getDate();

        long difference = today.until(appointmentDate, ChronoUnit.DAYS);

        return difference > 0;

    }

    private void displayAppointmentsDate(){

        utility.displayData("Enter date to search appointments:");
        LocalDate date = (LocalDate) utility.getDataUser(DataUserType.DATE);

        List<Appointment> appointmentsPerDate =
                appointments.stream().filter(dates -> dates.getDate().equals(date)).toList();

        if (appointmentsPerDate.isEmpty()){
            utility.displayData("There are no appointments for the indicated date");
        }else {
            utility.displayData("The appointments on date: " + date + " is/are: ");
            appointmentsPerDate.forEach(Appointment::displayAppointment);
        }
    }

}
