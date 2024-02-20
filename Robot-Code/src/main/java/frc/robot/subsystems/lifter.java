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
    private final CANSparkMax lifter_left_motor =
        new CANSparkMax(Constants.IDs.lifter_left_motor, MotorType.kBrushless);
    private final CANSparkMax lifter_right_motor =
        new CANSparkMax(Constants.IDs.lifter_right_motor, MotorType.kBrushless);
    // Defining Sensors
    private final RelativeEncoder lifter_left_encoder =
        lifter_left_motor.getEncoder();
    private final RelativeEncoder lifter_right_encoder =
        lifter_right_motor.getEncoder();

    public lifter() {

    }
    @Override
    public void periodic() {
        
    }
}
