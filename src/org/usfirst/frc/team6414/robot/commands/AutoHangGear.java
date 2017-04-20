//package org.usfirst.frc.team6414.robot.commands;
//
//import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import org.usfirst.frc.team6414.robot.Robot;
//
//import static org.usfirst.frc.team6414.robot.RobotMap.SENSOR_DIST;
//import static org.usfirst.frc.team6414.robot.RobotMap.START_DISTANT;
//
//
///**
// * Created by willson on 2017/3/8.
// *
// * @author willson
// *         published under GNU Protocol
// */
//public class AutoHangGear extends Command {
//
//    public AutoHangGear() {
//        requires(Robot.chassis);
//    }
//
//    /**
//     * The initialize method is called just before the first time
//     * this Command is run after being started.
//     * make sure robot will stop after 15s
//     */
//    protected void initialize() {
//        this.setTimeout(HG_TIMEOUT);
//    }
//
//    /*
//     * constructor
//     * speed: max=1, min=0, f'(x)=-2sqrt(a)/(2sqrt(-x+a))
//     * f(x)=sqrt(-x+a)/sqrt(a) => sqrt(-x/a+1)
//     *
//     * @param distant distant form robot to the wall of control station (average)
//     * @return the speed it should go at a certain distance. Closer, slower.
//     */
//    private double getSpeed(double distant) {
//        return 0.5*Math.sqrt((START_DISTANT-distant )/ START_DISTANT );
//    }
//
//    /*
//     * get turning speed
//     *
//     * @return From 0.5 to -0.5. Reach Max / Min when perform a 45 degree angle to the wall
//     */
//    private double getRotate() {
//        return Robot.limit(-1, 1,
//                (Robot.uSensor.getRightDistant() - Robot.uSensor.getLeftDistant())*5
//                        /  (Math.sqrt(2)* SENSOR_DIST));
//    }
//
//    /**
//     * The execute method is called repeatedly when this Command is
//     * scheduled to run until this Command either finishes or is canceled.
//     * Make robot go at the speed we calculated above
//     */
//    protected void execute() {
//        Robot.chassis.move(getRotate(),getSpeed(Robot.uSensor.getDistant()));
//        SmartDashboard.putNumber("speed",getSpeed(Robot.uSensor.getDistant()) );
//        SmartDashboard.putNumber("Rotate",getRotate());
//        Robot.chassis.stop();
//    }
//
//
//    /**
//     * Die at time out
//     *
//     * @return whether this command is finished.
//     * @see Command#isTimedOut() isTimedOut()
//     */
//    protected boolean isFinished() {
//        return USING_U_SENSOR ?Robot.uSensor.getDistant()<=10:isTimedOut();
//        return false;
//    }
//
//
//    /**
//     * Called once when the command ended peacefully; that is it is called once
//     * after {@link #isFinished()} returns true. This is where you may want to
//     * wrap up loose ends, like shutting off a motor that was being used in the
//     * command.
//     * Stop the chassis for safty reason
//     */
//    protected void end() {
//        Robot.chassis.stop();
//    }
//
//
//    /**
//     * <p>
//     * Called when the command ends because somebody called {@link #cancel()} or
//     * another command shared the same requirements as this one, and booted it out. For example,
//     * it is called when another command which requires one or more of the same
//     * subsystems is scheduled to run.
//     * </p><p>
//     * This is where you may want to wrap up loose ends, like shutting off a motor that was being
//     * used in the command.
//     * </p><p>
//     * Generally, it is useful to simply call the {@link #end()} method within this
//     * method, as done here.
//     * </p>
//     */
//    protected void interrupted() {
//        super.interrupted();
//    }
//}
