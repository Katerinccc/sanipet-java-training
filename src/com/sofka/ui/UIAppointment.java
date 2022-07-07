package com.sofka.ui;

import com.sofka.util.Utility;

public class UIAppointment {

    private Utility utility = new Utility();

    private void appointmentMenu() {

        utility.displayData("2.1 By day");
        utility.displayData("2.2 By doctor");
        utility.displayData("2.3 By stylist");
    }
}
