package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.oi.OI;
import org.usfirst.frc1884.robot.subsystems.DriveTrain;

public class TeleopDrive extends Command {
    public static final TeleopDrive instance;
    static {
        instance = new TeleopDrive();
        Commands.registerCommand(instance);
    }
    void internalStart() {
    }
    void internalRun() {
        double forward = OI.getAnalogValue(OI.DRIVE_FORWARD) * forwardMultiplier,
               counterclockwise = OI.getAnalogValue(OI.DRIVE_COUNTERCLOCKWISE);
        double leftValue = forward - counterclockwise,
               rightValue = -forward - counterclockwise;
        
        DriveTrain.instance.setLeftSidePower(Math.max(Math.min(leftValue, 1.0), -1.0));
        DriveTrain.instance.setRightSidePower(Math.max(Math.min(rightValue, 1.0), -1.0));
        
        if(Math.abs(leftValue) + Math.abs(rightValue) > 1) {
            DriveTrain.instance.stopCompressor();
        } else {
            DriveTrain.instance.startCompressor();
        }
    }
    int forwardMultiplier = 1;
    public void toggleFlipDrive() {
        forwardMultiplier *= -1;
    }
    public void flipDrive(boolean isFlipped) {
        forwardMultiplier = (isFlipped) ? -1 : 1;
    }
    void internalNotRun() {
    }
    void internalFinish() {
        DriveTrain.instance.setLeftSidePower(0.0);
        DriveTrain.instance.setRightSidePower(0.0);
    }
}