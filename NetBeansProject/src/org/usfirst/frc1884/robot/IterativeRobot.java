package org.usfirst.frc1884.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc1884.robot.commands.Commands;
import org.usfirst.frc1884.robot.oi.OI;
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