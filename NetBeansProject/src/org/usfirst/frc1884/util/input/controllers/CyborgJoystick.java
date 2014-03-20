package org.usfirst.frc1884.util.input.controllers;

public class CyborgJoystick extends edu.wpi.first.wpilibj.Joystick implements SemanticJoystick {

    public CyborgJoystick(int port) {
        super(port);
    }

    public boolean getThumbUpperLeftButton() {
        return this.getRawButton(3);
    }

    public boolean getThumbMiddleLeftButton() {
        return this.getRawButton(5);
    }

    public boolean getThumbUpperRightButton() {
        return this.getRawButton(4);
    }

    public boolean getThumbMiddleRightButton() {
        return this.getRawButton(6);
    }

    public boolean getThumbLowerButton() {
        return this.getRawButton(2);
    }

    public boolean getTriggerButton() {
        return this.getRawButton(1);
    }

    public boolean getPinkieButton() {
        return this.getRawButton(7);
    }

    public double getStickTwist() {
        return this.getRawAxis(6);
    }

    public double getStickX() {
        return this.getRawAxis(1);
    }

    public double getStickY() {
        return this.getRawAxis(2);
    }
    
    public double getThrottle() {
        return this.getRawAxis(3);
    }
    
}