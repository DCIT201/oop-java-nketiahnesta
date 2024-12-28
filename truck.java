package com.rental;

// Concrete Vehicle Class for Inheritance
class Truck extends Vehicle implements Rentable {
    private final double cargoCapacity;

    public Truck(String vehicleId, String model, double baseRentalRate, double cargoCapacity) {
        super(vehicleId, model, baseRentalRate);
        if (cargoCapacity <= 0) {
            throw new IllegalArgumentException("Cargo capacity must be positive.");
        }
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days + (cargoCapacity * 5.0 * days);
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (!checkAvailability()) {
            throw new IllegalStateException("Truck is not available for rental.");
        }
        setAvailable(false);
        System.out.printf("Truck rented to %s for %d days.%n", customer.getName(), days);
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Truck has been returned.");
    }
}
