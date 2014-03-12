package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.DriveTrain;

public class DriveShiftLow extends Command {
    public static final DriveShiftLow instance;
    static {
        instance = new DriveShiftLow();
        Commands.registerCommand(instance);
    }
    void internalStart() {
        DriveTrain.instance.setShifterState(DriveTrain.SHIFTER_SHIFT_LOW);
        state = FINISHING;
    }
    void internalRun() {
    }
    void internalNotRun() {
    }
    void internalFinish() {
    }
}