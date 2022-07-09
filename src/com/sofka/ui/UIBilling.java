package com.sofka.ui;

import com.sofka.appointment.Appointment;
import com.sofka.appointment.Status;
import com.sofka.medicine.Medicine;
import com.sofka.util.DataUserType;
import com.sofka.util.Utility;
import java.util.List;
import java.util.Optional;

public class UIBilling {

    final double IVA = 0.19;
    private Utility utility = new Utility();
    private Integer option = 0;
    private List<Medicine> medicines;
    private List<Appointment> appointments;
    private UIAppointment uiAppointment = new UIAppointment();
    private String billResponsible = null;

    public List<Medicine> billingMenu (List<Medicine> medicinesSanipet,
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
                double billValue = createBill();
                if (billValue == 0){
                    break;
                }
                displayBill(billValue);
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

        billResponsible = appointmentBill.getResponsible();

        if (appointmentBill.getStatus().equals(Status.FINISHED)){
            billValue = 200;
            billValue += billMedicines();
        }else {
            utility.displayData("The appointment´status is not finished, " +
                    "you can not billing this appointment.");
        }

        return billValue;

    }

    private void displayBill(double billValue) {
        double taxes = billValue * IVA;
        double total = billValue + taxes;
        utility.displayData("Bill created successfully, this is your resume: "
                + "\nSANIPET CARE CENTER NIT: 811.013.347-7 "
                + "\nResponsible: " + billResponsible
                + "\nSubtotal = " + billValue
                + "\nTaxes = " + taxes
                + "\nTotal to pay = " + total);
    }

    private double billMedicines(){

        double subTotal = 0;

        do {
            if (addMedicine()){
                subTotal += billMedicine();
            }
        }while (addMedicine());

        return subTotal;
    }

    private boolean addMedicine(){
        utility.displayData("Do you want to add medicines to the bill? Enter 1 for yes and 0 for not:");
        return (boolean) utility.getDataUser(DataUserType.BOOLEAN);
    }

    private int billMedicine(){

        Medicine medicine = getMedicine();

        utility.displayData("Available stock of medicine: " + medicine.getName()
                + " is " + medicine.getAvailableStock() + " units.");
        utility.displayData("Please enter the quantity to bill:");
        int quantity = (int) utility.getDataUser(DataUserType.INTEGER);

        return getBillValue(medicine, quantity);

    }

    private int getBillValue(Medicine medicine, int quantity) {
        int value = 0;

        if (quantity <= medicine.getAvailableStock()) {
            medicine.setAvailableStock(medicine.getAvailableStock() - quantity);
            value = medicine.getPrice() * quantity;
            utility.displayData("Product added successfully.");
        }else {
            utility.displayData("The quantity is higher than the available stock.");
        }

        return value;
    }

    private Medicine getMedicine() {
        utility.displayData("Enter the name of the medicine to add:");
        String name = (String) utility.getDataUser(DataUserType.TEXT);

        Optional<Medicine> medicineOptional = medicines.stream()
                .filter(item -> item.getName().equals(name)).findFirst();

        if (medicineOptional.isEmpty()){
            utility.displayData("The medicine enter do not exist.");
            return null;
        }

        return medicineOptional.get();
    }

}
