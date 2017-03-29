package org.usfirst.frc.team6414.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static final int CHASSIS_ADJUST = 2;             //Buttons & sticks
    public static final int INTAKE_FWD = 3;
    public static final int INTAKE_BWD = 5;
    static final int STICK = 0;

    public static final int RIGHT_MASTER = 1;               //Motors
    public static final int RIGHT_SLAVE = 2;
    public static final int LEFT_MASTER = 3;
    public static final int LEFT_SLAVE = 4;
    public static final int CLIMBER_MOTOR = 5;
    public static final int CHASSIS_REV = 10;

    public static final double INTAKE_DEF = 1;              //Default speed
    public static final double AUTO_DEF_SPEED = 0.5;

    public static final double US_PULSE = 0.00001;          //others
    public static final int LEFT_ECHO = 0;
    public static final int LEFT_PULSE = 1;
    public static final int RIGHT_ECHO = 2;
    public static final int RIGHT_PULSE = 3;
    public static final double SPEED_OF_SOUND = 340;
    public static final double SENSOR_DIST = 100;
    public static final double START_DISTANT = 300;
    public static final double AUTO_TIMEOUT = 2.5;
    public static final double AUTO_TIMEOUT2 = 5;
    public static final boolean USING_U_SENSOR = true;
}
