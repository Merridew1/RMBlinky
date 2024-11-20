package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class intakeReal implements intakeIO {
    VictorSP leftIntake = new VictorSP(frc.robot.Constants.Motors.IntakeMotors.LMOTOR);
    VictorSP rightIntake = new VictorSP(frc.robot.Constants.Motors.IntakeMotors.RMOTOR);

    public intakeReal() {
        rightIntake.setInverted(true);
    }


    public void intakeVoltage(double lvolts, double rvolts) {
        leftIntake.set(lvolts);
        rightIntake.set(rvolts);
    }

}

