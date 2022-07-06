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

    protected String generateClinicalNumber (){
        int randomNum = ThreadLocalRandom.current().nextInt( 1 , 999999 + 1 );
        return String.valueOf(randomNum);
    }

}
