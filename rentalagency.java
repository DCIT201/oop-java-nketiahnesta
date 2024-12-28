package com.rental;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class RentalAgency {
    private final List<Vehicle> fleet;

    public RentalAgency() {
        this.fleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : fleet) {
            if (vehicle.checkAvailability()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    public void processRental(Customer customer, String vehicleId, int days) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                if (vehicle.checkAvailability()) {
                    ((Rentable) vehicle).rent(customer, days);
                    customer.addRental(vehicle);
                    return;
                } else {
                    throw new IllegalStateException("Vehicle is not available.");
                }
            }
        }
        throw new NoSuchElementException("Vehicle not found.");
    }

    // Correct implementation of returnVehicle
    public void returnVehicle(String vehicleId) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equals(vehicleId) && !vehicle.isAvailable()) {
                ((Rentable) vehicle).returnVehicle();
                return;
            }
        }
        throw new NoSuchElementException("Vehicle not found or not rented.");
    }
}
