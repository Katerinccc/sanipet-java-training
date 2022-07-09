package com.sofka.medicine;

import com.sofka.util.Utility;

public class Medicine {

    private String name;
    private Presentation presentation;
    private float quantity;
    private MeasurementUnit measurement;
    private Usage usage;
    private int availableStock;
    private int price;

    private Utility utility = new Utility();

    public Medicine(String name,
                    Presentation presentation,
                    float quantity,
                    MeasurementUnit measurement,
                    Usage usage,
                    int availableStock,
                    int price)
    {
        this.name = name;
        this.presentation = presentation;
        this.quantity = quantity;
        this.measurement = measurement;
        this.usage = usage;
        this.availableStock = availableStock;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

    public int getPrice() {
        return price;
    }

    public void displayMedicine(){
        utility.displayData("Name: "+ this.name
                + " | Presentation:" + this.presentation.toString().toLowerCase()
                + " | Quantity: "+ this.quantity
                + " | Measurement unit: "+ this.measurement.toString().toLowerCase()
                + " | Usage: "+ this.usage.toString().toLowerCase()
                + " | Available stock: " + this.availableStock
                + " | Price: "+ this.price);
    }

}
