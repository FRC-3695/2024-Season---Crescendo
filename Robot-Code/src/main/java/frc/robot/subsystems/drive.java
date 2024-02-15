package frc.robot.subsystems;
import frc.robot.Constants;           // Constants to pass can IDs along to subsystem

import edu.wpi.first.wpilibj2.command.SubsystemBase;    // System to be extended by this subsystem
// Lib for SparkMax Motor Controllers
import com.revrobotics.CANSparkMax;                     // SparkMax
import com.revrobotics.CANSparkBase.ExternalFollower;   // REVLib Follow
import com.revrobotics.CANSparkLowLevel.MotorType;      // REVLib MotorType
import com.revrobotics.RelativeEncoder;                 // REVLib Relative Encoder
// WPI Lib Functions
import edu.wpi.first.math.geometry.Pose2d;              // Updates 2D field map for SmartDash
import edu.wpi.first.wpilibj.Encoder;                   // Encoder Functions Supplied


public class drive extends SubsystemBase{
    // Defining Creation of drive motor controllers
    private final CANSparkMax robot_drive_leftMaster = 
        new CANSparkMax(Constants.robotConstants.motor_drive_leftFront, MotorType.kBrushless);
    private final CANSparkMax robot_drive_leftSlave = 
        new CANSparkMax(Constants.robotConstants.motor_drive_leftRear, MotorType.kBrushless);
    private final CANSparkMax robot_drive_rightMaster = 
        new CANSparkMax(Constants.robotConstants.motor_drive_rightFront, MotorType.kBrushless);
    private final CANSparkMax robot_drive_rightSlave = 
        new CANSparkMax(Constants.robotConstants.motor_drive_rightRear, MotorType.kBrushless);
    // Defining Encoders for Functions
    private RelativeEncoder robot_drive_encoderLeft =
        robot_drive_leftMaster.getEncoder();
    private RelativeEncoder robot_drive_encoderRight =
        robot_drive_rightMaster.getEncoder();

    public void driveStart() {
        setupFollowers();
        startEncoders();
    }
    @Override
    public void periodic() {

    }
    /*public Pose2d getPose() {

    }*/
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
        robot_drive_encoderLeft.getInverted();
        robot_drive_encoderRight.getInverted();
    }
}
