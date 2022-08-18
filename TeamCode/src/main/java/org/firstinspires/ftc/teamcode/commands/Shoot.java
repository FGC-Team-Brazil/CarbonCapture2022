package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.Subsystem;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.ShooterSubsystem;


public class Shoot extends CommandBase {

        private final ShooterSubsystem shooterSubsystem;

        public Shoot(ShooterSubsystem shooterSubsystem) {
            this.shooterSubsystem = shooterSubsystem;
            addRequirements((Subsystem) shooterSubsystem);
        }

        @Override
        public void initialize() {
        }

        @Override
        public void execute() {
           shooterSubsystem.shoot(Constants.Shooter.SHOOTER_SPEED);
        }

        @Override
        public boolean isFinished() {
            return false;
        }

    }

