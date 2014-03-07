package org.usfirst.frc1884.robot.oi;

import org.usfirst.frc1884.util.input.controllers.PS3Controller;
import org.usfirst.frc1884.util.input.controllers.XboxController;

public class SteerController {
    private static XboxController controller = new XboxController(1);
    public static void poll() {
        double forward = controller.getLeftY();
        OI.setAnalogValue(OI.DRIVE_FORWARD, forward * forward * forward);
        
        double counterclockwise = controller.getRightX();
        OI.setAnalogValue(OI.DRIVE_COUNTERCLOCKWISE, counterclockwise * counterclockwise * counterclockwise);
        
//        OI.setBooleanValue(OI.FEEDER_EXTEND, controller.getButtonCross());
//        OI.setBooleanValue(OI.FEEDER_INTAKE, controller.getButtonSquare());
//        OI.setBooleanValue(OI.FEEDER_OUTTAKE, controller.getButtonCircle());
//        OI.setBooleanValue(OI.BLOCKER_EXTEND, controller.getButtonTriangle());
        OI.setBooleanValue(OI.FEEDER_EXTEND, controller.getButtonA());
        OI.setBooleanValue(OI.FEEDER_INTAKE, controller.getButtonX());
        OI.setBooleanValue(OI.FEEDER_OUTTAKE, controller.getButtonB());
        OI.setBooleanValue(OI.BLOCKER_EXTEND, controller.getButtonY());
        OI.setBooleanValue(OI.SHOOTER_FIRE, controller.getRightUpperTrigger());
        OI.setBooleanValue(OI.SHOOTER_RELOAD, controller.getRightLowerTrigger());
        OI.setBooleanValue(OI.SWITCH_GEAR, controller.getLeftStick());
        OI.setBooleanValue(OI.FLIP_DRIVE, controller.getRightStick());
    }
}