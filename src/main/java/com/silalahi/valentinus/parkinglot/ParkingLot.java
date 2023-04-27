package com.silalahi.valentinus.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private Map<Integer, Car> parkedCars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkedCars = new HashMap<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumParkedCars() {
        return parkedCars.size();
    }

    public boolean parkCar(Car car) {
        if (getNumParkedCars() == capacity) {
            return false; // parking lot is full
        }
        int slot = getNextAvailableSlot();
        parkedCars.put(slot, car);
        return true;
    }

    public boolean unparkCar(int slot) {
        if (!parkedCars.containsKey(slot)) {
            return false; // no car found at the given slot
        }
        parkedCars.remove(slot);
        return true;
    }

    public List<Car> getParkedCars() {
        return new ArrayList<>(parkedCars.values());
    }

    private int getNextAvailableSlot() {
        for (int i = 1; i <= capacity; i++) {
            if (!parkedCars.containsKey(i)) {
                return i;
            }
        }
        return -1; // no available slot found
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3);
        Car car1 = new Car("ABC-1234", "Toyota");
        Car car2 = new Car("DEF-5678", "Honda");
        Car car3 = new Car("GHI-9012", "Ford");
        Car car4 = new Car("JKL-3456", "Chevrolet");
        System.out.println(parkingLot.parkCar(car1)); // true
        System.out.println(parkingLot.parkCar(car2)); // true
        System.out.println(parkingLot.parkCar(car3)); // true
        System.out.println(parkingLot.parkCar(car4)); // false (parking lot is full)
        System.out.println(parkingLot.unparkCar(2)); // true
        System.out.println(parkingLot.unparkCar(2)); // false (no car found at slot 2)
        System.out.println(parkingLot.getParkedCars()); // [Car{plateNumber='ABC-1234', make='Toyota'}, Car{plateNumber='GHI-9012', make='Ford'}]
    }
}
