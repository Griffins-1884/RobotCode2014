package org.usfirst.frc0.Robot.subsystems;

import org.usfirst.frc0.Robot.Robot;

public class SmartDriveTrain extends DriveTrain implements Runnable {

    private double distance;
    private double leftSpeed;
    private double rightSpeed;
    private long threadPollInterval;
    private boolean isRunning;
    private Thread checkup;
    private DriveListener dl;
    private static final long THREAD_POLL_INTERVAL = 250;

    /**
     * This is the constructor for the SmartDrive class. This class allows the
     * drivetrain to move a specified amount.
     *
     * @param odc The OnDriveCompleted interface associated with the
     * SmartDriveTrain.
     * @param distance The distance in inches to move.
     * @param rightSpeed The speed to give the Talons controlling the right side
     * of the robot. This should be between -1.0 and 1.0.
     * @param leftSpeed The speed to give the Talons controlling the left side
     * of the robot. Should be between -1.0 and 1.0.
     */
    public SmartDriveTrain(DriveListener dl, double distance, double rightSpeed, double leftSpeed) {
        this(dl, distance, rightSpeed, leftSpeed, THREAD_POLL_INTERVAL);
    }

    /**
     * This is the constructor for the SmartDrive class. This class allows the
     * drivetrain to move a specified amount.
     *
     * @param distance The distance in inches to move.
     * @param speed The speed to give the Talons controlling the right side of
     * the robot. This should be between -1.0 and 1.0.
     * @param threadPollInterval The time between checking the distance
     * traveled.
     */
    public SmartDriveTrain(DriveListener dl, double distance, double speed, long threadPollInterval) {
        this(dl, distance, speed, speed, THREAD_POLL_INTERVAL);
    }

    /**
     * This is the constructor for the SmartDrive class. This class allows the
     * drivetrain to move a specified amount.
     *
     * @param distance The distance in inches to move.
     * @param speed The speed to give the Talons controlling the robot. Should
     * be between -1.0 and 1.0.
     */
    public SmartDriveTrain(DriveListener dl, double distance, double speed) {
        this(dl, distance, speed, speed, THREAD_POLL_INTERVAL);
    }

    /**
     * This is the constructor for the SmartDrive class. This class allows the
     * drivetrain to move a specified amount.
     *
     * @param distance The distance in inches to move.
     * @param rightSpeed The speed to give the Talons controlling the right side
     * of the robot. This should be between -1.0 and 1.0.
     * @param leftSpeed The speed to give the Talons controlling the left side
     * of the robot. Should be between -1.0 and 1.0.
     * @param threadPollInterval The time between checking the distance
     * traveled.
     */
    public SmartDriveTrain(DriveListener dl, double distance, double rightSpeed, double leftSpeed, long threadPollInterval) {
        this.dl = dl;
        this.distance = distance;
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        this.threadPollInterval = threadPollInterval;
        this.isRunning = false;
        checkup = new Thread(this);
    }

    public void startTrack() {
        leftEncoder.reset();
        rightEncoder.reset();
    }

    public double getDistanceDriven() {
        return ((leftEncoder.getDistance() + rightEncoder.getDistance()) / 2.0);
    }

    public void startDrive() {
        setLeftValues(leftSpeed);
        setRightValues(rightSpeed);
    }

    public void endDrive() {
        setLeftValues(0);
        setRightValues(0);
        dl.onDriveCompleted();
    }

    public void driveDistance() {
        checkup.start();
    }

    public interface DriveListener {

        public void onDriveCompleted();
    }

    public void run() {
        isRunning = true;
        startTrack();
        startDrive();
        boolean hasDrivenDistance = false;
        while (!hasDrivenDistance) {
            if (getDistanceDriven() >= distance) {
                hasDrivenDistance = true;
            } else {
                try {
                    Thread.sleep(threadPollInterval);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        endDrive();
        isRunning = false;
    }
}
