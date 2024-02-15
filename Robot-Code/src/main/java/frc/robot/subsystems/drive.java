package frc.robot.subsystems;
import frc.robot.Constants;           // Constants to pass can IDs along to subsystem

import edu.wpi.first.wpilibj2.command.SubsystemBase;    // System to be extended by this subsystem
// Lib for SparkMax Motor Controllers
import com.revrobotics.CANSparkMax;                     // SparkMax
import com.revrobotics.CANSparkBase.ExternalFollower;   // REVLib Follow Library
import com.revrobotics.CANSparkLowLevel.MotorType;      // REVLib MotorType
import com.revrobotics.RelativeEncoder;                 // Relative Encoder CAN Table

public class drive extends SubsystemBase{
    
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
}
