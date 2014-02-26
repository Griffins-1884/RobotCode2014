package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.Shooter;

public class ShootShooter {
    
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
        Shooter.setGoalPoint(1.0);
    }
    private static void internalRun() {
        if(Shooter.isAtTarget()) {
            state = FINISHING;
        }
    }
    private static void internalNotRun() {
    }
    private static void internalFinish() {
    }
    
}
