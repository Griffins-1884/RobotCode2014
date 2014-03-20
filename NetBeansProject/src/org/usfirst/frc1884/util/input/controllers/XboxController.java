package org.usfirst.frc1884.util.input.controllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is a joystick class for the Xbox Controller
 *
 * http://www.chiefdelphi.com/forums/showpost.php?p=1003245&postcount=8
 */
public class XboxController extends Joystick implements Gamepad {

    /**
     * These are constants to control the inversion of the controller
     */
    public final int UP = -1;
    public final int RIGHT = 1;

    /**
     * A constant to remove joystick drift
     */
    public final double driftConstant = 0.15;

    /**
     * Creates an XboxController
     *
     * @param port The port of the XboxController
     */
    public XboxController(int port) {
        super(port);
    }

    /**
     * This method removes drift
     *
     * @param val The value from the joystick
     * @return The value without drift
     */
    public double removeDrift(double val) {
        if (Math.abs(val) < 0.12) {
            return 0.0;
        }
        return val * Math.abs(val);
    }

    /**
     * Gets the up-down value of the left joystick
     *
     * @return The value of this axis
     */
    public double getLeftStickY() {
        return removeDrift(getRawAxis(2)) * UP;
    }

    /**
     * Gets the left-right value of the left joystick
     *
     * @return The value of this axis
     */
    public double getLeftStickX() {
        return removeDrift(getRawAxis(1)) * RIGHT;
    }

    /**
     * Gets the left-right value of the right joystick
     *
     * @return The value of this axis
     */
    public double getRightStickX() {
        return removeDrift(getRawAxis(4)) * RIGHT;
    }

    /**
     * Gets the up-down value of the right joystick
     *
     * @return The value of this axis
     */
    public double getRightStickY() {
        return removeDrift(getRawAxis(5)) * UP;
    }

    /**
     * Gets the value of the triggers. The right joystick is positive, the left
     * joystick is negative. The value of each is proportional to how much they
     * are pressed, and then the two values are added together.
     *
     * @return The value of this axis
     */
    public double getTriggerValue() {
        return removeDrift(getRawAxis(3));
    }

    /**
     * Gets the value of the left lower trigger button. Note: not defined if
     * both triggers are pressed simultaneously
     *
     * @return The value of this button
     */
    public boolean getLeftLowerTrigger() {
        return (removeDrift(getRawAxis(3)) > 0.5);
    }
    
    private static class LeftLowerTriggerButton extends Button {private XboxController controller; public LeftLowerTriggerButton(XboxController controller) {this.controller = controller;} public boolean get() {return controller.getLeftLowerTrigger();}}
    public final Button LEFT_LOWER_TRIGGER_BUTTON = new LeftLowerTriggerButton(this);

    /**
     * Gets the value of the right lower trigger button. Note: not defined if
     * both triggers are pressed simultaneously
     *
     * @return The value of this button
     */
    public boolean getRightLowerTrigger() {
        return (removeDrift(getRawAxis(3)) < -0.5);
    }
    private static class RightLowerTriggerButton extends Button {private XboxController controller; public RightLowerTriggerButton(XboxController controller) {this.controller = controller;} public boolean get() {return controller.getRightLowerTrigger();}}
    public final Button RIGHT_LOWER_TRIGGER_BUTTON = new RightLowerTriggerButton(this);

    /**
     * Gets the value of the A button
     *
     * @return The value of this button
     */
    public boolean getActionBottom() {
        return getRawButton(1);
    }
    public final JoystickButton A_BUTTON = new JoystickButton(this, 1);

    /**
     * Gets the value of the B button
     *
     * @return The value of this button
     */
    public boolean getActionRight() {
        return getRawButton(2);
    }
    public final JoystickButton B_BUTTON = new JoystickButton(this, 2);

    /**
     * Gets the value of the X button
     *
     * @return The value of this button
     */
    public boolean getActionLeft() {
        return getRawButton(3);
    }
    public final JoystickButton X_BUTTON = new JoystickButton(this, 3);

    /**
     * Gets the value of the Y button
     *
     * @return The value of this button
     */
    public boolean getActionTop() {
        return getRawButton(4);
    }
    public final JoystickButton Y_BUTTON = new JoystickButton(this, 4);

    /**
     * Gets the value of the right upper trigger button
     *
     * @return The value of this button
     */
    public boolean getRightUpperTrigger() {
        return getRawButton(6);
    }
    public final JoystickButton RIGHT_UPPER_TRIGGER_BUTTON = new JoystickButton(this, 6);

    /**
     * Gets the value of the left upper trigger button
     *
     * @return The value of this button
     */
    public boolean getLeftUpperTrigger() {
        return getRawButton(5);
    }
    public final JoystickButton LEFT_UPPER_TRIGGER_BUTTON = new JoystickButton(this, 5);

    /**
     * Gets the value of the "back" button
     *
     * @return The value of this button
     */
    public boolean getBack() {
        return getRawButton(7);
    }
    public final JoystickButton BACK_BUTTON = new JoystickButton(this, 7);

    /**
     * Gets the value of the "start" button
     *
     * @return The value of this button
     */
    public boolean getStart() {
        return getRawButton(8);
    }
    public final JoystickButton START_BUTTON = new JoystickButton(this, 8);

    /**
     * Gets the value of the left stick button
     *
     * @return The value of this button
     */
    public boolean getLeftStickButton() {
        return getRawButton(9);
    }
    public final JoystickButton LEFT_STICK_BUTTON = new JoystickButton(this, 9);

    /**
     * Gets the value of the right stick button
     *
     * @return The value of this button
     */
    public boolean getRightStickButton() {
        return getRawButton(10);
    }
    public final JoystickButton RIGHT_STICK_BUTTON = new JoystickButton(this, 10);

    /**
     * Gets the value of the right Dpad button
     *
     * @return The value of this button
     */
    public boolean getDpadRight() {
        return (getRawAxis(6) > 0);
    }
    private static class DPadRightButton extends Button {private XboxController controller; public DPadRightButton(XboxController controller) {this.controller = controller;} public boolean get() {return controller.getDpadRight();}}
    public final Button DPAD_RIGHT_BUTTON = new DPadRightButton(this);

    /**
     * Gets the value of the left Dpad button
     *
     * @return The value of this button
     */
    public boolean getDpadLeft() {
        return (getRawAxis(6) < 0);
    }
    private static class DPadLeftButton extends Button {private XboxController controller; public DPadLeftButton(XboxController controller) {this.controller = controller;} public boolean get() {return controller.getDpadLeft();}}
    public final Button DPAD_LEFT_BUTTON = new DPadLeftButton(this);
    
    public boolean getDpadUp() {return false;}
    public boolean getDpadDown() {return false;}
}
