// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1884.Robot;

import org.usfirst.frc1884.Robot.commands.*;
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

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        //Initialise Joysticks 
        Joystick pilot = new Joystick(1);
        Joystick coPilot = new Joystick(2);
        
        //Get Joystick Values
        double rightValue = pilot.getAxis(Joystick.AxisType.kX);
        double leftValue = pilot.getAxis(Joystick.AxisType.kX);
        
        //Send Joystick Values
        Robot.driveTrain.setLeftValues(leftValue);
        Robot.driveTrain.setRightValues(rightValue);
        
        //Get and Send Button Values
        
        //CoPilot Values
        
        JoystickButton retractFeeder = new JoystickButton(coPilot, 2);
        retractFeeder.whenReleased(new RetractFeeder());
        
        JoystickButton extendFeeder = new JoystickButton(coPilot, 3);
        extendFeeder.whenReleased(new ExtendFeeder());
        
        JoystickButton lowerBlocker = new JoystickButton(coPilot, 4);
        lowerBlocker.whenReleased(new LowerBlocker());
        
        JoystickButton raiseBlocker = new JoystickButton(coPilot, 5);
        raiseBlocker.whenReleased(new RaiseBlocker());
        
        //Pilot Values
        
        JoystickButton highBallEjection = new JoystickButton(pilot, 1);
        highBallEjection.whenReleased(new HighBallEjection());
        
        JoystickButton lowBallEjection = new JoystickButton(pilot, 2);
        lowBallEjection.whenReleased(new LowBallEjection());
        
        JoystickButton switchToGearHigh = new JoystickButton(pilot, 3);
        switchToGearHigh.whenReleased(new SwitchToGearHigh());
        
        JoystickButton switchToGearLow = new JoystickButton(pilot, 4);
        switchToGearLow.whenReleased(new SwitchToGearLow());
        
        JoystickButton startFeeding = new JoystickButton(pilot, 5);
        startFeeding.whenReleased(new StartFeeding());
        
        JoystickButton reverseFeeding = new JoystickButton(pilot, 6);
        reverseFeeding.whenReleased(new StartReverseFeeding());
        
        JoystickButton endFeeding = new JoystickButton(pilot, 7);
        endFeeding.whenReleased(new EndFeeding());
	    
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
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

