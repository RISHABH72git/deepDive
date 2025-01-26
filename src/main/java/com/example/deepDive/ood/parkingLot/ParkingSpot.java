package com.example.deepDive.ood.parkingLot;

public abstract class ParkingSpot {
    private String number;
    private boolean free;
    private Vehicle vehicle;
    private final ParkingSpotType type;

    public boolean IsFree(){
        return this.free;
    }

    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
        return true;
    }

    public boolean removeVehicle() {
        this.vehicle = null;
        free = true;
        return true;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
