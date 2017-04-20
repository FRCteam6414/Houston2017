package org.usfirst.frc.team6414.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6414.robot.Robot;

/**
 *
 */
public class Climb extends Command {

    /**
     * Standard Constructor.
     */
    public Climb() {
        requires(Robot.climber);
    }

    /**
     * o(*￣▽￣*)ブ
     */
    @Override
    protected void initialize() {
        System.out.println("Climb command init");
    }

    /**
     *
     */
    @Override
    protected void execute() {
        Robot.climber.climb();
    }

    /**
     * @return is this comma
     */
    @Override
    protected boolean isFinished() {
        return false;
    }

    /**
     *
     */
    @Override
    protected void end() {
        Robot.climber.stop();
    }

    /**
     *
     */
    @Override
    protected void interrupted() {
    }
}
