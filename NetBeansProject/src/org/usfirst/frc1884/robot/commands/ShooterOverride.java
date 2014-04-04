package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.DriveTrain;
import org.usfirst.frc1884.robot.subsystems.Shooter;

public class ShooterOverride {
    private static boolean isLimitSwitchEnabled = true;
    
    public static void setMotorValue(double value) {
        Shooter.instance.setMotorPower(value);
    }
    
    public static void enableLimitSwitch() {
        isLimitSwitchEnabled = true;
    }
    
    public static void disableLimitSwitch() {
        isLimitSwitchEnabled = false;
    }
    
    public static boolean isLimitSwitchEnabled() {
        return isLimitSwitchEnabled();
    }
}