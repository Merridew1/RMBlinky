package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import frc.robot.Constants;

/**
 * DrivetrainReal
 */
public class DrivetrainReal implements DrivetrainIO {

    VictorSP FLMotor = new VictorSP(Constants.Motors.DriveTrainMotors.FLMOTOR);
    VictorSP FRMotor = new VictorSP(Constants.Motors.DriveTrainMotors.FRMOTOR);
    VictorSP BLMotor = new VictorSP(Constants.Motors.DriveTrainMotors.BLMOTOR);
    VictorSP BRMotor = new VictorSP(Constants.Motors.DriveTrainMotors.BRMOTOR);


    /**
     * Drivetrain Real
     */
    public DrivetrainReal() {
        FLMotor.addFollower(BLMotor);
        FRMotor.addFollower(BRMotor);

        FRMotor.setInverted(true);
    }


    @Override
    public void updateInputs(DrivetrainIOInputs inputs) {

    }

    /**
     * Drive Voltage
     */
    public void setDriveVoltage(double lvolts, double rvolts) {
        FLMotor.set(lvolts);
        FRMotor.set(rvolts);
    }

}
