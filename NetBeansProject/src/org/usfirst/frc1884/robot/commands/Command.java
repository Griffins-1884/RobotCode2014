package org.usfirst.frc1884.robot.commands;

public abstract class Command {
    public static final byte NOT_RUNNING = -1, STARTING = 0, RUNNING = 1, FINISHING = 2;
    
    byte state = NOT_RUNNING;
    public void execute() {
        if(state == STARTING) {
            state = RUNNING;
            internalStart();
        }
        if(state == RUNNING) {
            internalRun();
        }
        if(state == FINISHING) {
            internalFinish();
            state = NOT_RUNNING;
        }
        if(state == NOT_RUNNING) {
            internalNotRun();
        }
    }
    public void start() {
        state = STARTING;
    }
    public void finish() {
        state = FINISHING;
    }
    abstract void internalStart();
    abstract void internalRun();
    abstract void internalFinish();
    abstract void internalNotRun();
}