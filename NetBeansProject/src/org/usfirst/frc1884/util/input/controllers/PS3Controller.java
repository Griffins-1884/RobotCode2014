package org.usfirst.frc1884.util.input.controllers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is a joystick class for the PS3 Controller
 *
 * Jonathan Wang knows the constants
 */
public class PS3Controller extends Joystick implements Gamepad {

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
    public PS3Controller(int port) {
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
        return removeDrift(getRawAxis(3)) * RIGHT;
    }

    /**
     * Gets the up-down value of the right joystick
     *
     * @return The value of this axis
     */
    public double getRightStickY() {
        return removeDrift(getRawAxis(6)) * UP;
    }

    /**
     * Gets the value of the left lower trigger button.
     *
     * @return The value of this button
     */
    public boolean getLeftLowerTrigger() {
        return getRawButton(7);
    }
    public final JoystickButton LEFT_LOWER_TRIGGER_BUTTON = new JoystickButton(this, 7);

    /**
     * Gets the value of the right lower trigger button.
     *
     * @return The value of this button
     */
    public boolean getRightLowerTrigger() {
        return getRawButton(8);
    }
    public final JoystickButton RIGHT_LOWER_TRIGGER_BUTTON = new JoystickButton(this, 8);

    /**
     * Gets the value of the triangle button
     *
     * @return The value of this button
     */
    public boolean getActionTop() {
        return getRawButton(1);
    }
    public final JoystickButton TRIANGLE_BUTTON = new JoystickButton(this, 1);

    /**
     * Gets the value of the circle button
     *
     * @return The value of this button
     */
    public boolean getActionRight() {
        return getRawButton(2);
    }
    public final JoystickButton CIRCLE_BUTTON = new JoystickButton(this, 2);

    /**
     * Gets the value of the cross button
     *
     * @return The value of this button
     */
    public boolean getActionBottom() {
        return getRawButton(3);
    }
    public final JoystickButton CROSS_BUTTON = new JoystickButton(this, 3);

    /**
     * Gets the value of the square button
     *
     * @return The value of this button
     */
    public boolean getActionLeft() {
        return getRawButton(4);
    }
    public final JoystickButton SQUARE_BUTTON = new JoystickButton(this, 4);

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
    public boolean getSelect() {
        return getRawButton(9);
    }
    public final JoystickButton SELECT_BUTTON = new JoystickButton(this, 9);

    /**
     * Gets the value of the "start" button
     *
     * @return The value of this button
     */
    public boolean getStart() {
        return getRawButton(12);
    }
    public final JoystickButton START_BUTTON = new JoystickButton(this, 12);

    /**
     * Gets the value of the "PS" button
     *
     * @return The value of this button
     */
    public boolean getPSButton() {
        return getRawButton(13);
    }
    public final JoystickButton PS_BUTTON = new JoystickButton(this, 13);

    /**
     * Gets the value of the left stick button
     *
     * @return The value of this button
     */
    public boolean getLeftStickButton() {
        return getRawButton(10);
    }
    public final JoystickButton LEFT_STICK_BUTTON = new JoystickButton(this, 10);

    /**
     * Gets the value of the right stick button
     *
     * @return The value of this button
     */
    public boolean getRightStickButton() {
        return getRawButton(11);
    }
    public final JoystickButton RIGHT_STICK_BUTTON = new JoystickButton(this, 11);

    /**
     * Gets the value of the right Dpad button
     *
     * @return The value of this button
     */
    public boolean getDpadRight() {
        return getRawButton(15);
    }
    public final JoystickButton DPAD_RIGHT_BUTTON = new JoystickButton(this, 15);

    /**
     * Gets the value of the left Dpad button
     *
     * @return The value of this button
     */
    public boolean getDpadLeft() {
        return getRawButton(17);
    }
    public final JoystickButton DPAD_LEFT_BUTTON = new JoystickButton(this, 17);

    /**
     * Gets the value of the up Dpad button
     *
     * @return The value of this button
     */
    public boolean getDpadUp() {
        return getRawButton(14);
    }
    public final JoystickButton DPAD_UP_BUTTON = new JoystickButton(this, 14);

    /**
     * Gets the value of the down Dpad button
     *
     * @return The value of this button
     */
    public boolean getDpadDown() {
        return getRawButton(16);
    }
    public final JoystickButton DPAD_DOWN_BUTTON = new JoystickButton(this, 16);
}
