package org.usfirst.frc.team6414.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team6414.robot.commands.AutoHGBL;
import org.usfirst.frc.team6414.robot.commands.AutoHangGear;
import org.usfirst.frc.team6414.robot.commands.AutoBaseLine;
import org.usfirst.frc.team6414.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    public static OI oi;
    public static final Chassis chassis = new Chassis();
    public static final Climber Climber = new Climber();
    public static final USensor uSensor = new USensor();

    private Command autonomousCommand;
    private SendableChooser<Command> commandChooser = new SendableChooser<>();
    private SendableChooser<Boolean> uSensorChooser = new SendableChooser<>();

    public static double limit(double min, double max, double input) {
        return input > max ? max
                : input < min ? min
                : input;
    }

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        commandChooser.addDefault("gear", new AutoBaseLine());
        commandChooser.addObject("baseline", new AutoHangGear());
        commandChooser.addObject("gear + baseline", new AutoHGBL());
        SmartDashboard.putData("Auto", commandChooser);

        uSensorChooser.addDefault("use ultrasonic sensor", true);
        uSensorChooser.addObject("don't use ultrasonic sensor", false);
        SmartDashboard.putData("ultrasonic state",uSensorChooser);

        oi = new OI();

        UsbCamera cam = CameraServer.getInstance().startAutomaticCapture(0);
        cam.setResolution(640, 480);
        cam.setFPS(60);
        UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture(1);
        cam1.setResolution(640, 480);
        cam1.setFPS(60);
        SmartDashboard.putString("Robot State:", "started");
        System.out.println("Robot init");

        chassis.setSleepTime(250);
        chassis.startMonitor();

        Climber.startMonitor();

        uSensor.setSleepTime(100);
        uSensor.startMonitor();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {
        chassis.stopMonitor();
        Climber.stopMonitor();
        uSensor.stopMonitor();
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the commandChooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * commandChooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the commandChooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     * <p>
     * You can add additional auto modes by adding additional commands to the
     * commandChooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {
        autonomousCommand = commandChooser.getSelected();
        RobotMap.USING_U_SENSOR = uSensorChooser.getSelected();
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    @Override
    public void testPeriodic() {
        LiveWindow.run();
    }
}
