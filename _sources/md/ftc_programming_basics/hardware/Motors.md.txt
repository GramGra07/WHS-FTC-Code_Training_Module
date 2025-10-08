# Motors and Servos

`public DcMotor name = null;  or public Servo name = null;`

Place this after the declaration of the class `public class name extends name {` You will use these to declare the name as a DcMotor or as a Servo whichever it may be. Make sure you change the name as this will be how you call the motor or servo further in your code.

Then use `name = hardwareMap.get(DcMotor.class, "name2"); or name = hardwareMap.get(Servo.class,"name2")`. Place this after `void runOpMode(){`This will allow the robot to find the device. You will need to put name2 in the configuration of the Driver Station. Name will be the same as in the first part.

## Built-in functions

```java
motor.setPower(0.5);//sets the power of the motor, 0.5 is 50% power, 1 is 100% power, -1 is 100% reverse power
motor.setTargetPosition(100);//sets the target position of the motor, this is in encoder ticks
motor.getCurrentPosition();//gets the current position of the motor, this is in encoder ticks
motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);//sets the motor to reset encoder
motor.setDirection(DcMotor.Direction.REVERSE);//sets the direction as reverse, it assumes it will be FORWARD if you don't put this in
motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);//sets the motor to give encoder output back to the user
motor.setZeroPowerBehavior(BRAKE);//sets the motor to brake when no power is sent, other option is FLOAT, the motor will allow for outside influence

servo.setPosition(0-1);//will set the position of the servo, 0-1
```

