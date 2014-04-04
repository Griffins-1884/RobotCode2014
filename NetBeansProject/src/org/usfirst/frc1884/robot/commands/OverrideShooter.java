package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.Shooter;

public class OverrideShooter {
    public static OverrideShooter instance;
    private double motorValue;
    private boolean isPIDEnabled;
    
    static {
        instance = new OverrideShooter();
    }
    
    public void enablePID() {
        Shooter.instance.enablePID();
        isPIDEnabled = true;
    }
    
    public void disablePID() {
        Shooter.instance.disablePID();
        isPIDEnabled = false;
    }
    
    public boolean isPIDEnabled() {
        return Shooter.instance.isPIDEnabled();
    }
    
    public void setMotorValue(double value) {
        motorValue = value;
        Shooter.instance.setMotorPower(motorValue);
    }
    
    public double getMotorValue() {
        return motorValue;
    }

}