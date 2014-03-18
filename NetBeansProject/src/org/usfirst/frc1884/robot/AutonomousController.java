package org.usfirst.frc1884.robot;

import org.usfirst.frc1884.robot.subsystems.DriveTrain;
import org.usfirst.frc1884.robot.subsystems.Shooter;

public class AutonomousController {
    public static void init() {
        DriveTrain.instance.startCompressor();
        timeStarted = System.currentTimeMillis();
    }
    private static long timeStarted;
    public static void periodic() {
        long timeSinceStart = System.currentTimeMillis() - timeStarted;
        if(timeSinceStart <= 5000) {
            DriveTrain.instance.setLeftSidePower(1.0);
            DriveTrain.instance.setRightSidePower(-1.0);
        } else {
            DriveTrain.instance.setLeftSidePower(0.0);
            DriveTrain.instance.setRightSidePower(0.0);
        }
        
        if(timeSinceStart >= 5000 && timeSinceStart <= 5500) {
            Shooter.instance.setMotorPower(-1.0);
        } else {
            Shooter.instance.setMotorPower(0.0);
        }
    }
}