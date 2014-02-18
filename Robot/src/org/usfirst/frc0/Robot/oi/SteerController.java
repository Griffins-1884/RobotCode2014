package org.usfirst.frc0.Robot.oi;

import org.usfirst.frc0.util.input.controllers.PS3Controller;

public class SteerController implements Controller2014 {
    private PS3Controller controller = new PS3Controller(1);
    public double getAnalog(int analogConstant) {
        switch(analogConstant) {
            case Controller2014.DRIVE_FORWARD:
                double forward = -controller.getLeftY();
                forward *= forward * sign(forward);
                return forward;
            case Controller2014.DRIVE_COUNTERCLOCKWISE:
                double counterclockwise = controller.getLeftX();
                counterclockwise *= counterclockwise * sign(counterclockwise);
                return counterclockwise;
        }
        return 0.0;
    }
    public static double sign(double arg) {
        if(arg < 0) {
            return -1.0;
        } else {
            return 1.0;
        }
    }

    public boolean getBoolean(int digitalConstant) {
        switch(digitalConstant) {
            case Controller2014.FEEDER_EXTEND:
                return controller.getButtonCross();
            case Controller2014.FEEDER_INTAKE:
                return controller.getButtonSquare();
            case Controller2014.FEEDER_OUTTAKE:
                return controller.getButtonCircle();
            case Controller2014.BLOCKER_EXTEND:
                return controller.getButtonTriangle();
            case Controller2014.SHOOTER_FIRE:
                return controller.getRightUpperTrigger();
            case Controller2014.SHOOTER_RELOAD:
                return controller.getRightLowerTrigger();
            case Controller2014.SWITCH_GEAR:
                return controller.getLeftStick();
        }
        return false;
    }
}