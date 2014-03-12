package org.usfirst.frc1884.robot.commands;

import java.util.Vector;

public class Commands {
    private static Vector commands = new Vector();
    public static void registerCommand(Command c) {
        commands.addElement(c);
    }
    public static void executeAllCommands() {
        for(int i = 0; i < commands.size(); i++) {
            Command c = (Command) commands.elementAt(i);
            c.execute();
        }
    }
}