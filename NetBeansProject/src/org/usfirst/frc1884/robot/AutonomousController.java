package org.usfirst.frc1884.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc1884.robot.commands.DriveCommand;
import org.usfirst.frc1884.robot.commands.DriveShiftLow;
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
        autoChooser.addDefault("Five Point Auto", "" + AutonomousController.FIVE_PT);
        autoChooser.addObject("High Goal Auto", "" + AutonomousController.HIGH_GOAL);
        autoChooser.addObject("Low Goal Auto", "" + AutonomousController.LOW_GOAL);
        SmartDashboard.putData("Auto Chooser", autoChooser);
    }

    public static void init() {
        mode = Integer.parseInt((String) autoChooser.getSelected());
        
        DriveTrain.instance.startCompressor();
        timeStarted = System.currentTimeMillis();
        //DriveShiftLow.instance.start();

        highGoalAutoHasExtended = false;
        highGoalAutoHasShot = false;
        lowGoalAutoHasShot = false;
    }

    private static int mode;

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
    private static long lowGoalTimeSinceOuttake;
    private static boolean lowGoalAutoHasShot;

    private static void lowGoalAuto(long timeSinceStart) {

        if (timeSinceStart <= 3000) {
            DriveCommand.drivePolar(0.7, 0.0);
        } else if (!lowGoalAutoHasShot) {
            DriveCommand.drivePolar(0.0, 0.0);
            //Roll out ball
            OuttakeFeeder.instance.start();
            lowGoalTimeSinceOuttake = System.currentTimeMillis();
            lowGoalAutoHasShot = true;
        } else if (!lowGoalAutoHasShot && System.currentTimeMillis() - lowGoalTimeSinceOuttake > 2000) {
            OuttakeFeeder.instance.finish();
        }
    }

    private static IntegerParameter highGoalAutoMoveTime = IntegerParameter.get("Auto/highgoal_drive_time");
    private static long highGoalTimeSinceExtended;
    private static boolean highGoalAutoHasExtended;
    private static boolean highGoalAutoHasShot;

    private static void highGoalAuto(long timeSinceStart) {
        if (timeSinceStart <= 4500) {
            DriveCommand.drivePolar(-0.7, 0.0);
        } else if (!highGoalAutoHasExtended) {
            DriveCommand.drivePolar(0.0, 0.0);
            //Extend Feeder and Shoot Ball
            ExtendFeeder.instance.start();
            IntakeFeeder.instance.start();
            highGoalTimeSinceExtended = System.currentTimeMillis();
            highGoalAutoHasExtended = true;
        } else if (!highGoalAutoHasShot && System.currentTimeMillis() - highGoalTimeSinceExtended > 3000) {
            IntakeFeeder.instance.finish();
            highGoalAutoHasShot = true;
            FireAndReloadWithLimitSwitch.instance.start();
        }
    }

    private static IntegerParameter fivePointAutoMoveTime = IntegerParameter.get("Auto/fivepoint_drive_time");

    private static void fivePointAuto(long timeSinceStart) {
        if (timeSinceStart <= fivePointAutoMoveTime.getValue()) {
            DriveCommand.drivePolar(-0.8, 0.0);
        } else {
            DriveCommand.drivePolar(0.0, 0.0);
        }
    }

}