package com.rental;

// Interface for Polymorphism
interface Rentable {
    void rent(Customer customer, int days);

    void returnVehicle();
}
