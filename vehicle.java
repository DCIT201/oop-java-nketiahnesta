package com.rental;

// Abstract Class for Abstraction
abstract class Vehicle {
    private final String vehicleId;
    private final String model;
    private final double baseRentalRate;
    private boolean isAvailable;

    protected Vehicle(String vehicleId, String model, double baseRentalRate) {
        if (vehicleId == null || vehicleId.isEmpty() || model == null || model.isEmpty() || baseRentalRate <= 0) {
            throw new IllegalArgumentException("Invalid vehicle details");
        }
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRentalRate() {
        return baseRentalRate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public abstract double calculateRentalCost(int days);

    public abstract boolean checkAvailability();

    @Override
    public String toString() {
        return String.format("Vehicle[ID=%s, Model=%s, Rate=%.2f, Available=%b]", vehicleId, model, baseRentalRate, isAvailable);
    }
}
