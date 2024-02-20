package frc.robot.subsystems;
import frc.robot.Constants;                             // Constants to pass can IDs along to subsystem

import edu.wpi.first.wpilibj2.command.SubsystemBase;    // System to be extended by this subsystem
// WPI Lib Functions
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;            // Adds support for Xbox controller
// Lib for SparkMax Motor Controllers
import com.revrobotics.CANSparkMax;                     // SparkMAX CAN Map
import com.revrobotics.CANSparkLowLevel.MotorType;      // REVLib MotorType
import com.revrobotics.RelativeEncoder;                 // REVLib Relative Encoder
import com.revrobotics.SparkPIDController;              // REVLib SparkPID Control

public class lifter extends SubsystemBase {
    // Defining Motor Controllers
    private final CANSparkMax lifter_left_motor =
        new CANSparkMax(Constants.IDs.lifter_left_motor, MotorType.kBrushless);
    private final CANSparkMax lifter_right_motor =
        new CANSparkMax(Constants.IDs.lifter_right_motor, MotorType.kBrushless);
    // Defining Sensors
    private final RelativeEncoder lifter_left_encoder =
        lifter_left_motor.getEncoder();
    private final RelativeEncoder lifter_right_encoder =
        lifter_right_motor.getEncoder();
    private final DigitalInput lifter_left_DIO =
        new DigitalInput(Constants.IDs.lifter_left_sensor);
    private final DigitalInput lifter_right_DIO =
        new DigitalInput(Constants.IDs.lifter_right_sensor);
    // Defining Secondary xBox Controller
    private final XboxController drivestation_operator =
        new XboxController(Constants.operator.controller_xBox_manip);
    // PID Controllers
    private final SparkPIDController lifter_left_PID =
        lifter_left_motor.getPIDController();
    private final SparkPIDController lifter_right_PID =
        lifter_right_motor.getPIDController();

    public lifter() {
        setupMotors();
        zeroEncoders();

    }
    @Override
    public void periodic() {  // Periodic to lock onto controller buttons assigned to secondary controller
        
    }
    private void armDeploy() {  // Extends Lifter out to latch onto chain

    }
    private void armsRetract() {  // Retracts Lifter in body of robot

    }
    private void setupMotors() {  // Sets up motors with reversing and PID Data
        // Restore Factory Defaults
        lifter_left_motor.restoreFactoryDefaults();
        lifter_right_motor.restoreFactoryDefaults();
        // Set Inversion
        lifter_left_motor.setInverted(false);
        lifter_right_motor.setInverted(false);
        // Set PIDs Encoders
        lifter_left_PID.setFeedbackDevice(lifter_left_encoder);
        lifter_right_PID.setFeedbackDevice(lifter_right_encoder);
        // Set PIDs for each PID
        lifter_left_PID.setP(Constants.lifter.tuning_P);            lifter_right_PID.setP(Constants.lifter.tuning_P);
        lifter_left_PID.setI(Constants.lifter.tuning_I);            lifter_right_PID.setI(Constants.lifter.tuning_I);
        lifter_left_PID.setD(Constants.lifter.tuning_D);            lifter_right_PID.setD(Constants.lifter.tuning_D);
        lifter_left_PID.setIZone(Constants.lifter.tuning_Iz);       lifter_right_PID.setIZone(Constants.lifter.tuning_Iz);
        lifter_left_PID.setFF(Constants.lifter.tuning_FF);          lifter_right_PID.setFF(Constants.lifter.tuning_FF);
        lifter_left_PID.setOutputRange(Constants.lifter.tuning_speedMin, Constants.lifter.tuning_speedMax);        
        lifter_right_PID.setOutputRange(Constants.lifter.tuning_speedMin, Constants.lifter.tuning_speedMax);
    }
    private void zeroEncoders() { // Re-Homes lifter and Zeros motor controller's encoder's
        if(!lifter_left_DIO.get() || !lifter_right_DIO.get()) { // If already home
            lifter_left_encoder.setPosition(0);
            lifter_right_encoder.setPosition(0);
        } else {
            lifter_left_PID.setReference(Constants.lifter.rotation_calibration, CANSparkMax.ControlType.kPosition);
            lifter_right_PID.setReference(Constants.lifter.rotation_calibration, CANSparkMax.ControlType.kPosition);
            while(true) {
                if (!lifter_left_DIO.get()) {
                    lifter_left_motor.set(0);
                    lifter_left_encoder.setPosition(0);
                }
                if (!lifter_right_DIO.get()) {
                    lifter_right_motor.set(0);
                    lifter_right_encoder.setPosition(0);
                }
                if (!lifter_left_DIO.get() || !lifter_right_DIO.get()) {break;}
            }
        }
        
    }
}
