package org.usfirst.frc1884.robot;

import org.usfirst.frc1884.robot.commands.Commands;
import org.usfirst.frc1884.robot.oi.OI;
import org.usfirst.frc1884.robot.subsystems.Subsystems;

public class IterativeRobot extends edu.wpi.first.wpilibj.IterativeRobot {
    public void autonomousInit() {
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