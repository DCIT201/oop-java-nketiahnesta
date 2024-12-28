package com.rental;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Supporting Class for Composition
class Customer {
    private final String customerId;
    private final String name;
    private final List<Vehicle> rentalHistory;

    public Customer(String customerId, String name) {
        if (customerId == null || customerId.isEmpty() || name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid customer details.");
        }
        this.customerId = customerId;
        this.name = name;
        this.rentalHistory = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public List<Vehicle> getRentalHistory() {
        return Collections.unmodifiableList(rentalHistory);
    }

    public void addRental(Vehicle vehicle) {
        rentalHistory.add(vehicle);
    }
}
