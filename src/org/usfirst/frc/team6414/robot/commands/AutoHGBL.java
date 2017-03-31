package org.usfirst.frc.team6414.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6414.robot.Robot;


/**
 * Created by willson on 2017/3/8.
 *
 * @author willson
 *         published under GNU Protocol
 */
public class AutoHGBL extends Command {

    private boolean isFinished = false;
    private AutoState nextState = AutoState.HANG_GEAR;
    private Command currentCommand;

    public AutoHGBL() {
        requires(Robot.chassis);
    }

    private enum AutoState{
        HANG_GEAR,
        TURN,
        FORWARD,
        STOP;

        public AutoState getNext(){
            switch(this){
                case HANG_GEAR:
                    return TURN;
                case TURN:
                    return FORWARD;
                case FORWARD:
                case STOP:
                default:
                    return STOP;
            }
        }
    }

    private void startNextCommand(){
        switch(nextState){
            case HANG_GEAR:
                currentCommand=new AutoHangGear();
                break;
            case TURN:
                currentCommand=new Command(){
                    private boolean isFinished = false;

                    protected void execute() {
                        double time = this.timeSinceInitialized();
                        if(time<1){
                            Robot.chassis.move(0,-0.5);     //back
                        }else if(time<2){
                            Robot.chassis.move(0.5,0);      //turn
                        }else if(time<4){
                            Robot.chassis.move(0,0.5);      //front
                        }else if(time<5){
                            Robot.chassis.move(-0.5,0);     //turn-rev
                        }else{
                            Robot.chassis.move(0,0);
                            isFinished=true;
                        }
                    }

                    @Override
                    protected boolean isFinished() {
                        return isFinished;
                    }
                };
                break;
            case FORWARD:
                currentCommand=new Command(){
                    private boolean isFinished = false;

                    protected void execute() {
                        double time = this.timeSinceInitialized();
                        if(time<5){
                            Robot.chassis.move(0,0.5);      //front-baseline
                        }else{
                            Robot.chassis.move(0,0);
                            isFinished=true;
                        }
                    }

                    @Override
                    protected boolean isFinished() {
                        return isFinished;
                    }
                };
                break;
            case STOP:
            default:
                currentCommand.cancel();
                isFinished=true;
                break;
        }
        currentCommand.start();
        nextState = nextState.getNext();
    }

    /**
     * The initialize method is called just before the first time
     * this Command is run after being started.
     */
    protected void initialize() {
        startNextCommand();
    }

    /**
     * The execute method is called repeatedly when this Command is
     * scheduled to run until this Command either finishes or is canceled.
     */
    protected void execute() {
        if(!currentCommand.isRunning()){
            startNextCommand();
        }
    }


    /**
     *
     * @return whether this command is finished.
     * @see Command#isTimedOut() isTimedOut()
     */
    protected boolean isFinished() {
        return isFinished;
    }


    /**
     * Called once when the command ended peacefully; that is it is called once
     * after {@link #isFinished()} returns true. This is where you may want to
     * wrap up loose ends, like shutting off a motor that was being used in the
     * command.
     */
    protected void end() {

    }


    /**
     * <p>
     * Called when the command ends because somebody called {@link #cancel()} or
     * another command shared the same requirements as this one, and booted it out. For example,
     * it is called when another command which requires one or more of the same
     * subsystems is scheduled to run.
     * </p><p>
     * This is where you may want to wrap up loose ends, like shutting off a motor that was being
     * used in the command.
     * </p><p>
     * Generally, it is useful to simply call the {@link #end()} method within this
     * method, as done here.
     * </p>
     */
    protected void interrupted() {
        super.interrupted();
    }
}
