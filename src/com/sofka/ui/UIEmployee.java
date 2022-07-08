package com.sofka.ui;

import com.sofka.employee.Schedule;
import com.sofka.employee.Stylist;
import com.sofka.employee.Veterinary;
import com.sofka.employee.WorkingDay;

import java.util.ArrayList;

public class UIEmployee {

    public ArrayList<Veterinary> createVeterinaries(){

        ArrayList<Veterinary> veterinaries = new ArrayList<>();

        Veterinary veterinary1 =
                new Veterinary("123456",
                        "Karen",
                        "Gonzalez",
                        "3127896521",
                        35,
                        "cats");

        Veterinary veterinary2 =
                new Veterinary("789654",
                        "Luis",
                        "Arboleda",
                        "3159874120",
                        25,
                        "dogs");
        Veterinary veterinary3 =
                new Veterinary("741852",
                        "Claudia",
                        "Pelaez",
                        "3147895623",
                        31,
                        "cats");

        veterinary1.addSchedule(new Schedule("08:00", "19:00", WorkingDay.MONDAY));
        veterinary1.addSchedule(new Schedule("08:00", "19:00", WorkingDay.TUESDAY));
        veterinary1.addSchedule(new Schedule("08:00", "19:00", WorkingDay.WEDNESDAY));
        veterinary2.addSchedule(new Schedule("08:00", "19:00", WorkingDay.MONDAY));
        veterinary2.addSchedule(new Schedule("08:00", "19:00", WorkingDay.TUESDAY));
        veterinary2.addSchedule(new Schedule("08:00", "19:00", WorkingDay.WEDNESDAY));
        veterinary3.addSchedule(new Schedule("08:00", "19:00", WorkingDay.THURSDAY));
        veterinary3.addSchedule(new Schedule("08:00", "19:00", WorkingDay.FRIDAY));
        veterinary3.addSchedule(new Schedule("09:00", "15:00", WorkingDay.SATURDAY));

        veterinaries.add(veterinary1);
        veterinaries.add(veterinary2);
        veterinaries.add(veterinary3);

        return veterinaries;

    }

    public ArrayList<Stylist> createStylists(){

        ArrayList<Stylist> stylists = new ArrayList<>();

        Stylist stylist1 =
                new Stylist("123789",
                        "Katerina",
                        "Gomez",
                        "3127896523",
                        27);

        Stylist stylist2 =
                new Stylist("789963",
                        "Luisa",
                        "Gonzalez",
                        "3127896522",
                        35);

        stylists.add(stylist1);
        stylists.add(stylist2);
        return stylists;

    }

}
