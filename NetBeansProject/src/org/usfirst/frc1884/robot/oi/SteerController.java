package org.usfirst.frc1884.robot.oi;

import org.usfirst.frc1884.util.input.controllers.Gamepad;
import org.usfirst.frc1884.util.input.controllers.PS3Controller;
import org.usfirst.frc1884.util.input.controllers.XboxController;

public class SteerController {
    private static Gamepad controller = new XboxController(1);
    public static void poll() {
        double forward = controller.getLeftStickY();
        OI.setAnalogValue(OI.DRIVE_FORWARD, forward * forward * forward);
        
        double counterclockwise = controller.getRightStickX();
        OI.setAnalogValue(OI.DRIVE_COUNTERCLOCKWISE, counterclockwise * counterclockwise * counterclockwise);
        
        OI.setBooleanValue(OI.FEEDER_EXTEND, controller.getActionBottom());
        OI.setBooleanValue(OI.FEEDER_INTAKE, controller.getActionLeft());
        OI.setBooleanValue(OI.FEEDER_OUTTAKE, controller.getActionRight());
        OI.setBooleanValue(OI.SHOOTER_FIRE, controller.getRightUpperTrigger());
        OI.setBooleanValue(OI.SHOOTER_RELOAD, controller.getRightLowerTrigger());
        OI.setBooleanValue(OI.SWITCH_GEAR, controller.getLeftStickButton());
        OI.setBooleanValue(OI.FLIP_DRIVE, controller.getRightStickButton());
        OI.setBooleanValue(OI.KEEP_DRIVE_REVERSED, controller.getLeftUpperTrigger());
        OI.setBooleanValue(OI.LOW_GEAR, controller.getLeftLowerTrigger());
    }
}