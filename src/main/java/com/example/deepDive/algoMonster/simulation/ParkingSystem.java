package com.example.deepDive.algoMonster.simulation;

public class ParkingSystem {

    private final int[] carSpotsAvailable;

    public ParkingSystem(int big, int medium, int small) {
        carSpotsAvailable = new int[]{0, big, medium, small};
    }

    public boolean addCar(int carType){
        if(carSpotsAvailable[carType] == 0){
            return false;
        }
        --carSpotsAvailable[carType];
        return true;
    }

    public static void main(String[] args){
        ParkingSystem parkingSystem = new ParkingSystem(1, 2, 3);
        System.out.println("car is parked : "+parkingSystem.addCar(1));
        System.out.println("car is parked : "+parkingSystem.addCar(2));
        System.out.println("car is parked : "+parkingSystem.addCar(2));
        System.out.println("car is parked : "+parkingSystem.addCar(2));
        System.out.println("car is parked : "+parkingSystem.addCar(3));
        System.out.println("car is parked : "+parkingSystem.addCar(3));
        System.out.println("car is parked : "+parkingSystem.addCar(3));
        System.out.println("car is parked : "+parkingSystem.addCar(3));
    }
}
