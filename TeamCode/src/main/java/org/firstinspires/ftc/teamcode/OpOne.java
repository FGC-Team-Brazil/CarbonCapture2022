package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class OpOne extends LinearOpMode {
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private DcMotor climbUpMotor;
    private DcMotor climbDownMotor;


    private double leftMotorPower = 0;
    private double rightMotorPower = 0;
    private double climbUpMotorPower = 0;
    private double climbDownMotorPower = 0;

    @Override
    public void runOpMode() {
        this.leftMotor = hardwareMap.get(DcMotor.class, "leftMotor");
        this.rightMotor = hardwareMap.get(DcMotor.class, "rightMotor");

        this.climbUpMotor = hardwareMap.get(DcMotor.class, "climbUpMotor"); //CORE
        this.climbDownMotor = hardwareMap.get(DcMotor.class, "climbDownMotor"); //HEX

        //one side must be reversed for a drivetrain
        this.rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);


        //invert both climb
        this.climbUpMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        this.climbDownMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {

            telemetry.addData("Status", "Running");
            telemetry.update();

            double y = -gamepad1.left_stick_y;
            double x = gamepad1.right_stick_x;

            leftMotor.setPower(y + x);
            rightMotor.setPower(y - x);

            double yClimb= gamepad2.left_stick_y;

            if(yClimb > 0){
                climbUpMotor.setPower(yClimb); //CORE
            }else if(yClimb < 0){
                climbDownMotor.setPower(-yClimb); //HEX
            }

            //this.leftMotorPower = this.gamepad1.left_stick_y;
            //this.rightMotorPower = this.gamepad1.right_stick_y;

            telemetry.addData("Left Encoder Value", this.leftMotor.getCurrentPosition());
            telemetry.addData("Right Encoder Value", this.leftMotor.getCurrentPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();




        }
    }
}

