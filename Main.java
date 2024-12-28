package com.rental;

public class Main {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();

        // Add vehicles to the rental agency
        agency.addVehicle(new Car("C001", "Toyota Corolla", 50.0, true));
        agency.addVehicle(new Motorcycle("M001", "BMW M3 COMP", 30.0, false));
        agency.addVehicle(new Truck("T001", "HYUNDAI NLINE", 100.0, 2.5));

        // Create a customer
        Customer customer = new Customer("CU001", "John Doe");

        // Display available vehicles
        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : agency.getAvailableVehicles()) {
            System.out.println(vehicle);
        }

        // Rent a vehicle
        System.out.println("\nRenting a vehicle...");
        agency.processRental(customer, "C001", 3);

        // Display available vehicles after rental
        System.out.println("\nAvailable Vehicles After Rental:");
        for (Vehicle vehicle : agency.getAvailableVehicles()) {
            System.out.println(vehicle);
        }

        // Return the vehicle
        System.out.println("\nReturning the vehicle...");
        agency.returnVehicle("C001");

        // Display available vehicles after returning
        System.out.println("\nAvailable Vehicles After Returning:");
        for (Vehicle vehicle : agency.getAvailableVehicles()) {
            System.out.println(vehicle);
        }
    }
}
