package org.usfirst.frc1884.util.input.controllers;

public interface SemanticGamepad {
    public boolean getDpadUp();
    public boolean getDpadDown();
    public boolean getDpadRight();
    public boolean getDpadLeft();
    public boolean getActionTop();
    public boolean getActionBottom();
    public boolean getActionRight();
    public boolean getActionLeft();
    public boolean getLeftUpperTrigger();
    public boolean getLeftLowerTrigger();
    public boolean getRightUpperTrigger();
    public boolean getRightLowerTrigger();
    public boolean getLeftStickButton();
    public boolean getRightStickButton();
    
    public double getLeftStickX();
    public double getLeftStickY();
    public double getRightStickX();
    public double getRightStickY();
}