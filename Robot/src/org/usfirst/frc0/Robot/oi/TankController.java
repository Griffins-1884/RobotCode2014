package org.usfirst.frc0.Robot.oi;

import org.usfirst.frc0.util.input.controllers.PS3Controller;

public class TankController implements Controller2014 {
    private PS3Controller controller = new PS3Controller(1);
    public double getAnalog(int analogConstant) {
        switch(analogConstant) {
            case Controller2014.DRIVE_FORWARD:
                double forward = (controller.getLeftY() + controller.getRightY()) / 2;
                forward *= forward * forward;
                return forward;
            case Controller2014.DRIVE_COUNTERCLOCKWISE:
                double counterclockwise = (-controller.getLeftY() + controller.getRightY()) / 2;
                counterclockwise *= counterclockwise * counterclockwise;
                return counterclockwise;
        }
        return 0.0;
    }

    public boolean getBoolean(int digitalConstant) {
        switch(digitalConstant) {
            case Controller2014.SWITCH_GEAR:
                return controller.getLeftStick();
            case Controller2014.FEEDER_EXTEND:
                return controller.getRightStick();
            case Controller2014.FEEDER_INTAKE:
                return controller.getLeftUpperTrigger();
            case Controller2014.FEEDER_OUTTAKE:
                return controller.getRightUpperTrigger();
            case Controller2014.SHOOTER_FIRE:
                return controller.getRightLowerTrigger();
            case Controller2014.SHOOTER_RELOAD:
                return controller.getLeftLowerTrigger();
        }
        return false;
    }
    
}