package com.sofka.medicine;

public class Medicine {

    private String name;
    private Presentation presentation;
    private float quantity;
    private MeasurementUnit measurement;
    private Usage usage;
    private int availableStock;

    public Medicine(String name,
                    Presentation presentation,
                    float quantity,
                    MeasurementUnit measurement,
                    Usage usage,
                    int availableStock)
    {
        this.name = name;
        this.presentation = presentation;
        this.quantity = quantity;
        this.measurement = measurement;
        this.usage = usage;
        this.availableStock = availableStock;
    }
}
