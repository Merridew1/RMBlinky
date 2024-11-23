package frc.robot;

/**
 * Constants file.
 */
public final class Constants {

    public static final class ColorsRGB {
        public static final int[] RED = {255, 0, 0};
        public static final int[] GREEN = {124, 255, 0};
        public static final int[] BLUE = {0, 0, 205};
        public static final int[] PURPLE = {255, 0, 255};
        public static final int[] PINK = {255, 192, 203};

    }

    /**
     * Stick Deadband
     */
    public static final double stickDeadband = 0.1;
    /**
     * Driver ID
     */
    public static final int driverID = 0;
    /**
     * Operator ID
     */
    public static final int operatorID = 1;

    /**
     * Motor CAN id's.
     */
    public static final class Motors {
        public static final class DriveTrainMotors {
            public static final int FRMOTOR = 5;
            public static final int FLMOTOR = 6;
            public static final int BRMOTOR = 4;
            public static final int BLMOTOR = 7;
        }
        public static final class IntakeMotors {
            public static final int LMOTOR = 1;
            public static final int RMOTOR = 2;
        }
        public static final class RandomMotors {
            public static final int NEO = 10;
            public static final int FALCON = 11;
        }
    }

    /**
     * Pneumatics CAN id constants.
     */
    public static final class Pneumatics {
    }


}
