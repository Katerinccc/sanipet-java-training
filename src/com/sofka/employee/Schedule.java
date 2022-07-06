package com.sofka.employee;

import java.time.LocalTime;

public class Schedule {

    protected LocalTime startTime;
    protected LocalTime endTime;
    protected WorkingDay workingDay;

    public Schedule(LocalTime startTime, LocalTime endTime, WorkingDay workingDay) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.workingDay = workingDay;
    }
}
