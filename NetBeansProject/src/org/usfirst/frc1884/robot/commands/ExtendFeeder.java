package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.Intake;

public class ExtendFeeder extends Command {
    public static final ExtendFeeder instance;
    static {
        instance = new ExtendFeeder();
        Commands.registerCommand(instance);
    }
    void internalStart() {
        Intake.instance.setExtenderState(Intake.EXTENDER_EXTEND);
        state = FINISHING;
    }
    void internalRun() {
    }
    void internalNotRun() {
    }
    void internalFinish() {
    }
}