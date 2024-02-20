package frc.robot;

public final class Constants {
    public static class IDs {                    // View is taken from rear of robot for sides
        // Drive Train Motor Controllers
        public static final int drive_leftFront_motor           = 1;  // CAN ID
        public static final int drive_leftRear_motor            = 2;  // CAN ID
        public static final int drive_rightFront_motor          = 3;  // CAN ID
        public static final int drive_rightRear_motor           = 4;  // CAN ID
        // Lifter Motor Controllers
        public static final int lifter_left_motor               = 5;  // CAN ID
        public static final int lifter_right_motor              = 6;  // CAN ID
        public static final int lifter_left_sensor              = 0;  // Digital IO
        public static final int lifter_right_sensor             = 1;  // Digital IO
        // Manipulator Motor Controllers
        public static final int manipulator_feed_motor          = 7;  // CAN ID
        public static final int manipulator_posi_motor          = 8;  // CAN ID
        public static final int manupilator_retract_sensor      = 2;  // Digital IO
        // Shooter Motor Controllers
        public static final int shooter_left_motor              = 9;  // CAN ID
        public static final int shooter_right_motor             = 10; // CAN ID
    }
    public static class operator {
        public static final int controller_xBox_driver          = 0;  // DS USB ID
        public static final int controller_xBox_manip           = 1;  // DS USB ID
    }
    public static class shooter {
        public static final double tuning_P                     = 0.000000;     // Proportional Variable
        public static final double tuning_I                     = 0.000000;     // Intergral Variable
        public static final double tuning_D                     = 0.000000;     // Derivative Variable
        public static final double tuning_FF                    = 0.000000;     // Feed Forward Variable
    }
    }
}
