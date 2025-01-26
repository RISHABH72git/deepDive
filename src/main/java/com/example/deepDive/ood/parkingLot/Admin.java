package com.example.deepDive.ood.parkingLot;

import com.example.deepDive.ood.Account;

public class Admin extends Account {

    public boolean addParkingFloor(ParkingFloor floor){
        return true;
    }
    public boolean addParkingSpot(String floorName, ParkingSpot spot){
        return true;
    }
}
