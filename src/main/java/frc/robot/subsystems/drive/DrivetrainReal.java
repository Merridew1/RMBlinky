package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.PWM;
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
    public void updateInputsIO(DrivetrainIOInputs inputs) {
        inputs.leftFrontMotorPWMValueIO = FLMotor.get();
        inputs.leftbackMotorPWMIOValue = BLMotor.get();
        inputs.rightFrontMotorPWMValueIO = FRMotor.get();
        inputs.rightBackMotorPWMValueIO = BRMotor.get();
    }

    /**
     * Drive Voltage
     */
    public void setDrivePower(double lvolts, double rvolts) {
        FLMotor.set(lvolts);
        FRMotor.set(rvolts);
    }

}
