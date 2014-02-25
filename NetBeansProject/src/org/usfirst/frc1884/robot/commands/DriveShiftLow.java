package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.DriveTrain;

public class DriveShiftLow {
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
        DriveTrain.setShifterState(DriveTrain.SHIFTER_SHIFT_LOW);
        pistonIsOn = true;
        state = FINISHING;
    }
    private static void internalRun() {
    }
    private static boolean pistonIsOn = false;
    private static void internalNotRun() {
        if(pistonIsOn && System.currentTimeMillis() > timeToTurnOffPiston) {
            pistonIsOn = false;
            DriveTrain.setShifterState(DriveTrain.SHIFTER_SHIFT_OFF);
        }
    }
    private static long timeToTurnOffPiston = Long.MAX_VALUE;
    private static void internalFinish() {
        timeToTurnOffPiston = System.currentTimeMillis() + DriveTrain.MILLISECONDS_TO_SHIFT;
    }
}