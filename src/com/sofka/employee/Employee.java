package com.sofka.employee;

import com.sofka.entities.Person;
import java.util.List;

public abstract class Employee extends Person {

    protected List<Schedule> schedules;

    public Employee(String DNI, String name, String surname, String cellphone, int age) {
        super(DNI, name, surname, cellphone, age);
    }

    public void addSchedule(Schedule schedule){
        this.schedules.add(schedule);
    }
}
