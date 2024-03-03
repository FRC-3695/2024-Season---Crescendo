package frc.robot.subsystems;
import frc.robot.Constants;

// Lib for SparkMax Motor Controllers
import com.revrobotics.CANSparkMax;                     // SparkMAX CAN Map
import com.revrobotics.CANSparkLowLevel.MotorType;      // REVLib MotorType
import com.revrobotics.RelativeEncoder;                 // REVLib Relative Encoder
import com.revrobotics.SparkPIDController;              // REVLib SparkPID Control

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class manipulator extends SubsystemBase {
    // Defining Motor Controllers
    private final CANSparkMax intake_position_motor =
        new CANSparkMax(Constants.IDs.manipulator_posi_motor, MotorType.kBrushless);
    private final CANSparkMax intake_feeder_motor =
        new CANSparkMax(Constants.IDs.manipulator_posi_motor, MotorType.kBrushed);
    private final CANSparkMax shooter_left_motor =
        new CANSparkMax(Constants.IDs.shooter_left_motor, MotorType.kBrushless);
    private final CANSparkMax shooter_right_motor =
        new CANSparkMax(Constants.IDs.shooter_right_motor, MotorType.kBrushless);
    // Defining Encoders
    private final RelativeEncoder intake_position_encoder =
        intake_position_motor.getEncoder();
    private final RelativeEncoder shooter_left_encoder =
        shooter_left_motor.getEncoder();
    private final RelativeEncoder shooter_right_encoder =
        shooter_right_motor.getEncoder();
    // Defining PIDs
    private final SparkPIDController intake_position_PID =
        intake_position_motor.getPIDController();
    private final SparkPIDController shooter_left_PID =
        shooter_left_motor.getPIDController();
    private final SparkPIDController shooter_right_PID =
        shooter_right_motor.getPIDController();
    // Defining Digital IO
    private final DigitalInput intake_retract_DIO =
        new DigitalInput(Constants.IDs.manupilator_sensor_retract);
    private final DigitalInput intake_deploy_DIO =
        new DigitalInput(Constants.IDs.manipulator_sensor_deploy);
    
    public manipulator () { // Core Function
        intakeSetup();
        intakeZero();
        shooterSetup();
        dashboardSetup();
    }
    @Override
    public void periodic () {
        dashboardUpdate();
    }
    private void intakeDeploy() {  // Deploys intake 

    }
    private void intakeRetract() {  // Retracts intake

    }
    private void intakeFeed() {  // Runs feeder on intake until ring is pulled in

    }
    private void intakeClear() {  // Reverses feeder on intake and completes a couple clearing cycles

    }
    private void shooterSpinUp() {  // Spins up motor to set RPM with PID

    }
    private void shooterSpinDown() {  // Spins down gracefully

    }
    private void intakeSetup() {  // Sets up parameters for intake sensors and motor controllers
        // Zeroing motor settings
        intake_position_motor.restoreFactoryDefaults();
        intake_feeder_motor.restoreFactoryDefaults();
        // Setting PID Loop Feed Back Devices
        
    }
    private void intakeZero() {  // Zeros home for intake

    }
    private void shooterSetup() {  // Sets up parameters for shooter motor controllers
        // Zeroing motor settings
        shooter_left_motor.restoreFactoryDefaults();
        shooter_right_motor.restoreFactoryDefaults();
        // Reversing correct motor for forward operation
        shooter_left_motor.setInverted(Constants.shooter.rev_left);
        shooter_right_motor.setInverted(Constants.shooter.rev_right);
        // Setting PID Loop Feed Back Devices
        shooter_left_PID.setFeedbackDevice(shooter_left_encoder);
        shooter_right_PID.setFeedbackDevice(shooter_right_encoder);
        // Loading Base PIDs into Motors
        shooter_left_PID.setP(Constants.shooter.tuning_P);            shooter_right_PID.setP(Constants.shooter.tuning_P);
        shooter_left_PID.setI(Constants.shooter.tuning_I);            shooter_right_PID.setI(Constants.shooter.tuning_I);
        shooter_left_PID.setD(Constants.shooter.tuning_D);            shooter_right_PID.setD(Constants.shooter.tuning_D);
        shooter_left_PID.setIZone(Constants.shooter.tuning_Iz);       shooter_right_PID.setIZone(Constants.shooter.tuning_Iz);
        shooter_left_PID.setFF(Constants.shooter.tuning_FF);          shooter_right_PID.setFF(Constants.shooter.tuning_FF);
    }
    private void dashboardSetup() {
        SmartDashboard.putNumber("Shooter P", Constants.shooter.tuning_P);
        SmartDashboard.putNumber("Shooter I", Constants.shooter.tuning_I);
        SmartDashboard.putNumber("Shooter D", Constants.shooter.tuning_D);
        SmartDashboard.putNumber("Shooter I Zone", Constants.shooter.tuning_Iz);
        SmartDashboard.putNumber("Shooter FF", Constants.shooter.tuning_FF);
        SmartDashboard.putNumber("Shooter RPM", Constants.shooter.tuning_RPM);
    }
    private void dashboardUpdate() {
        if (Constants.shooter.tuning_P != SmartDashboard.getNumber("Shooter P", Constants.shooter.tuning_P)) {
            Constants.shooter.tuning_P = SmartDashboard.getNumber("Shooter P", 0);
            shooter_left_PID.setP(Constants.shooter.tuning_P);            shooter_right_PID.setP(Constants.shooter.tuning_P);
        }
        if (Constants.shooter.tuning_I != SmartDashboard.getNumber("Shooter I", Constants.shooter.tuning_I)) {
            Constants.shooter.tuning_I = SmartDashboard.getNumber("Shooter I", 0);
            shooter_left_PID.setI(Constants.shooter.tuning_I);            shooter_right_PID.setI(Constants.shooter.tuning_I);
        }
        if (Constants.shooter.tuning_D != SmartDashboard.getNumber("Shooter D", Constants.shooter.tuning_D)) {
            Constants.shooter.tuning_D = SmartDashboard.getNumber("Shooter D", 0);
            shooter_left_PID.setD(Constants.shooter.tuning_D);            shooter_right_PID.setD(Constants.shooter.tuning_D);
        }
        if (Constants.shooter.tuning_Iz != SmartDashboard.getNumber("Shooter I Zone", Constants.shooter.tuning_Iz)) {
            Constants.shooter.tuning_Iz = SmartDashboard.getNumber("Shooter I Zone", 0);
            shooter_left_PID.setIZone(Constants.shooter.tuning_Iz);       shooter_right_PID.setIZone(Constants.shooter.tuning_Iz);
        }
        if (Constants.shooter.tuning_FF != SmartDashboard.getNumber("Shooter FF", Constants.shooter.tuning_FF)) {
            Constants.shooter.tuning_FF = SmartDashboard.getNumber("Shooter FF", 0);
            shooter_left_PID.setFF(Constants.shooter.tuning_FF);          shooter_right_PID.setFF(Constants.shooter.tuning_FF);
        }
        if (Constants.shooter.tuning_RPM != SmartDashboard.getNumber("Shooter RPM", Constants.shooter.tuning_RPM)) {
            Constants.shooter.tuning_RPM = SmartDashboard.getNumber("Shooter RPM", 0);
        }
    }
}
