package org.usfirst.frc.team6414.robot.subsystems;

import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6414.robot.Robot;
import org.usfirst.frc.team6414.robot.RobotMap;
import org.usfirst.frc.team6414.robot.commands.Climb;

import static org.usfirst.frc.team6414.robot.subsystems.Climber.State.STOP;

/**
 *
 */
public class Climber extends MonitoredSystem {

//    private CANTalon climbMotor = new CANTalon(RobotMap.CLIMBER_MOTOR);
    private State state = STOP;
    private boolean privFwdButState = false, privBwdButState = false;

    enum State {
        FORWARD,
        BACKWARD,
        STOP;

        public State fwdPressed() {
            if (this == FORWARD) {
                return STOP;
            } else {
                return FORWARD;
            }
        }

        public State bwdPressed() {
            if (this == BACKWARD) {
                return STOP;
            } else {
                return BACKWARD;
            }
        }
    }

    public Climber() {
        super();
        System.out.println("Climb sub system init");
        threadInit(() -> SmartDashboard.putNumber("Climb speed:", 1/*climbMotor.get()*/));
    }

    public void climb() {
        switch (state) {
            case BACKWARD:
//                climbMotor.set(-RobotMap.INTAKE_DEF);
                break;

            case FORWARD:
//                climbMotor.set(RobotMap.INTAKE_DEF);
                break;

            case STOP:
            default:
//                climbMotor.set(0);
//                break;
        }
        if (Robot.oi.getButtonState(RobotMap.INTAKE_FWD) != privFwdButState) {
            privFwdButState = !privFwdButState;
            if (privFwdButState) {
                state = state.fwdPressed();
            }
        }
        if (Robot.oi.getButtonState(RobotMap.INTAKE_BWD) != privBwdButState) {
            privBwdButState = !privBwdButState;
            if (privBwdButState) {
                state = state.bwdPressed();
            }
        }
    }

    public void stop() {
//        climbMotor.set(0);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new Climb());
    }
}

