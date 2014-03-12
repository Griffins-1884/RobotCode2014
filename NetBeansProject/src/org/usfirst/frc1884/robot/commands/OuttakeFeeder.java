package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.Intake;

public class OuttakeFeeder extends Command {
    public static final OuttakeFeeder instance;
    static {
        instance = new OuttakeFeeder();
        Commands.registerCommand(instance);
    }
    void internalStart() {
        Intake.instance.setIntakePower(-1.0);
    }
    void internalRun() {
    }
    void internalNotRun() {
    }
    void internalFinish() {
        Intake.instance.setIntakePower(0.0);
    }
}