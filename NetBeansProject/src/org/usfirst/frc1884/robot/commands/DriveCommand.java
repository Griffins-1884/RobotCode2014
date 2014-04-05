package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.DriveTrain;

public class DriveCommand {
    public static void drivePolar(double forward, double counterclockwise) {
        double leftValue = forward - counterclockwise,
               rightValue = -forward - counterclockwise;
        driveTank(leftValue, rightValue);
    }
    public static void driveTank(double leftValue, double rightValue) {
        DriveTrain.instance.setLeftSidePower(Math.max(Math.min(leftValue, 1.0), -1.0));
        DriveTrain.instance.setRightSidePower(Math.max(Math.min(rightValue, 1.0), -1.0));
    }
}