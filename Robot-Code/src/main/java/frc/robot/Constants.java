package frc.robot;

public final class Constants {
    public static class robotConstants {                    // View is taken from rear of robot for sides
        // Drive Train Motor Controllers
        public static final int motor_drive_leftFront    = 1;
        public static final int motor_drive_leftRear     = 2;
        public static final int motor_drive_rightFront   = 3;
        public static final int motor_drive_rightRear    = 4;
        // Lifter Motor Controllers
        public static final int motor_lifterLeft         = 5;
        public static final int motor_lifterRight        = 6;
        // Manipulator Motor Controllers
        public static final int motor_manipulator_feed   = 7;
        public static final int motor_manipulator_posi   = 8;
        // Shooter Motor Controllers
        public static final int motor_shooter_leftFront  = 9;
        public static final int motor_shooter_leftRear   = 10;
        public static final int motor_shooter_rightFront = 11;
        public static final int motor_shooter_rightRear  = 12;
    }
    public static class operatorConstants {
        public static final int controller_xBox_driver = 0;
        public static final int controller_xBox_manip  = 1;
    }
}
