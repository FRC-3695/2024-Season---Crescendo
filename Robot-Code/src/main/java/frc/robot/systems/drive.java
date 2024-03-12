package frc.robot.systems;
import frc.robot.Robot;                                 // Core Robot
import frc.robot.Constants;                             // Cross Robot Varriables Centralized

import edu.wpi.first.math.MathUtil;                     // Mathematics tools
import edu.wpi.first.util.sendable.SendableRegistry;

public final class drive {
    private drive () {}
    public static void controlPeriodic() {              // Periodic to update drive system states
        Robot.drive_difDrive.feed();
        double robot_drive_x = MathUtil.applyDeadband(
            Robot.drivestation_driver.getRightTriggerAxis()
            -
            Robot.drivestation_driver.getLeftTriggerAxis(),
            Constants.operator.tuning_driver_deadband);
        double robot_drive_y = MathUtil.applyDeadband(
            Robot.drivestation_driver.getLeftX(),
        Constants.operator.tuning_driver_deadband);
        Robot.drive_difDrive.arcadeDrive(robot_drive_x, robot_drive_y);
    }
    public static void self(int left, boolean rev_left, int right, boolean rev_right) {
        double L = ((left-0)/(100-0))*(1-0)+0;
        double R = ((right-0)/(100-0))*(1-0)+0;
        if (rev_left) {L = -L;}
        if (rev_right) {R = -R;}
        Robot.drive_leftMaster.set(L);
        Robot.drive_rightMaster.set(R);
    }
    public static void startup() {                     // Sets up drive motors
        // Reset Motors to factory base for core function settings
        Robot.drive_leftMaster.restoreFactoryDefaults();
        Robot.drive_leftSlave.restoreFactoryDefaults();
        Robot.drive_rightMaster.restoreFactoryDefaults();
        Robot.drive_rightSlave.restoreFactoryDefaults();
        initFollowers();
        SendableRegistry.addChild(Robot.drive_difDrive, Robot.drive_leftMaster);
        SendableRegistry.addChild(Robot.drive_difDrive, Robot.drive_rightMaster);
        Robot.drive_leftMaster.setInverted(Constants.drive.rev_left);
        Robot.drive_rightMaster.setInverted(Constants.drive.rev_right);
        zeroEncoders();
        // Setting PWM safety for Drivetrain and Motor safety time out
        Robot.drive_difDrive.setSafetyEnabled(false);
        Robot.drive_difDrive.setExpiration(1);
    }
    private static void initFollowers() {               // Within this function followers will be defined where a master and slave controller relationship will be defined
        // Setting Followers
        Robot.drive_leftSlave.follow(Robot.drive_leftMaster);
        Robot.drive_rightSlave.follow(Robot.drive_rightMaster);
    }
    private static void zeroEncoders() {                // Sets encoders to zero on init
        Robot.drive_left_encoder.setPosition(0);
        Robot.drive_right_encoder.setPosition(0);
    }
}
