package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.DriveTrain;

public class DriveShiftHigh extends Command {
    public static final DriveShiftHigh instance;
    static {
        instance = new DriveShiftHigh();
        Commands.registerCommand(instance);
    }
    private DriveShiftHigh() {}
    void internalStart() {
        DriveTrain.instance.setShifterState(DriveTrain.SHIFTER_SHIFT_HIGH);
        state = FINISHING;
    }
    void internalRun() {
    }
    void internalNotRun() {
    }
    void internalFinish() {
    }
}