package org.usfirst.frc1884.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc1884.robot.subsystems.DriveTrain;
import org.usfirst.frc1884.robot.subsystems.Shooter;

public class AutonomousController {

    protected static final int LOW_GOAL = 0;
    protected static final int HIGH_GOAL = 1;
    protected static final int FIVE_PT = 2;

    public static void init() {
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

    private static long lowGoalAutoMoveTime = 10000;
    private static boolean lowGoalAutoHasShot = false;

    private static void lowGoalAuto(long timeSinceStart) {
        if (timeSinceStart <= lowGoalAutoMoveTime) {
            DriveTrain.instance.setRightSidePower(1.0);
            DriveTrain.instance.setLeftSidePower(1.0);
        } else if (timeSinceStart > lowGoalAutoMoveTime && !lowGoalAutoHasShot) {
            DriveTrain.instance.setRightSidePower(0.0);
            DriveTrain.instance.setLeftSidePower(0.0);
            //Setup ball release
            lowGoalAutoHasShot = true;
        }
    }

    private static long highGoalAutoMoveTime = 7000;
    private static boolean highGoalAutoHasShot = false;

    private static void highGoalAuto(long timeSinceStart) {
        if (timeSinceStart <= highGoalAutoMoveTime) {
            DriveTrain.instance.setRightSidePower(1.0);
            DriveTrain.instance.setLeftSidePower(1.0);
        } else if (timeSinceStart > highGoalAutoMoveTime && !highGoalAutoHasShot) {
            DriveTrain.instance.setRightSidePower(0.0);
            DriveTrain.instance.setLeftSidePower(0.0);
            Shooter.instance.setGoalPoint(Shooter.instance.getGoalPoint() - 360.0);
            highGoalAutoHasShot = true;
        }
    }

    private static long fivePointAutoMoveTime = 5000;

    private static void fivePointAuto(long timeSinceStart) {
        if (timeSinceStart <= fivePointAutoMoveTime) {
            DriveTrain.instance.setRightSidePower(1.0);
            DriveTrain.instance.setLeftSidePower(1.0);
        } else if (timeSinceStart > fivePointAutoMoveTime) {
            DriveTrain.instance.setRightSidePower(0.0);
            DriveTrain.instance.setLeftSidePower(0.0);
        }
    }

}
