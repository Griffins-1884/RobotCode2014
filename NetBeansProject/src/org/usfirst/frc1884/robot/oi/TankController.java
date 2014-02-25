package org.usfirst.frc1884.robot.oi;

import org.usfirst.frc1884.util.input.controllers.PS3Controller;

public class TankController {
    private static PS3Controller controller = new PS3Controller(1);
    public static void poll() {
        double forward = (controller.getLeftY() + controller.getRightY()) / 2;
        OI.setAnalogValue(OI.DRIVE_FORWARD, forward * forward * forward);
        
        double counterclockwise = (-controller.getLeftY() + controller.getRightY()) / 2;
        OI.setAnalogValue(OI.DRIVE_COUNTERCLOCKWISE, counterclockwise * counterclockwise * counterclockwise);
        
        OI.setBooleanValue(OI.FEEDER_EXTEND, controller.getRightStick());
        OI.setBooleanValue(OI.FEEDER_INTAKE, controller.getLeftUpperTrigger());
        OI.setBooleanValue(OI.FEEDER_OUTTAKE, controller.getRightUpperTrigger());
        OI.setBooleanValue(OI.SHOOTER_FIRE, controller.getRightLowerTrigger());
        OI.setBooleanValue(OI.SHOOTER_RELOAD, controller.getLeftLowerTrigger());
        OI.setBooleanValue(OI.SWITCH_GEAR, controller.getLeftStick());
    }
}