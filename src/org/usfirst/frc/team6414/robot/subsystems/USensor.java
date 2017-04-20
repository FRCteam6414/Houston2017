//package org.usfirst.frc.team6414.robot.subsystems;

//import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6414.robot.RobotMap;
//import org.usfirst.frc.team6414.robot.commands.USensorMonitor;
//
///**
// * Created by willson on 2017/3/11.
// *
// * @author willson
// *         published under GNU Protocol
// */
//public class USensor extends Subsystem {
//
//    private Ultrasonic l = new Ultrasonic(RobotMap.LEFT_PULSE,RobotMap.LEFT_ECHO);
//    private Ultrasonic r = new Ultrasonic(RobotMap.RIGHT_PULSE,RobotMap.RIGHT_ECHO);
//
//    public USensor() {
//        l.setAutomaticMode(true);
//        r.setAutomaticMode(true);
//    }
//
//    private double square(double in) {
//        return in * in;
//    }
//
//    public double getLeftDistant() {
//        return l.getRangeMM()/10;
//    }
//
//    public double getRightDistant() {
//        return r.getRangeMM()/10;
//    }
//
//    public double getDistant() {
//        return (0.5 * RobotMap.SENSOR_DIST * (l.getRangeMM()/10 + r.getRangeMM()/10))
//                / Math.sqrt(square(RobotMap.SENSOR_DIST)
//                + square(l.getRangeMM()/10 - r.getRangeMM()/10));
//    }
//
//    @Override
//    protected void initDefaultCommand() {
//        setDefaultCommand(new USensorMonitor());
//    }
//}
//
//