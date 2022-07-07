package com.sofka.ui;

import com.sofka.util.Utility;

public class UIMenu {

    private Utility utility = new Utility();

    private void displayMenu(){

        utility.displayData("Welcome to Sanipet - Veterinary care center");
        utility.displayData("1. Register patient");
        utility.displayData("2. Create Appointments");
        utility.displayData("3. Billings");
        utility.displayData("4. Medicine stock");
        utility.displayData("0. Exit the project");

    }

}
