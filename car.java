package com.rental;

// Concrete Vehicle Class for Inheritance
class Car extends Vehicle implements Rentable {
    private final boolean hasGPS;

    public Car(String vehicleId, String model, double baseRentalRate, boolean hasGPS) {
        super(vehicleId, model, baseRentalRate);
        this.hasGPS = hasGPS;
    }

    public boolean hasGPS() {
        return hasGPS;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (hasGPS) {
            cost += 10.0 * days;
        }
        return cost;
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (!checkAvailability()) {
            throw new IllegalStateException("Car is not available for rental.");
        }
        setAvailable(false);
        System.out.printf("Car rented to %s for %d days.%n", customer.getName(), days);
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Car has been returned.");
    }
}
