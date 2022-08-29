package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.Subsystem;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.BufferSubsystem;

public class ForwardFeed extends CommandBase {

    private final BufferSubsystem bufferSubsystem;

    public ForwardFeed(BufferSubsystem bufferSubsystem) {
        this.bufferSubsystem = bufferSubsystem;
        super.addRequirements((Subsystem) shooterSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        bufferSubsystem.set(Constants.Buffer.SPEED);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
