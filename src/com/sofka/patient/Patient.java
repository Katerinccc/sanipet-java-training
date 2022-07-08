package com.sofka.patient;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Patient {

    private String clinicNumber;
    private String name;
    private String breed;
    private Owner owner;
    private boolean isVaccinated;
    private LocalDate deparasitizationDate;
    private PatientType patientType;

    public Patient(String name,
                   String breed,
                   Owner owner,
                   boolean isVaccinated,
                   LocalDate deparasitizationDate,
                   PatientType patientType)
    {
        this.name = name;
        this.breed = breed;
        this.owner = owner;
        this.isVaccinated = isVaccinated;
        this.deparasitizationDate = deparasitizationDate;
        this.patientType = patientType;
        this.clinicNumber = generateClinicalNumber();
    }

    private String generateClinicalNumber (){
        int randomNum = ThreadLocalRandom.current().nextInt( 1 , 999999 + 1 );
        return String.valueOf(randomNum);
    }

    public String getClinicNumber() {
        return clinicNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public LocalDate getDeparasitizationDate() {
        return deparasitizationDate;
    }

    public void setDeparasitizationDate(LocalDate deparasitizationDate) {
        this.deparasitizationDate = deparasitizationDate;
    }

    public PatientType getPatientType() {
        return patientType;
    }

    public void setPatientType(PatientType patientType) {
        this.patientType = patientType;
    }
}
