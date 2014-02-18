// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc0.Robot;

import org.usfirst.frc0.Robot.commands.StartReverseFeeding;
import org.usfirst.frc0.Robot.commands.ExtendFeeder;
import org.usfirst.frc0.Robot.commands.RetractFeeder;
import org.usfirst.frc0.Robot.commands.AutoScoreLow;
import org.usfirst.frc0.Robot.commands.RaiseBlocker;
import org.usfirst.frc0.Robot.commands.LowerBlocker;
import org.usfirst.frc0.Robot.commands.AutoBlockBalls;
import org.usfirst.frc0.Robot.commands.SwitchToGearHigh;
import org.usfirst.frc0.Robot.commands.HighBallEjection;
import org.usfirst.frc0.Robot.commands.AutoPickupBalls;
import org.usfirst.frc0.Robot.commands.EndFeeding;
import org.usfirst.frc0.Robot.commands.LowBallEjection;
import org.usfirst.frc0.Robot.commands.StartFeeding;
import org.usfirst.frc0.Robot.commands.SwitchToGearLow;
import org.usfirst.frc0.Robot.commands.AutoAllianceZoneEntry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
     //PS3 Button Constants
    private static final int TRIANGLE = 1;
    private static final int CIRCLE = 2;
    private static final int CROSS = 3;
    private static final int SQUARE = 4;
    private static final int LEFT_BUMPER_PS3 = 5;
    private static final int RIGHT_BUMPER_PS3 = 6;
    private static final int LEFT_TRIGGER = 7;
    private static final int RIGHT_TRIGGER = 8;
    private static final int SELECT = 9;
    private static final int LEFT_JOYSTICK_PS3 = 10;
    private static final int RIGHT_JOYSTICK_PS3 = 11;
    private static final int START_PS3 = 12;
    private static final int PS_BUTTON = 13;
    private static final int DPAD_UP = 14;
    private static final int DPAD_RIGHT = 15;
    private static final int DPAD_DOWN = 16;
    private static final int DPAD_LEFT = 17;
    //PS3 Axis Constants
    private static final int LEFT_Y_AXIS = 1;
    private static final int LEFT_X_AXIS = 2;
    private static final int RIGHT_Y_AXIS = 3;
    private static final int RIGHT_X_AXIS = 6;
    private static final int CONTROLLER_Z_AXIS = 5;
    private static final int CONTROLLER_X_AXIS = 4;
    
    //XBox Button constants
    public static final int A = 1;
    public static final int B = 2;
    public static final int X = 3;
    public static final int Y = 4;
    public static final int LEFT_BUMPER = 5;
    public static final int RIGHT_BUMPER = 6;
    public static final int BACK = 7;
    public static final int START = 8;
    public static final int LEFT_JOYSTICK = 9;
    public static final int RIGHT_JOYSTICK = 10;
    //XBox Axis constants
    public static final int LEFT_Y = 1;
    public static final int LEFT_X = 2;
    public static final int TRIGGERS = 3;
    public static final int RIGHT_Y = 4;
    public static final int RIGHT_X = 5;
    public static final int DIRECTIONAL_PAD = 6;

    Joystick pilot;
    Joystick coPilot;
    
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        //Initialise Joysticks 
        /*Joystick*/ pilot = new Joystick(1);
        /*Joystick*/ coPilot = new Joystick(2);
        
        
        //Get and Send Button Values
        
        //CoPilot Values
        
        JoystickButton retractFeeder = new JoystickButton(/*coPilot*/pilot, /*A*/CROSS);
        retractFeeder.whenReleased(new RetractFeeder());
        
        JoystickButton extendFeeder = new JoystickButton(/*coPilot*/pilot, /*B*/CIRCLE);
        extendFeeder.whenReleased(new ExtendFeeder());
        
        //JoystickButton lowerBlocker = new JoystickButton(coPilot, 4);
        //lowerBlocker.whenReleased(new LowerBlocker());
        
        //JoystickButton raiseBlocker = new JoystickButton(coPilot, 5);
        //raiseBlocker.whenReleased(new RaiseBlocker());
        
        //Pilot Values
        
        JoystickButton highBallEjection = new JoystickButton(pilot, /*Y*/RIGHT_TRIGGER); //shoot ball
        highBallEjection.whileHeld(new HighBallEjection());
        
//        JoystickButton lowBallEjection = new JoystickButton(pilot, X); //flick ball
//        lowBallEjection.whenReleased(new LowBallEjection());
        
        JoystickButton switchToGearHigh = new JoystickButton(pilot, DPAD_UP);
        switchToGearHigh.whenReleased(new SwitchToGearHigh());
        
        JoystickButton switchToGearLow = new JoystickButton(pilot, DPAD_DOWN);
        switchToGearLow.whenReleased(new SwitchToGearLow());
        
        JoystickButton startFeeding = new JoystickButton(pilot, LEFT_BUMPER_PS3);
        startFeeding.whenPressed(new StartFeeding());
        startFeeding.whenReleased(new EndFeeding());
        
        JoystickButton reverseFeeding = new JoystickButton(pilot, RIGHT_BUMPER_PS3);
        reverseFeeding.whenPressed(new StartReverseFeeding());
        reverseFeeding.whenReleased(new EndFeeding());
	    
        // SmartDashboard Buttons
        SmartDashboard.putData("AutoScoreLow", new AutoScoreLow());

        SmartDashboard.putData("AutoBlockBalls", new AutoBlockBalls());

        SmartDashboard.putData("AutoAllianceZoneEntry", new AutoAllianceZoneEntry());

        SmartDashboard.putData("AutoPickupBalls", new AutoPickupBalls());

        SmartDashboard.putData("ExtendFeeder", new ExtendFeeder());

        SmartDashboard.putData("RetractFeeder", new RetractFeeder());

        SmartDashboard.putData("SwitchToGearHigh", new SwitchToGearHigh());

        SmartDashboard.putData("SwitchToGearLow", new SwitchToGearLow());

        SmartDashboard.putData("RaiseBlocker", new RaiseBlocker());

        SmartDashboard.putData("LowerBlocker", new LowerBlocker());

        SmartDashboard.putData("LowBallEjection", new LowBallEjection());

        SmartDashboard.putData("HighBallEjection", new HighBallEjection());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    
    public double getLeftSpeed() {
        double leftSpeed = pilot.getRawAxis(LEFT_X_AXIS);
        return leftSpeed * leftSpeed * leftSpeed; 
    }
    
    public double getRightSpeed() {
        double rightSpeed = pilot.getRawAxis(RIGHT_X_AXIS);
        return rightSpeed * rightSpeed * rightSpeed;   
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

