package com.sofka.employee;

public class Veterinary extends Employee {

    private String speciality;
    public Veterinary(String DNI, String name, String surname, String cellphone, int age, String speciality) {
        super(DNI, name, surname, cellphone, age);
        this.speciality = speciality;
    }

}
