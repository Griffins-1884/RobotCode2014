package org.usfirst.frc1884.robot.oi;

import org.usfirst.frc1884.util.input.controllers.CyborgJoystick;
import org.usfirst.frc1884.util.input.controllers.SemanticGamepad;
import org.usfirst.frc1884.util.input.controllers.SemanticJoystick;
import org.usfirst.frc1884.util.input.controllers.XboxController;

public class SteerController {
    private static SemanticGamepad driverController = new XboxController(1);
    private static SemanticJoystick operatorController = new CyborgJoystick(2);
    public static void poll() {
        /**********************************************************************/
        /*                                Axes                                */
        /**********************************************************************/
        
        double driverControlLevel = 1.0; // If Doug should be able to take over, put: (operatorController.getThrottle() + 1) / 2;
        
        double forward = driverController.getLeftStickY() * driverControlLevel + operatorController.getStickY() * (1 - driverControlLevel);
        OI.setAnalogValue(OI.DRIVE_FORWARD, forward * forward * forward);
        
        double counterclockwise = driverController.getRightStickX() * driverControlLevel + operatorController.getStickX() * (1 - driverControlLevel);
        OI.setAnalogValue(OI.DRIVE_COUNTERCLOCKWISE, counterclockwise * counterclockwise * counterclockwise);
        
        /**********************************************************************/
        /*                               Buttons                              */
        /**********************************************************************/
        
        OI.setBooleanValue(OI.FEEDER_EXTEND, // If the driver should have these controls, uncomment these: driverController.getActionBottom() ||
                                             operatorController.getTriggerButton());
        
        OI.setBooleanValue(OI.FEEDER_INTAKE, //driverController.getActionLeft() ||
                                             operatorController.getThumbMiddleLeftButton());
        
        OI.setBooleanValue(OI.FEEDER_OUTTAKE, //driverController.getActionRight() ||
                                              operatorController.getThumbMiddleRightButton());
        
        OI.setBooleanValue(OI.SHOOTER_FIRE, driverController.getRightUpperTrigger()
                                            //|| operatorController.getTriggerButton()
                          );
        
        OI.setBooleanValue(OI.SWITCH_GEAR, driverController.getLeftUpperTrigger());
        
        OI.setBooleanValue(OI.FLIP_DRIVE, driverController.getRightStickButton());
        
        OI.setBooleanValue(OI.KEEP_DRIVE_REVERSED, driverController.getLeftUpperTrigger());
        
        OI.setBooleanValue(OI.LOW_GEAR, driverController.getLeftLowerTrigger());
    }
}