package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.Intake;

public class RetractFeeder extends Command {
    public static final RetractFeeder instance;
    static {
        instance = new RetractFeeder();
        Commands.registerCommand(instance);
    }
    void internalStart() {
        Intake.instance.setExtenderState(Intake.EXTENDER_RETRACT);
        state = FINISHING;
    }
    void internalRun() {
    }
    void internalNotRun() {
    }
    void internalFinish() {
    }
}