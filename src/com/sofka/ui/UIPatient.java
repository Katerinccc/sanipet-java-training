package com.sofka.ui;

import com.sofka.patient.Owner;
import com.sofka.patient.Patient;
import com.sofka.patient.PatientType;
import com.sofka.util.DataUserType;
import com.sofka.util.Utility;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UIPatient {

    private Utility utility = new Utility();
    private Integer option = 0;
    private ArrayList<Patient> patients = new ArrayList<>();

    public List<Patient> patientMenu(){

        do {
            utility.displayData("1. Create a new Patient");
            utility.displayData("0. Return to main menu");
            option = (Integer) utility.getDataUser(DataUserType.INTEGER);
            options(option);
        }while (option != 0);

        return patients;
    }

    private void options (int option) {

        switch (option) {
            case 1 -> registerPatient();
            case 0 -> utility.displayData("You will be redirect to main menu.");
            default -> utility.displayData("Enter a valid option.");
        }
    }

    private void registerPatient(){

        utility.displayData("Enter patient name:");
        String name = (String) utility.getDataUser(DataUserType.TEXT);

        utility.displayData("Enter patient breed:");
        String breed = (String) utility.getDataUser(DataUserType.TEXT);

        utility.displayData("The patient is vaccinated? Enter 1 for yes and 0 for not:");
        boolean isVaccinated = (boolean) utility.getDataUser(DataUserType.BOOLEAN);

        utility.displayData("Enter date of last deparasitization in format yyyy-mm-dd:");
        LocalDate date = (LocalDate) utility.getDataUser(DataUserType.DATE);

        PatientType patientType = selectPatientType();

        Owner owner = registerOwner();

        Patient newPatient = new Patient(name, breed, owner, isVaccinated, date, patientType);

        patients.add(newPatient);

        utility.displayData("Patient created successfully. The ID assigned is: "
                +  newPatient.getClinicNumber());

    }

    private PatientType selectPatientType(){

        PatientType patientType = null;

        utility.displayData("Select patient type, Enter 1 for Cat or 2 for Dog:");

        do {
            option = (Integer) utility.getDataUser(DataUserType.INTEGER);
            switch (option){
                case 1 -> patientType = PatientType.CAT;
                case 2 -> patientType = PatientType.DOG;
                default -> utility.displayData("Select a valid option:");
            }
        }while (patientType == null);

        return patientType;
    }

    private Owner registerOwner(){

        utility.displayData("Please enter the data to create the patient´s owner:");

        utility.displayData("Enter DNI:");
        String DNI = (String) utility.getDataUser(DataUserType.TEXT);

        utility.displayData("Enter name:");
        String name = (String) utility.getDataUser(DataUserType.TEXT);

        utility.displayData("Enter surname:");
        String surname = (String) utility.getDataUser(DataUserType.TEXT);

        utility.displayData("Enter cellphone:");
        String cellphone = (String) utility.getDataUser(DataUserType.TEXT);

        utility.displayData("Enter age:");
        int age = (Integer) utility.getDataUser(DataUserType.INTEGER);

        while (age < 18){
            utility.displayData("The patient´s owner needs to be at least 18 years older.");
            utility.displayData("Enter patient owner´s age:");
            age = (Integer) utility.getDataUser(DataUserType.INTEGER);
        }

        return new Owner(DNI, name, surname, cellphone, age);
    }

}
