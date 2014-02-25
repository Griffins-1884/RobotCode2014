package org.usfirst.frc1884.robot.oi;

import org.usfirst.frc1884.util.input.controllers.PS3Controller;

public class SteerController {
    private static PS3Controller controller = new PS3Controller(1);
    public static void poll() {
        double forward = -controller.getLeftY();
        OI.setAnalogValue(OI.DRIVE_FORWARD, forward * forward * forward);
        
        double counterclockwise = controller.getRightX();
        OI.setAnalogValue(OI.DRIVE_COUNTERCLOCKWISE, counterclockwise * counterclockwise * counterclockwise);
        
        OI.setBooleanValue(OI.FEEDER_EXTEND, controller.getButtonCross());
        OI.setBooleanValue(OI.FEEDER_INTAKE, controller.getButtonSquare());
        OI.setBooleanValue(OI.FEEDER_OUTTAKE, controller.getButtonCircle());
        OI.setBooleanValue(OI.BLOCKER_EXTEND, controller.getButtonTriangle());
        OI.setBooleanValue(OI.SHOOTER_FIRE, controller.getRightUpperTrigger());
        OI.setBooleanValue(OI.SHOOTER_RELOAD, controller.getRightLowerTrigger());
        OI.setBooleanValue(OI.SWITCH_GEAR, controller.getLeftStick());
    }
}