package org.usfirst.frc1884.robot;

import org.usfirst.frc1884.robot.commands.DriveShiftHigh;
import org.usfirst.frc1884.robot.commands.DriveShiftLow;
import org.usfirst.frc1884.robot.commands.DriveShiftSwitch;
import org.usfirst.frc1884.robot.commands.LowerBlocker;
import org.usfirst.frc1884.robot.commands.RaiseBlocker;
import org.usfirst.frc1884.robot.commands.ReloadShooter;
import org.usfirst.frc1884.robot.commands.ShootShooter;
import org.usfirst.frc1884.robot.commands.TeleopDrive;
import org.usfirst.frc1884.robot.oi.OI;

public class TeleopController {
    public static void init() {
        TeleopDrive.start();
    }
    public static void periodic() {
        /******** DON'T DELETE THIS ********/
        /*******/    OI.poll();     /*******/
        /******** DON'T DELETE THIS ********/
        
        if(OI.isBooleanChanged(OI.SWITCH_GEAR) && OI.isBooleanTrue(OI.SWITCH_GEAR)) {
            DriveShiftSwitch.start();
        }
        
        if(OI.isBooleanChanged(OI.BLOCKER_EXTEND) && OI.isBooleanTrue(OI.BLOCKER_EXTEND)) {
            RaiseBlocker.start();
        }
        if(OI.isBooleanChanged(OI.BLOCKER_EXTEND) && !OI.isBooleanTrue(OI.BLOCKER_EXTEND)) {
            LowerBlocker.start();
        }
        if(OI.isBooleanChanged(OI.SHOOTER_RELOAD) && OI.isBooleanTrue(OI.SHOOTER_RELOAD)) {
            ReloadShooter.start();
        }
        if(OI.isBooleanChanged(OI.SHOOTER_FIRE) && OI.isBooleanTrue(OI.SHOOTER_FIRE)) {
            ShootShooter.start();
        }
        
        // Execute every command!!!
        RaiseBlocker.execute();
        LowerBlocker.execute();
        TeleopDrive.execute();
        ReloadShooter.execute();
        ShootShooter.execute();
        DriveShiftHigh.execute();
        DriveShiftLow.execute();
        DriveShiftSwitch.execute();
    }
}