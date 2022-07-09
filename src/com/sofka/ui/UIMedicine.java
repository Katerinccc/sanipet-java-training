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

    public List<Medicine> medicineMenu(){

        utility.displayData("Medicines stock:");
        createMedicineStock();
        medicines.forEach(Medicine::displayMedicine);
        return medicines;
    }

    private void createMedicineStock(){

        Medicine medicine1 = new Medicine("Meloxican",
                Presentation.SYRUP, 10, MeasurementUnit.MILLILITERS, Usage.HUMAN, 20);
        Medicine medicine2 = new Medicine("Hemolitan",
                Presentation.PILLS, 20, MeasurementUnit.GRAMS, Usage.HUMAN, 15);
        Medicine medicine3 = new Medicine("Inmunoforz ",
                Presentation.SYRUP, 100, MeasurementUnit.MILLILITERS, Usage.VETERINARIAN, 25);
        Medicine medicine4 = new Medicine("Meloxican",
                Presentation.PET_CARE, 20, MeasurementUnit.GRAMS, Usage.VETERINARIAN, 5);
        Medicine medicine5 = new Medicine("Meloxican",
                Presentation.SYRUP, 10, MeasurementUnit.MILLILITERS, Usage.HUMAN, 10);

        medicines.add(medicine1);
        medicines.add(medicine2);
        medicines.add(medicine3);
        medicines.add(medicine4);
        medicines.add(medicine5);
    }

}
