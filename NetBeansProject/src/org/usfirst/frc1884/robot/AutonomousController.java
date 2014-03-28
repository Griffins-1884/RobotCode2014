package org.usfirst.frc1884.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        Shooter.instance.resetEncoder();
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
        SmartDashboard.putString("mode", "lowgoal");
        if (timeSinceStart <= lowGoalAutoMoveTime.getValue()) {
            DriveTrain.instance.setRightSidePower(-1.0);
            DriveTrain.instance.setLeftSidePower(1.0);
        } else if(!lowGoalAutoHasShot) {
            DriveTrain.instance.setRightSidePower(0.0);
            DriveTrain.instance.setLeftSidePower(0.0);
            
            // Start ball outtake
            lowGoalAutoHasShot = true;
            OuttakeFeeder.instance.start();
        }
    }
    
    private static IntegerParameter highGoalAutoMoveTime = IntegerParameter.get("Auto/highgoal_drive_time");
    private static boolean highGoalAutoHasShot = false;

    private static void highGoalAuto(long timeSinceStart) {
        SmartDashboard.putString("mode", "highgoal");
        if (timeSinceStart <= highGoalAutoMoveTime.getValue()) {
            DriveTrain.instance.setRightSidePower(1.0);
            DriveTrain.instance.setLeftSidePower(-1.0);
        } else if(!highGoalAutoHasShot) {
            DriveTrain.instance.setRightSidePower(0.0);
            DriveTrain.instance.setLeftSidePower(0.0);
            
            // Shoot ball
            highGoalAutoHasShot = true;
//            FireAndReload.instance.start();
        }
    }

    private static IntegerParameter fivePointAutoMoveTime = IntegerParameter.get("Auto/fivepoint_drive_time");

    private static void fivePointAuto(long timeSinceStart) {
        SmartDashboard.putString("mode", "fivepoint");
        if (timeSinceStart <= fivePointAutoMoveTime.getValue()) {
            DriveTrain.instance.setRightSidePower(1.0);
            DriveTrain.instance.setLeftSidePower(-1.0);
        } else {
            DriveTrain.instance.setRightSidePower(0.0);
            DriveTrain.instance.setLeftSidePower(0.0);
        }
    }

}
