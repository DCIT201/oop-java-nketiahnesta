package com.rental;

// Concrete Vehicle Class for Inheritance
class Motorcycle extends Vehicle implements Rentable {
    private final boolean hasSideCar;

    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean hasSideCar) {
        super(vehicleId, model, baseRentalRate);
        this.hasSideCar = hasSideCar;
    }

    public boolean hasSideCar() {
        return hasSideCar;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (hasSideCar) {
            cost += 15.0 * days;
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
            throw new IllegalStateException("Motorcycle is not available for rental.");
        }
        setAvailable(false);
        System.out.printf("Motorcycle rented to %s for %d days.%n", customer.getName(), days);
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Motorcycle has been returned.");
    }
}
