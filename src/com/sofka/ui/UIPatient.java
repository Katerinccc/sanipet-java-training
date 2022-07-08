package com.sofka.ui;

import com.sofka.patient.Cat;
import com.sofka.util.DataUserType;
import com.sofka.util.Utility;

public class UIPatient {

    private Utility utility = new Utility();
    private Integer option = 0;
    public void patientMenu(){

        do {
            utility.displayData("Select the type of patient you want to register");
            utility.displayData("1. Cat");
            utility.displayData("2. Dog");
            utility.displayData("0. Return to main menu");
            option = (Integer) utility.getDataUser(DataUserType.INTEGER);
            options(option);
        }while (option != 0);

    }

    private void options (int option){

        switch (option){
            case 1 -> {
                Cat cat = new Cat();
                cat.generateClinicalNumber();

            }
        }
    }


}
