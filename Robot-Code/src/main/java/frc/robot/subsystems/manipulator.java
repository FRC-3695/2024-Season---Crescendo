package frc.robot.subsystems;
import frc.robot.Constants;

// Lib for SparkMax Motor Controllers
import com.revrobotics.CANSparkMax;                     // SparkMAX CAN Map
import com.revrobotics.CANSparkLowLevel.MotorType;      // REVLib MotorType
import com.revrobotics.RelativeEncoder;                 // REVLib Relative Encoder
import com.revrobotics.SparkPIDController;              // REVLib SparkPID Control

import edu.wpi.first.wpilibj.DigitalInput;
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
    private final DigitalInput intake_home_DIO =
        new DigitalInput(Constants.IDs.manupilator_retract_sensor);
    
    public manipulator () { // Core Function

    }
    @Override
    public void periodic () {

    }
    private static void intakeDeploy() {  // Deploys intake 

    }
    private static void intakeRetract() {  // Retracts intake

    }
    private static void intakeFeed() {  // Runs feeder on intake until ring is pulled in

    }
    private static void intakeClear() {  // Reverses feeder on intake and completes a couple clearing cycles

    }
    private static void shooterSpinUp() {  // Spins up motor to set RPM with PID

    }
    private static void shooterSpinDown() {  // Spins down gracefully

    }
    private static void intakeSetup() {  // Sets up parameters for intake sensors and motor controllers

    }
    private static void intakeZero() {  // Zeros home for intake

    }
    private static void shooterSetup() {  // Sets up parameters for shooter motor controllers

    }
}
