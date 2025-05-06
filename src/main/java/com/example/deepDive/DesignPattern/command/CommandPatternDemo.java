package com.example.deepDive.DesignPattern.command;

public class CommandPatternDemo {
    public static void main(String[] args) {
        Light livingRoom = new Light("living room");
        Light kitchenRoom = new Light("kitchen room");

        Command livingLightOff = new LightOffCommand(livingRoom);
        Command livingLightOn = new LightOnCommand(livingRoom);

        Command kitchenOff = new LightOffCommand(kitchenRoom);
        Command kitchenOn = new LightOnCommand(kitchenRoom);

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(livingLightOn);
        remoteControl.pressButton();
        remoteControl.setCommand(kitchenOn);
        remoteControl.pressButton();
        remoteControl.setCommand(livingLightOff);
        remoteControl.pressButton();
        remoteControl.setCommand(kitchenOff);
        remoteControl.pressButton();
    }
}