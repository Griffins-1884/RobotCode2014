package org.usfirst.frc1884.util.misc;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public class SingleSolenoidMasqueradingAsDoubleSolenoid {
    private Solenoid solenoid;
    public SingleSolenoidMasqueradingAsDoubleSolenoid(int slot, int port, int notUsed) {
        this.solenoid = new Solenoid(slot, port);
    }
    public void set(DoubleSolenoid.Value val) {
        if(val == DoubleSolenoid.Value.kForward) {
            solenoid.set(true);
        } else if(val == DoubleSolenoid.Value.kReverse) {
            solenoid.set(false);
        }
    }
}