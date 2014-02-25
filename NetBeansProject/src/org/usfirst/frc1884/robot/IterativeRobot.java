package org.usfirst.frc1884.robot;

public class IterativeRobot extends edu.wpi.first.wpilibj.IterativeRobot {
    public void teleopInit() {
        TeleopController.init();
    }
    public void teleopPeriodic() {
        TeleopController.periodic();
    }
}