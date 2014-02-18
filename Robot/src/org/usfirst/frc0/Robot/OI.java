package org.usfirst.frc0.Robot;

import org.usfirst.frc0.Robot.commands.StartReverseFeeding;
import org.usfirst.frc0.Robot.commands.SwitchFeeder;
import org.usfirst.frc0.Robot.commands.RetractFeeder;
import org.usfirst.frc0.Robot.commands.AutoScoreLow;
import org.usfirst.frc0.Robot.commands.RaiseBlocker;
import org.usfirst.frc0.Robot.commands.LowerBlocker;
import org.usfirst.frc0.Robot.commands.AutoBlockBalls;
import org.usfirst.frc0.Robot.commands.SwitchGears;
import org.usfirst.frc0.Robot.commands.HighBallEjection;
import org.usfirst.frc0.Robot.commands.AutoPickupBalls;
import org.usfirst.frc0.Robot.commands.EndFeeding;
import org.usfirst.frc0.Robot.commands.StartFeeding;
import org.usfirst.frc0.Robot.commands.SwitchToGearLow;
import org.usfirst.frc0.Robot.commands.AutoAllianceZoneEntry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc0.Robot.commands.EndCamTurn;
import org.usfirst.frc0.Robot.commands.StartCamTurn;
import org.usfirst.frc0.Robot.oi.Controller2014;
import org.usfirst.frc0.Robot.oi.Controller2014.Controller2014Trigger;
import org.usfirst.frc0.Robot.oi.SteerController;
import org.usfirst.frc0.Robot.oi.TankController;

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
    
    public static Controller2014 controller = new TankController();


    public OI() {
        //Initialise Joysticks 

        //Get and Send Button Values
        //CoPilot Values
        JoystickButton switchFeeder = new Controller2014Trigger(controller, Controller2014.FEEDER_EXTEND);
        switchFeeder.whenPressed(new SwitchFeeder());
        //JoystickButton lowerBlocker = new JoystickButton(coPilot, 4);
        //lowerBlocker.whenReleased(new LowerBlocker());
        //JoystickButton raiseBlocker = new JoystickButton(coPilot, 5);
        //raiseBlocker.whenReleased(new RaiseBlocker());
        //Pilot Values
        
        JoystickButton highBallEjection = new Controller2014Trigger(controller, Controller2014.SHOOTER_FIRE);
        highBallEjection.whileHeld(new HighBallEjection());

//        JoystickButton lowBallEjection = new JoystickButton(pilot, X); //flick ball
//        lowBallEjection.whenReleased(new LowBallEjection());
        JoystickButton switchGears = new Controller2014Trigger(controller, Controller2014.SWITCH_GEAR);
        switchGears.whenPressed(new SwitchGears());
        
        JoystickButton startFeeding = new Controller2014Trigger(controller, Controller2014.FEEDER_INTAKE);
        startFeeding.whenPressed(new StartFeeding());
        startFeeding.whenReleased(new EndFeeding());
        
        JoystickButton reverseFeeding = new Controller2014Trigger(controller, Controller2014.FEEDER_OUTTAKE);
        reverseFeeding.whenPressed(new StartReverseFeeding());
        reverseFeeding.whenReleased(new EndFeeding());
        
        JoystickButton turnCam = new Controller2014Trigger(controller, Controller2014.SHOOTER_FIRE);
        reverseFeeding.whenPressed(new StartCamTurn());
        reverseFeeding.whenReleased(new EndCamTurn());

        // SmartDashboard Buttons
        SmartDashboard.putData("AutoScoreLow", new AutoScoreLow());

        SmartDashboard.putData("AutoBlockBalls", new AutoBlockBalls());

        SmartDashboard.putData("AutoAllianceZoneEntry", new AutoAllianceZoneEntry());

        SmartDashboard.putData("AutoPickupBalls", new AutoPickupBalls());

        SmartDashboard.putData("ExtendFeeder", new SwitchFeeder());

        SmartDashboard.putData("RetractFeeder", new RetractFeeder());

        SmartDashboard.putData("SwitchToGearHigh", new SwitchGears());

        SmartDashboard.putData("SwitchToGearLow", new SwitchToGearLow());

        SmartDashboard.putData("RaiseBlocker", new RaiseBlocker());

        SmartDashboard.putData("LowerBlocker", new LowerBlocker());

        SmartDashboard.putData("HighBallEjection", new HighBallEjection());
    }
}
