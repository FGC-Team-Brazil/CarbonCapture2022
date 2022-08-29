package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.Subsystem;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

public class CollectCarbon extends CommandBase {

    private final IntakeSubsystem intakeSubsystem;

    public CollectCarbon(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        super.addRequirements((Subsystem) shooterSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        intakeSubsystem.set(-Constants.Intake.SPEED);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
