package org.usfirst.frc0.Robot;

import org.usfirst.frc0.Robot.subsystems.Feeder;
import org.usfirst.frc0.Robot.subsystems.Shooter;
import org.usfirst.frc0.Robot.subsystems.DriveTrain;
import org.usfirst.frc0.Robot.subsystems.Maintenance;
import org.usfirst.frc0.Robot.subsystems.Blocker;
import org.usfirst.frc0.Robot.subsystems.Camera;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc0.util.Parameter;

public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    public static DriveTrain driveTrain;
    public static Shooter shooter;
    public static Feeder feeder;
    public static Blocker blocker;
    public static Camera camera;
    public static Maintenance maintenance;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
	RobotMap.init();
        Parameter.readFile();
        driveTrain = new DriveTrain();
        shooter = new Shooter();
        feeder = new Feeder();
        blocker = new Blocker();
        camera = new Camera();
        maintenance = new Maintenance();
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
	
        // instantiate the command used for the autonomous period
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    long nextParameterRefresh = 0;
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        if(System.currentTimeMillis() > nextParameterRefresh) {
            nextParameterRefresh = System.currentTimeMillis() + 1000;
            parameterRefresh();
        }
    }

    /**
     * This function called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void parameterRefresh() {
        if(Parameter.readFile()) {
            Robot.driveTrain.parameterRefresh();
            Robot.shooter.parameterRefresh();
            Robot.feeder.parameterRefresh();
            Robot.blocker.parameterRefresh();
            Robot.camera.parameterRefresh();
            Robot.maintenance.parameterRefresh();
        }
    }
}
