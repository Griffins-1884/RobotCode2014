package org.usfirst.frc1884.util.input.controllers;

public interface SemanticJoystick {
    public boolean getThumbUpperLeftButton();
    public boolean getThumbMiddleLeftButton();
    public boolean getThumbUpperRightButton();
    public boolean getThumbMiddleRightButton();
    public boolean getThumbLowerButton();
    
    public boolean getTriggerButton();
    public boolean getPinkieButton();
    
    public double getThrottle();
    public double getStickTwist();
    public double getStickX();
    public double getStickY();
}