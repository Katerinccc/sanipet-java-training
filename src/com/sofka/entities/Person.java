package com.sofka.entities;

public abstract class Person {

    protected String DNI;
    protected String name;
    protected String surname;
    protected String cellphone;
    protected int age;

    public Person(String DNI, String name, String surname, String cellphone, int age) {
        this.DNI = DNI;
        this.name = name;
        this.surname = surname;
        this.cellphone = cellphone;
        this.age = age;
    }

    public String getDNI() {
        return DNI;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
