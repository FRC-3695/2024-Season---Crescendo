package frc.robot;

public final class Constants {
    public static class robotConstants {                    // View is taken from rear of robot for sides
        // Drive Train Motor Controllers
        public static final int motor_drive_leftFront           = 1;  // CAN ID
        public static final int motor_drive_leftRear            = 2;  // CAN ID
        public static final int motor_drive_rightFront          = 3;  // CAN ID
        public static final int motor_drive_rightRear           = 4;  // CAN ID
        // Lifter Motor Controllers
        public static final int motor_lifterLeft                = 5;  // CAN ID
        public static final int motor_lifterRight               = 6;  // CAN ID
        public static final int sensor_lifter_left              = 0;  // Digital IO
        public static final int sensor_lifter_right             = 1;  // Digital IO
        // Manipulator Motor Controllers
        public static final int motor_manipulator_feed          = 7;  // CAN ID
        public static final int motor_manipulator_posi          = 8;  // CAN ID
        public static final int sensor_manupilator_retract      = 2;  // Digital IO
        // Shooter Motor Controllers
        public static final int motor_shooter_left              = 9;  // CAN ID
        public static final int motor_shooter_right             = 10; // CAN ID
    }
    public static class operatorConstants {
        public static final int controller_xBox_driver          = 0;  // DS USB ID
        public static final int controller_xBox_manip           = 1;  // DS USB ID
    }
    public static class shooterPID {
        public static final double motor_shooter_P              = 0.000000;     // Proportional Variable
        public static final double motor_shooter_I              = 0.000000;     // Intergral Variable
        public static final double motor_shooter_D              = 0.000000;     // Derivative Variable
        public static final double motor_shooter_FF             = 0.000000;     // Feed Forward Variable
    }
}
