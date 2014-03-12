package org.usfirst.frc1884.robot.commands;

import org.usfirst.frc1884.robot.subsystems.DriveTrain;

public class DriveShiftSwitch extends Command {
    public static final DriveShiftSwitch instance;
    static {
        instance = new DriveShiftSwitch();
        Commands.registerCommand(instance);
    }
    void internalStart() {
        if(DriveTrain.instance.getShifterActualState() == DriveTrain.SHIFTER_SHIFT_HIGH) {
            DriveTrain.instance.setShifterState(DriveTrain.SHIFTER_SHIFT_LOW);
        } else {
            DriveTrain.instance.setShifterState(DriveTrain.SHIFTER_SHIFT_HIGH);
        }
        state = FINISHING;
    }
    void internalRun() {
    }
    void internalNotRun() {
    }
    void internalFinish() {
    }
}