package com.sofka.employee;

import java.time.LocalTime;

public class Schedule {

    protected LocalTime startTime;
    protected LocalTime endTime;
    protected WorkingDay workingDay;

    public Schedule(String startTime, String endTime, WorkingDay workingDay) {
        this.startTime = LocalTime.parse(startTime);
        this.endTime = LocalTime.parse(endTime);
        this.workingDay = workingDay;
    }
}
