package frc.robot.subsystems;
import frc.robot.Constants;                             // Constants to pass can IDs along to subsystem

import edu.wpi.first.wpilibj2.command.SubsystemBase;    // System to be extended by this subsystem
// WPI Lib Functions
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
// Lib for SparkMax Motor Controllers
import com.revrobotics.CANSparkMax;                     // SparkMax
import com.revrobotics.CANSparkLowLevel.MotorType;      // REVLib MotorType
import com.revrobotics.RelativeEncoder;                 // REVLib Relative Encoder

public class lifter extends SubsystemBase {
    // Defining Motor Controllers
    private final CANSparkMax motor_lifter_left =
        new CANSparkMax(Constants.IDs.motor_lifterLeft, MotorType.kBrushless);
    private final CANSparkMax motor_lifter_right =
        new CANSparkMax(Constants.IDs.motor_lifterRight, MotorType.kBrushless)
    // Defining Sensors
    private final RelativeEncoder encoder_lifter_left =
        motor_lifter_left.getEncoder();
    private final RelativeEncoder encoder_lifter_right =
        motor_lifter_right.getEncoder();
    

    public lifter() {

    }
    @Override
    public void periodic() {
        
    }
}
