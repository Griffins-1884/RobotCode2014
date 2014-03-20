package org.usfirst.frc1884.robot.oi;

import org.usfirst.frc1884.util.input.controllers.SemanticGamepad;
import org.usfirst.frc1884.util.input.controllers.PS3Controller;

public class TankController {
    private static SemanticGamepad controller = new PS3Controller(1);
    public static void poll() {
        double forward = (controller.getLeftStickY() + controller.getRightStickY()) / 2;
        OI.setAnalogValue(OI.DRIVE_FORWARD, forward * forward * forward);
        
        double counterclockwise = (-controller.getLeftStickY() + controller.getRightStickY()) / 2;
        OI.setAnalogValue(OI.DRIVE_COUNTERCLOCKWISE, counterclockwise * counterclockwise * counterclockwise);
        
        OI.setBooleanValue(OI.FEEDER_EXTEND, controller.getRightStickButton());
        OI.setBooleanValue(OI.FEEDER_INTAKE, controller.getLeftUpperTrigger());
        OI.setBooleanValue(OI.FEEDER_OUTTAKE, controller.getRightUpperTrigger());
        OI.setBooleanValue(OI.SHOOTER_FIRE, controller.getRightLowerTrigger());
        OI.setBooleanValue(OI.SHOOTER_RELOAD, controller.getLeftLowerTrigger());
        OI.setBooleanValue(OI.SWITCH_GEAR, controller.getLeftStickButton());
    }
}