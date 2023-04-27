package com.silalahi.valentinus.parkinglot;

public class Car {
    private String plateNumber;
    private String make;

    public Car(String plateNumber, String make) {
        this.plateNumber = plateNumber;
        this.make = make;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getMake() {
        return make;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNumber='" + plateNumber + '\'' +
                ", make='" + make + '\'' +
                '}';
    }
}
