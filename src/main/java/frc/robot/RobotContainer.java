package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Robot.RobotRunType;
import frc.robot.subsystems.Intake2.Intake2;
import frc.robot.subsystems.Intake2.IntakeIO2;
import frc.robot.subsystems.Intake2.IntakeReal2;
import frc.robot.subsystems.RandomMotors.RandomMotors;
import frc.robot.subsystems.RandomMotors.RandomMotorsIO;
import frc.robot.subsystems.RandomMotors.RandomMotorsReal;
import frc.robot.subsystems.drive.Drivetrain;
import frc.robot.subsystems.drive.DrivetrainIO;
import frc.robot.subsystems.drive.DrivetrainReal;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* Controllers */
    CommandXboxController driver = new CommandXboxController(0);
    // Initialize AutoChooser Sendable
    private final SendableChooser<String> autoChooser = new SendableChooser<>();

    /* Subsystems */
    private Drivetrain driveTrain;
    private Intake2 intake;
    private RandomMotors randMot;

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer(RobotRunType runtimeType) {
        SmartDashboard.putData("Choose Auto: ", autoChooser);
        autoChooser.setDefaultOption("Wait 1 Second", "wait");
        switch (runtimeType) {
            case kReal:
                driveTrain = new Drivetrain(new DrivetrainReal());
                intake = new Intake2(new IntakeReal2());
                randMot = new RandomMotors(new RandomMotorsReal());
                break;
            case kSimulation:
                // drivetrain = new Drivetrain(new DrivetrainSim() {});
                break;
            default:
                driveTrain = new Drivetrain(new DrivetrainIO() {

                    @Override
                    public void updateInputsIO(DrivetrainIOInputs inputs) {

                    }

                    @Override
                    public void setDrivePowerIO(double lvolts, double rvolts) {

                    }
                });
                intake = new Intake2(new IntakeIO2() {

                    @Override
                    public void updateInputsIO2(IntakeIO2Inputs inputs) {

                    }

                    @Override
                    public void setIntakePowerIO(double power) {
                    }

                });
                randMot = new RandomMotors(new RandomMotorsIO() {

                    @Override
                    public void updateInputsIO(RandomMotorsIOInputs inputs) {
                    }

                    @Override
                    public void runMotorIO(double voltage) {
                    }
                });
        }
        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by
     * instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */

    ;

    private void configureButtonBindings() {
        driver.rightTrigger().whileTrue(intake.intakeCommand(1));
        driver.leftTrigger().whileTrue(intake.intakeCommand(-1));
        driver.a().whileTrue(randMot.runMotorCommand(1));
        driver.b().whileTrue(randMot.runMotorCommand(-1));
        driveTrain.setDefaultCommand(driveTrain.driveCommand(driver));
    }

    /**
     * Gets the user's selected autonomous command.
     *
     * @return Returns autonomous command selected.
     */
    public Command getAutonomousCommand() {
        Command autocommand;
        String stuff = autoChooser.getSelected();
        switch (stuff) {
            case "wait":
                autocommand = new WaitCommand(1.0);
                break;
            default:
                autocommand = new InstantCommand();
        }
        return autocommand;
    }
}
