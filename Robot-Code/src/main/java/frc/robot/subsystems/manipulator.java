package frc.robot.subsystems;
import frc.robot.Constants;

// Lib for SparkMax Motor Controllers
import com.revrobotics.CANSparkMax;                     // SparkMAX CAN Map
import com.revrobotics.CANSparkLowLevel.MotorType;      // REVLib MotorType
import com.revrobotics.RelativeEncoder;                 // REVLib Relative Encoder
import com.revrobotics.SparkPIDController;              // REVLib SparkPID Control

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class manipulator extends SubsystemBase {

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
