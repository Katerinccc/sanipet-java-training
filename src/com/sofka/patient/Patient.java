package com.sofka.patient;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Patient {

    protected String clinicNumber;
    protected String name;
    protected String surname;
    protected String breed;
    protected Owner owner;
    protected boolean isVaccinated;
    protected Date deparasitizationDate;

    public void generateClinicalNumber (){
        int randomNum = ThreadLocalRandom.current().nextInt( 1 , 999999 + 1 );
        this.clinicNumber = String.valueOf(randomNum);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public Date getDeparasitizationDate() {
        return deparasitizationDate;
    }

    public void setDeparasitizationDate(Date deparasitizationDate) {
        this.deparasitizationDate = deparasitizationDate;
    }
}
