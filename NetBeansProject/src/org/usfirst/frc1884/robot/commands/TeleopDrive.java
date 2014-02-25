package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.oi.OI;
import org.usfirst.frc1884.robot.subsystems.DriveTrain;

public class TeleopDrive {
    public static final byte NOT_RUNNING = -1, STARTING = 0, RUNNING = 1, FINISHING = 2;
    private static byte state = NOT_RUNNING;
    public static void execute() {
        if(state == STARTING) {
            state = RUNNING;
            internalStart();
        }
        if(state == RUNNING) {
            internalRun();
        }
        if(state == NOT_RUNNING) {
            internalNotRun();
        }
        if(state == FINISHING) {
            internalFinish();
            state = NOT_RUNNING;
        }
    }
    public static void start() {
        state = STARTING;
    }
    public static void finish() {
        state = FINISHING;
    }
    private static void internalStart() {
    }
    private static void internalRun() {
        double forward = OI.getAnalogValue(OI.DRIVE_FORWARD),
               counterclockwise = OI.getAnalogValue(OI.DRIVE_COUNTERCLOCKWISE);
        double leftValue = forward - counterclockwise,
               rightValue = -forward - counterclockwise;
        DriveTrain.setLeftSidePower(Math.max(Math.min(leftValue, 1.0), -1.0));
        DriveTrain.setRightSidePower(Math.max(Math.min(rightValue, 1.0), -1.0));
    }
    private static void internalNotRun() {
    }
    private static void internalFinish() {
        DriveTrain.setLeftSidePower(0.0);
        DriveTrain.setRightSidePower(0.0);
    }
}