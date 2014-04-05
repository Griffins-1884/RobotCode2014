package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.DriveTrain;
import org.usfirst.frc1884.robot.subsystems.Intake;

public class IntakeFeeder extends Command {
    public static final IntakeFeeder instance;
    static {
        instance = new IntakeFeeder();
        Commands.registerCommand(instance);
    }
    void internalStart() {
        Intake.instance.setIntakePower(1.0);
    }
    void internalRun() {
    }
    void internalNotRun() {
    }
    void internalFinish() {
        Intake.instance.setIntakePower(0.0);
    }
}