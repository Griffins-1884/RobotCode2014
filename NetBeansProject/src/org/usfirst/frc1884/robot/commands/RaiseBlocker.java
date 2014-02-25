package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.Blocker;

public class RaiseBlocker {
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
        }
    }
    public static void start() {
        state = STARTING;
    }
    public static void finish() {
        state = FINISHING;
    }
    private static void internalStart() {
        Blocker.setGoalPoint(1.0);
    }
    private static void internalRun() {
        if(Blocker.isAtTarget()) {
            state = FINISHING;
        }
    }
    private static void internalNotRun() {
    }
    private static void internalFinish() {
        Blocker.setBlockerState(Blocker.BLOCKER_LOCK_LOCK);
    }
}