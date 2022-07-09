package com.sofka.ui;

import com.sofka.medicine.MeasurementUnit;
import com.sofka.medicine.Medicine;
import com.sofka.medicine.Presentation;
import com.sofka.medicine.Usage;
import com.sofka.util.Utility;
import java.util.ArrayList;
import java.util.List;

public class UIMedicine {

    private Utility utility = new Utility();
    List<Medicine> medicines = new ArrayList<>();

    public List<Medicine> medicineMenu(List<Medicine> medicinesSanipet){

        medicines = medicinesSanipet;

        utility.displayData("Medicines stock:");
        medicines.forEach(Medicine::displayMedicine);

        return medicines;
    }

    public ArrayList<Medicine> createMedicineStock(){

        ArrayList<Medicine> medicinesDefault = new ArrayList<>();

        Medicine medicine1 = new Medicine("Meloxican",
                Presentation.SYRUP, 10, MeasurementUnit.MILLILITERS, Usage.HUMAN, 20, 50);
        Medicine medicine2 = new Medicine("Hemolitan",
                Presentation.PILLS, 20, MeasurementUnit.GRAMS, Usage.HUMAN, 15, 120);
        Medicine medicine3 = new Medicine("Inmunoforz ",
                Presentation.SYRUP, 100, MeasurementUnit.MILLILITERS,
                Usage.VETERINARIAN, 25, 70);
        Medicine medicine4 = new Medicine("Shampoo",
                Presentation.PET_CARE, 20, MeasurementUnit.GRAMS, Usage.VETERINARIAN, 5, 90);
        Medicine medicine5 = new Medicine("Antibiotic pet",
                Presentation.SYRUP, 10, MeasurementUnit.MILLILITERS, Usage.HUMAN, 10, 150);

        medicinesDefault.add(medicine1);
        medicinesDefault.add(medicine2);
        medicinesDefault.add(medicine3);
        medicinesDefault.add(medicine4);
        medicinesDefault.add(medicine5);

        return medicinesDefault;
    }

}
