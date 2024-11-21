package frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class intakeReal implements IntakeIO {
    VictorSP leftIntake = new VictorSP(frc.robot.Constants.Motors.IntakeMotors.LMOTOR);
    VictorSP rightIntake = new VictorSP(frc.robot.Constants.Motors.IntakeMotors.RMOTOR);


    public void setIntakeVoltage(double volts) {
        rightIntake.setInverted(true);
        leftIntake.set(volts);
        rightIntake.set(volts);
    }

    @Override
    public void updateInputs(IntakeIOInputs inputs) {};

}

