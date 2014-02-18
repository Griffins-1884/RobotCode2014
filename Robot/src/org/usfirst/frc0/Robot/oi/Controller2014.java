package org.usfirst.frc0.Robot.oi;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This interface should be implemented by any device hoping to control the 2013 robot
 */
public interface Controller2014 {
    public static final int DRIVE_FORWARD = 0,
                            DRIVE_COUNTERCLOCKWISE = 1;
    public static final int SHOOTER_FIRE = 0,
                            SHOOTER_RELOAD = 1,
                            FEEDER_INTAKE = 2,
                            FEEDER_EXTEND = 3,
                            FEEDER_OUTTAKE = 5,
                            BLOCKER_EXTEND = 6,
                            SWITCH_GEAR = 7;
    
    public double getAnalog(int analogConstant);
    public boolean getBoolean(int digitalConstant);
    
    /**
     * This class masquerades as a JoystickButton so that we can abstract it
     */
    public static class Controller2014Trigger extends JoystickButton {
        Controller2014 controller;
        int buttonConstant;
        
        public Controller2014Trigger(Controller2014 controller, int buttonConstant) {
            super(null, 0); // Doesn't matter, because we overload every method that uses those values
            this.controller = controller;
            this.buttonConstant = buttonConstant;
        }
        
        public boolean get() {
            return controller.getBoolean(buttonConstant);
        }
    }
}
