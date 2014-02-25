package org.usfirst.frc1884.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import org.usfirst.frc1884.util.pid.PIDEncoderTalonController;

public class DriveTrain {
    private static Talon leftMotor1, leftMotor2, rightMotor1, rightMotor2;
    
    static {
        leftMotor1 = new Talon(1, 1);
        leftMotor2 = new Talon(1, 2);
        rightMotor1 = new Talon(1, 3);
        rightMotor2 = new Talon(1, 4);
    }
    
    private static double leftSidePower = 0.0, rightSidePower = 0.0;
    
    public static double getLeftSidePower() {
        return leftSidePower;
    }
    public static void setLeftSidePower(double value) {
        leftSidePower = value;
        leftMotor1.set(leftSidePower);
        leftMotor2.set(leftSidePower);
    }
    
    public static double getRightSidePower() {
        return rightSidePower;
    }
    public static void setRightSidePower(double value) {
        rightSidePower = value;
        rightMotor1.set(rightSidePower);
        rightMotor2.set(rightSidePower);
    }

    public static void parameterRefresh() {
    }
}
