package frc.robot.subsystems;
import frc.robot.Constants;                             // Constants to pass can IDs along to subsystem

import edu.wpi.first.wpilibj2.command.SubsystemBase;    // System to be extended by this subsystem
// Lib for SparkMax Motor Controllers
import com.revrobotics.CANSparkMax;                     // SparkMax
import com.revrobotics.CANSparkLowLevel.MotorType;      // REVLib MotorType
import com.revrobotics.RelativeEncoder;                 // REVLib Relative Encoder
// WPI Lib Functions
import edu.wpi.first.math.geometry.Pose2d;              // Updates 2D field map for SmartDash
import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.XboxController;            // Adds support for Xbox controller
import edu.wpi.first.wpilibj.drive.DifferentialDrive;   // Introducing Prebuilt drivecontroller
import edu.wpi.first.math.MathUtil;                     // Mathematics tools

public class driveSys extends SubsystemBase{
    // Defining Creation of drive motor controllers
    private final CANSparkMax robot_drive_leftMaster = 
        new CANSparkMax(Constants.IDs.drive_leftFront_motor, MotorType.kBrushless);
    private final CANSparkMax robot_drive_leftSlave = 
        new CANSparkMax(Constants.IDs.drive_leftRear_motor, MotorType.kBrushless);
    private final CANSparkMax robot_drive_rightMaster = 
        new CANSparkMax(Constants.IDs.drive_rightFront_motor, MotorType.kBrushless);
    private final CANSparkMax robot_drive_rightSlave = 
        new CANSparkMax(Constants.IDs.drive_rightRear_motor, MotorType.kBrushless);
    // Defining Encoders for Functions
    private RelativeEncoder robot_drive_encoderLeft =
        robot_drive_leftMaster.getEncoder();
    private RelativeEncoder robot_drive_encoderRight =
        robot_drive_rightMaster.getEncoder();
    // Defining Driver Controller
    private final XboxController drivestation_driver =
        new XboxController(Constants.operator.controller_xBox_driver);
    // Defining diferential drivesystem
    private final DifferentialDrive robot_drive_difDrive =
        new DifferentialDrive(robot_drive_leftMaster::set, robot_drive_rightMaster::set);
    public driveSys() {
        startDrive();
        setupFollowers();
        startEncoders();
    }
    @Override
    public void periodic() {
        drivePeriodic();

    }
    public void startDrive() {
        SendableRegistry.addChild(robot_drive_difDrive, robot_drive_leftMaster);
        SendableRegistry.addChild(robot_drive_difDrive, robot_drive_rightMaster);
        robot_drive_leftMaster.setInverted(true);
        robot_drive_rightMaster.setInverted(false);
    }
    public void drivePeriodic() {
        double robot_drive_x = MathUtil.applyDeadband(
            drivestation_driver.getRightTriggerAxis()
            -
            drivestation_driver.getLeftTriggerAxis(),
            0.05);
        double robot_drive_y = MathUtil.applyDeadband(
            drivestation_driver.getLeftX(),
        0.05);
        robot_drive_difDrive.arcadeDrive(robot_drive_x, robot_drive_y);
    }
    private void setupFollowers() { // Within this function followers will be defined where a master and slave controller relationship will be defined
        // Reset Motors to factory base for core function settings
        robot_drive_leftMaster.restoreFactoryDefaults();
        robot_drive_leftSlave.restoreFactoryDefaults();
        robot_drive_rightMaster.restoreFactoryDefaults();
        robot_drive_rightSlave.restoreFactoryDefaults();
        // Setting Followers
        robot_drive_leftSlave.follow(robot_drive_leftMaster);
        robot_drive_rightSlave.follow(robot_drive_rightMaster);
    }
    private void startEncoders() {
        robot_drive_encoderLeft.setPosition(0);
        robot_drive_encoderRight.setPosition(0);
    }
}
