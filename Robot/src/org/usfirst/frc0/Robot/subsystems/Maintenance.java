package org.usfirst.frc0.Robot.subsystems;

import org.usfirst.frc0.Robot.RobotMap;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Maintenance extends Subsystem {

    Compressor compressor = RobotMap.maintenanceCompressor;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    /**
     * This compresses the air for the robot.
     */
    public void compressAir() {
        compressor.start();
    }

    /**
     * This stops compressing the air for the robot.
     */
    public void stopCompressAir() {
        compressor.stop();
    }

    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void parameterRefresh() {
    }
}
