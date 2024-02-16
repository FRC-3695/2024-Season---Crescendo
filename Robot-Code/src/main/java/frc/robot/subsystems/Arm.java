package frc.robot.subsystems;
//THISONE
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxLimitSwitch;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxLimitSwitch.Type;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.math.MathUtil;
import com.revrobotics.SparkMaxLimitSwitch;
import com.revrobotics.SparkMaxPIDController;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Constants;

public class Arm {
    public static CANSparkMax armHook;
   
    static CommandXboxController controller2;

    private static Arm instance = null;
    public static Arm getInstance() {
        if(instance == null)
          instance = new Arm();
        return instance;
      }

}
