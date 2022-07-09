package com.sofka.ui;

import com.sofka.appointment.Appointment;
import com.sofka.appointment.Status;
import com.sofka.medicine.Medicine;
import com.sofka.util.DataUserType;
import com.sofka.util.Utility;

import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Optional;

public class UIBilling {

    final double IVA = 0.19;
    private Utility utility = new Utility();
    private Integer option = 0;
    private List<Medicine> medicines;
    private List<Appointment> appointments;
    private UIAppointment uiAppointment = new UIAppointment();

    public List<Medicine> uiBilling (List<Medicine> medicinesSanipet,
                           List<Appointment> appointmentsSanipet){

        medicines = medicinesSanipet;
        appointments = appointmentsSanipet;

        do {
            utility.displayData("1. Create new bill");
            utility.displayData("0. Return to main menu");
            option = (Integer) utility.getDataUser(DataUserType.INTEGER);
            options(option);
        }while (option != 0);

        return medicines;

    }

    private void options (int option) {

        utility.displayData("-------------------------------------------------------------------------------");

        switch (option) {
            case 1 -> {
                double subTotal = createBill();
                double taxes = subTotal * IVA;
                double total = subTotal + taxes;
                utility.displayData("Bill created successfully, this is your resume: \n"
                + "Subtotal = \n" + subTotal + "Taxes = \n" + taxes + "Total to pay = " + total);
            }
            case 0 -> utility.displayData("You will be redirect to main menu.");
            default -> utility.displayData("Enter a valid option.");
        }

        utility.displayData("-------------------------------------------------------------------------------");
    }

    private Double createBill(){

        double billValue = 0;

        Optional<Appointment> optionalAppointment = uiAppointment.getAppointment(appointments);

        if (optionalAppointment.isEmpty()){
            utility.displayData("The Appointment enter do not exist.");
            return billValue;
        }

        Appointment appointmentBill = optionalAppointment.get();

        if (appointmentBill.getStatus().equals(Status.FINISHED)){
            billValue = 200;
            billValue += billMedicines();
        }else {
            utility.displayData("The appointment is not finished, you can not do the billing yet");
        }

        return billValue;

    }

    private double billMedicines(){

        boolean option = false;
        double subTotal = 0;


        do {
            if (addMedicine()){
                subTotal += billMedicine();
                utility.displayData("Do you want to add more medicines? Press 1 to continue or 0 to finish bill");
                option = (boolean) utility.getDataUser(DataUserType.BOOLEAN);
            }
        }while (!option);

        return subTotal;
    }

    private boolean addMedicine(){
        utility.displayData("Do you want to add medicines to the bill? Enter 1 for yes and 0 for not:");
        return (boolean) utility.getDataUser(DataUserType.BOOLEAN);
    }

    private int billMedicine(){

        int value = 0;

        utility.displayData("Enter the name of the medicine to add:");
        String name = (String) utility.getDataUser(DataUserType.TEXT);

        Optional<Medicine> medicineOptional = medicines.stream().filter(item -> item.getName().equals(name)).findFirst();

        if (medicineOptional.isEmpty()){
            utility.displayData("The medicine enter do not exist.");
            return value;
        }

        Medicine medicine = medicineOptional.get();

        utility.displayData("Available stock of medicine: " + medicine.getName()
                + "is " + medicine.getAvailableStock() + "units");
        utility.displayData("Please enter the quantity to bill:");
        int quantity = (int) utility.getDataUser(DataUserType.INTEGER);

        if (quantity <= medicine.getAvailableStock()){
            medicine.setAvailableStock(medicine.getAvailableStock() - quantity);
            value = medicine.getPrice() * quantity;
            utility.displayData("Product added successfully");
        }else {
            utility.displayData("The quantity is higher that the available stock.");
        }

        return value;

    }

}
