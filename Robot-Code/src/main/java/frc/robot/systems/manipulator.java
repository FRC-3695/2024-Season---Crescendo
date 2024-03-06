package frc.robot.systems;
import frc.robot.Robot;                                         // Core Robot
import frc.robot.Constants.shooter;
import frc.robot.Constants;                                     // Cross Robot Varriables Centralized
// WPILib  Libraries
// Adds Smart Dashboard Capabilities
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class manipulator {
    private manipulator() {}
    public static final void setup() {

    }
    public static final void controlPeriodic() {

    }
    private static void intake_deploy() {                       // Deploys intake 

    }
    private static void intake_retract() {                      // Retracts intake

    }
    private static void intake_feed() {                         // Runs feeder on intake until ring is pulled in

    }
    private static void intake_clear() {                        // Reverses feeder on intake and completes a couple clearing cycles

    }
    private static void shooter_spinUp() {                      // Spins up motor to set RPM with PID

    }
    private static void shooter_spinDown() {                    // Spins down gracefully

    }
    public static final void motorSetup() {                     // Sets up parameters for intake & shooter motor controllers
        //  *************************   Intake Setup  *************************
        // Zeroing motor settings
        Robot.intake_position_motor.restoreFactoryDefaults();
        Robot.intake_feeder_motor.restoreFactoryDefaults();
        // Setting PID Loop Feed Back Devices
        // <>-<>-<>
        //  *************************  Shooter Setup  *************************
        // Zeroing motor settings
        Robot.shooter_left_motor.restoreFactoryDefaults();
        Robot.shooter_right_motor.restoreFactoryDefaults();
        // Reversing correct motor for forward operation
        Robot.shooter_left_motor.setInverted(Constants.shooter.rev_left);
        Robot.shooter_right_motor.setInverted(Constants.shooter.rev_right);
        // Setting PID Loop Feed Back Devices
        Robot.shooter_left_PID.setFeedbackDevice(Robot.shooter_left_encoder);
        Robot.shooter_right_PID.setFeedbackDevice(Robot.shooter_right_encoder);
        // Setting Encoders polling time
        Robot.shooter_left_encoder.setMeasurementPeriod(100);
        Robot.shooter_right_encoder.setMeasurementPeriod(100);
        // Loading Base PIDs into Motors
        Robot.shooter_left_PID.setP(Constants.shooter.tuning_P);            Robot.shooter_right_PID.setP(Constants.shooter.tuning_P);
        Robot.shooter_left_PID.setI(Constants.shooter.tuning_I);            Robot.shooter_right_PID.setI(Constants.shooter.tuning_I);
        Robot.shooter_left_PID.setD(Constants.shooter.tuning_D);            Robot.shooter_right_PID.setD(Constants.shooter.tuning_D);
        Robot.shooter_left_PID.setIZone(Constants.shooter.tuning_Iz);       Robot.shooter_right_PID.setIZone(Constants.shooter.tuning_Iz);
        Robot.shooter_left_PID.setFF(Constants.shooter.tuning_FF);          Robot.shooter_right_PID.setFF(Constants.shooter.tuning_FF);
    }
    public static final void zeroIntake() {                     // Zeros home for intake
        while (!Robot.intake_retract_DIO.get()) {
            Robot.intake_position_motor.set(Constants.intake.rotation_cal);
        }
        Robot.intake_position_motor.set(0);
        while (Robot.intake_retract_DIO.get()) {
            Robot.intake_position_motor.set(Constants.intake.rotation_cal);
        }
    }
    // -----------------------  Test periodics and code  -----------------------
    public static final void dashboard_start() {
        SmartDashboard.putNumber("Shooter P", Constants.shooter.tuning_P);
        SmartDashboard.putNumber("Shooter I", Constants.shooter.tuning_I);
        SmartDashboard.putNumber("Shooter D", Constants.shooter.tuning_D);
        SmartDashboard.putNumber("Shooter I Zone", Constants.shooter.tuning_Iz);
        SmartDashboard.putNumber("Shooter FF", Constants.shooter.tuning_FF);
        SmartDashboard.putNumber("Shooter RPM", Constants.shooter.tuning_RPM);
        SmartDashboard.putNumber("Shooter Running RPM Left", Robot.shooter_left_encoder.getVelocity());
        SmartDashboard.putNumber("Shooter Running RPM Right", Robot.shooter_right_encoder.getVelocity());
    }
    public static final void dashboard_renew() {
        if (Constants.shooter.tuning_P != SmartDashboard.getNumber("Shooter P", Constants.shooter.tuning_P)) {
            Constants.shooter.tuning_P = SmartDashboard.getNumber("Shooter P", 0);
            Robot.shooter_left_PID.setP(Constants.shooter.tuning_P);            Robot.shooter_right_PID.setP(Constants.shooter.tuning_P);
        }
        if (Constants.shooter.tuning_I != SmartDashboard.getNumber("Shooter I", Constants.shooter.tuning_I)) {
            Constants.shooter.tuning_I = SmartDashboard.getNumber("Shooter I", 0);
            Robot.shooter_left_PID.setI(Constants.shooter.tuning_I);            Robot.shooter_right_PID.setI(Constants.shooter.tuning_I);
        }
        if (Constants.shooter.tuning_D != SmartDashboard.getNumber("Shooter D", Constants.shooter.tuning_D)) {
            Constants.shooter.tuning_D = SmartDashboard.getNumber("Shooter D", 0);
            Robot.shooter_left_PID.setD(Constants.shooter.tuning_D);            Robot.shooter_right_PID.setD(Constants.shooter.tuning_D);
        }
        if (Constants.shooter.tuning_Iz != SmartDashboard.getNumber("Shooter I Zone", Constants.shooter.tuning_Iz)) {
            Constants.shooter.tuning_Iz = SmartDashboard.getNumber("Shooter I Zone", 0);
            Robot.shooter_left_PID.setIZone(Constants.shooter.tuning_Iz);       Robot.shooter_right_PID.setIZone(Constants.shooter.tuning_Iz);
        }
        if (Constants.shooter.tuning_FF != SmartDashboard.getNumber("Shooter FF", Constants.shooter.tuning_FF)) {
            Constants.shooter.tuning_FF = SmartDashboard.getNumber("Shooter FF", 0);
            Robot.shooter_left_PID.setFF(Constants.shooter.tuning_FF);          Robot.shooter_right_PID.setFF(Constants.shooter.tuning_FF);
        }
        if (Constants.shooter.tuning_RPM != SmartDashboard.getNumber("Shooter RPM", Constants.shooter.tuning_RPM)) {
            Constants.shooter.tuning_RPM = SmartDashboard.getNumber("Shooter RPM", 0);
            if(Robot.shooter_left_motor.get() != 0 && Robot.shooter_right_motor.get() != 0) {
                // Set RPM
            }
        } else {
            SmartDashboard.putNumber("Shooter Running RPM Left", Constants.shooter.tuning_RPM);
            SmartDashboard.putNumber("Shooter Running RPM Right", Constants.shooter.tuning_RPM);
        }
    }
    public static final void dashboard_DIO() {
        SmartDashboard.putNumber("Shooter Running RPM Left", Robot.shooter_left_encoder.getVelocity());
        SmartDashboard.putNumber("Shooter Running RPM Right", Robot.shooter_right_encoder.getVelocity());
    }
}
