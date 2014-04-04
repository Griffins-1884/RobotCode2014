package org.usfirst.frc1884.robot.oi;

public class OI {
    public static final int DRIVE_FORWARD = 0,
                            DRIVE_COUNTERCLOCKWISE = 1;
    public static final int SHOOTER_FIRE = 0,
                            SHOOTER_RELOAD = 1,
                            FEEDER_INTAKE = 2,
                            FEEDER_EXTEND = 3,
                            FEEDER_OUTTAKE = 5,
                            SWITCH_GEAR = 7,
                            FLIP_DRIVE = 8,
                            LOW_GEAR = 9,
                            KEEP_DRIVE_REVERSED = 10;
    
    public static void poll() {
        SteerController.poll();
    }
    
    private static double[] analogValues = new double[100];
    public static double getAnalogValue(int constant) {
        return analogValues[constant];
    }
    protected static void setAnalogValue(int constant, double value) {
        analogValues[constant] = value;
    }
    private static byte[] booleanValues = new byte[100];
    public static boolean isBooleanTrue(int constant) {
        return (booleanValues[constant] & 0x1) > 0;
    }
    public static boolean isBooleanChanged(int constant) {
        boolean result = (booleanValues[constant] & 0x2) > 0;
        booleanValues[constant] &= ~0x2;
        return result;
    }
    protected static void setBooleanValue(int constant, boolean value) {
        if(isBooleanTrue(constant) != value) {
            booleanValues[constant] = (byte) (0x2 | ((value) ? 0x1 : 0x0));
        }
    }
    public static boolean whenPressed(int constant) {
        return isBooleanTrue(constant) && isBooleanChanged(constant);
    }
    public static boolean whenReleased(int constant) {
        return !isBooleanTrue(constant) && isBooleanChanged(constant);
    }
    public static boolean whileHeld(int constant) {
        return isBooleanTrue(constant);
    }
}