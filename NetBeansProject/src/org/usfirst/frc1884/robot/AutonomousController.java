package org.usfirst.frc1884.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc1884.robot.commands.DriveCommand;
import org.usfirst.frc1884.robot.commands.ExtendFeeder;
import org.usfirst.frc1884.robot.commands.FireAndReloadWithLimitSwitch;
import org.usfirst.frc1884.robot.commands.IntakeFeeder;
import org.usfirst.frc1884.robot.commands.OuttakeFeeder;
import org.usfirst.frc1884.robot.subsystems.DriveTrain;
import org.usfirst.frc1884.robot.subsystems.Shooter;
import org.usfirst.frc1884.util.parameters.IntegerParameter;

public class AutonomousController {
    private static final int LOW_GOAL = 0;
    private static final int HIGH_GOAL = 1;
    private static final int FIVE_PT = 2;

    private static SendableChooser autoChooser;
    
    public static void preinit() {
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Five Point Auto", ""+AutonomousController.FIVE_PT);
        autoChooser.addObject("High Goal Auto", ""+AutonomousController.HIGH_GOAL);
        autoChooser.addObject("Low Goal Auto", ""+AutonomousController.LOW_GOAL);
        SmartDashboard.putData("Auto Chooser", autoChooser);
    }
    
    public static void init() {
        int choice = Integer.parseInt((String) autoChooser.getSelected());
        setAutoMode(choice);
        
        DriveTrain.instance.startCompressor();
        timeStarted = System.currentTimeMillis();
//        Shooter.instance.resetEncoder();
    }
    
    private static int mode;
    
    protected static void setAutoMode(int mode1) {
        mode = mode1;
    }
    
    private static long timeStarted;

    public static void periodic() {
        //Get time since start
        long timeSinceStart = System.currentTimeMillis() - timeStarted;

        if (mode == LOW_GOAL) {//If low goal is picked
            lowGoalAuto(timeSinceStart);
        } else if (mode == HIGH_GOAL) {//If high goal is picked
            highGoalAuto(timeSinceStart);
        } else if (mode == FIVE_PT) {//If five point auto is picked
            fivePointAuto(timeSinceStart);
        }
    }
    
    private static IntegerParameter lowGoalAutoMoveTime = IntegerParameter.get("Auto/lowgoal_drive_time");
    private static boolean lowGoalAutoHasShot = false;

    private static void lowGoalAuto(long timeSinceStart) {
        if (timeSinceStart <= lowGoalAutoMoveTime.getValue()) {
            DriveCommand.drivePolar(0.7, 0.0);
        } else if(!lowGoalAutoHasShot) {
            DriveCommand.drivePolar(0.0, 0.0);
            // Start ball outtake
            OuttakeFeeder.instance.start();
            pause(1000);
            OuttakeFeeder.instance.finish();
            lowGoalAutoHasShot = true;
            OuttakeFeeder.instance.start();
        }
    }
    
    private static void pause (long time) {
        long previous = System.currentTimeMillis();
        while (System.currentTimeMillis() - previous < time) { }
    }
    
    private static IntegerParameter highGoalAutoMoveTime = IntegerParameter.get("Auto/highgoal_drive_time");
    private static boolean highGoalAutoHasShot = false;

    private static void highGoalAuto(long timeSinceStart) {
        if (timeSinceStart <= highGoalAutoMoveTime.getValue()) {
            DriveCommand.drivePolar(-0.7, 0.0);
        } else if(!highGoalAutoHasShot) {
            DriveCommand.drivePolar(0.0, 0.0);
            //Extend Feeder and Shoot Ball
            ExtendFeeder.instance.start();
            IntakeFeeder.instance.start();
            pause(300);
            IntakeFeeder.instance.finish();
            highGoalAutoHasShot = true;
            FireAndReloadWithLimitSwitch.instance.start();
        }
    }

    private static IntegerParameter fivePointAutoMoveTime = IntegerParameter.get("Auto/fivepoint_drive_time");

    private static void fivePointAuto(long timeSinceStart) {
        if (timeSinceStart <= fivePointAutoMoveTime.getValue()) {
            DriveCommand.drivePolar(0.7, 0.0);
        } else {
            DriveCommand.drivePolar(0.0, 0.0);
        }
    }

}
