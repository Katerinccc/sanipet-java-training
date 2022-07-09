package com.sofka.ui;

import com.sofka.appointment.Appointment;
import com.sofka.employee.Stylist;
import com.sofka.employee.Veterinary;
import com.sofka.medicine.Medicine;
import com.sofka.patient.Patient;
import com.sofka.util.DataUserType;
import com.sofka.util.Utility;

import java.util.ArrayList;
import java.util.List;

public class UIMenu {

    private Utility utility = new Utility();
    private Integer option = 0;
    private UIEmployee uiEmployee = new UIEmployee();
    private ArrayList<Patient> patientsSanipet = new ArrayList<>();
    private ArrayList<Appointment> appointmentsSanipet = new ArrayList<>();

    public void mainMenu(){

        ArrayList<Veterinary> veterinariesSanipet = uiEmployee.createVeterinaries();
        ArrayList<Stylist> stylistsSanipet = uiEmployee.createStylists();

        do {
            utility.displayData("Welcome to Sanipet - Veterinary care center");
            utility.displayData("1. Register patient");
            utility.displayData("2. Create Appointment");
            utility.displayData("3. Billings");
            utility.displayData("4. Medicine stock");
            utility.displayData("0. Exit the system");
            option = (Integer) utility.getDataUser(DataUserType.INTEGER);
            options(option);
        }while (option != 0);

    }

    private void options (int option){

        utility.displayData("-------------------------------------------------------------------------------");

        switch (option) {
            case 1 -> {
                UIPatient uipatient = new UIPatient();
                patientsSanipet.addAll(uipatient.patientMenu());
            }
            case 2 -> {
                UIAppointment uiAppointment = new UIAppointment();
                List<Appointment> appointmentsUpdate =
                        uiAppointment.appointmentMenu(patientsSanipet, appointmentsSanipet);
                appointmentsSanipet.addAll(appointmentsUpdate);
            }
            case 3 -> utility.displayData("The option is not available yet.");
            case 4 -> {
                UIMedicine uiMedicine = new UIMedicine();
                uiMedicine.medicineMenu();
            }
            case 0 -> utility.displayData("You have exit the system successfully.");
            default -> utility.displayData("Enter a valid option.");
        }

        utility.displayData("-------------------------------------------------------------------------------");

    }

}
