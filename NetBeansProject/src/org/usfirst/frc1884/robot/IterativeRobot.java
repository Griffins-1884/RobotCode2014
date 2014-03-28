package org.usfirst.frc1884.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc1884.robot.commands.Commands;
import org.usfirst.frc1884.robot.commands.TeleopDrive;
import org.usfirst.frc1884.robot.oi.OI;
import org.usfirst.frc1884.robot.subsystems.DriveTrain;
import org.usfirst.frc1884.robot.subsystems.Intake;
import org.usfirst.frc1884.robot.subsystems.Shooter;
import org.usfirst.frc1884.robot.subsystems.Subsystems;

public class IterativeRobot extends edu.wpi.first.wpilibj.IterativeRobot {

    SendableChooser autoChooser;
    
    public void robotInit() {
        super.robotInit(); //To change body of generated methods, choose Tools | Templates.
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Five Point Auto", ""+AutonomousController.FIVE_PT);
        autoChooser.addObject("High Goal Auto", ""+AutonomousController.HIGH_GOAL);
        autoChooser.addObject("Low Goal Auto", ""+AutonomousController.LOW_GOAL);
        SmartDashboard.putData("Auto Chooser", autoChooser);
    }
    
    public void disabledInit() {
        TeleopDrive.instance.finish();
        //TODO disable all
        
        DriveTrain.instance.setLeftSidePower(0.0);
        DriveTrain.instance.setRightSidePower(0.0);
        Shooter.instance.setMotorPower(0.0);
        Intake.instance.setIntakePower(0.0);
    }
    
    public void autonomousInit() {
        int choice = Integer.parseInt((String) autoChooser.getSelected());
        AutonomousController.setAutoMode(choice);
        AutonomousController.init();
    }
    public void autonomousPeriodic() {
        AutonomousController.periodic();
        Commands.executeAllCommands();
        Subsystems.subsystemAlwaysRuns();
    }
    public void teleopInit() {
        TeleopController.init();
    }
    public void teleopPeriodic() {
        OI.poll();
        TeleopController.periodic();
        Commands.executeAllCommands();
        Subsystems.subsystemAlwaysRuns();
    }
}