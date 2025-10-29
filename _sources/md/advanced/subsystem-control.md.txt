(subc)=
# Subsystem Control

## What is it?

Subsystem control is another way of coding your FTC robot that involves splitting up functions, variables, and devices into different subsystems. For instance, you could have a drive subsystem or a deposit subsystem.

## Why use it?

Subsystem control is a very good way of abstracting your code and making it more readable. It also allows you to have consistent variables and naming across all classes you use. This means that you will be able to control it easier in theory. It allows you to call variables and change variables across classes extremely easily.

## How to switch

In the process of switching, I would recommend keeping all previous code you have. This will allow you to cross-reference it and make sure it all will work correctly. I will warn that this process will take programming knowledge even though I try to explain to it the best I can. It is not an easy concept to learn for new people to coding.

Steps to switch effectively:

1. Divide your robot into multiple subsystems
   1. These can be something like Drivetrain, Claw, Extension, Endgame
2. Put all of these files into your code (I would recommend putting them in their own subsystem folder for ease of use)
   1. Make these class names make sense, for instance DrivetrainSubsystem or ClawSubsystem
3. Create all variables you will use in the class
   1. You will most likely be creating these as private variables because there is no reason to access them if you have made your subsystem correctly. For instance, mine looks like the code sample below
   2. The private part will be explained in more detail later but the simple idea is that your subsystem should be the only thing that actually needs to directly call these variables. There will be other variables that use public syntax but those could be for functions usually.

   ```java
   private DcMotor motorFrontLeft = null;
   private DcMotor motorBackLeft = null;
   private DcMotor motorFrontRight = null;
   private DcMotor motorBackRight = null;
   ```

4. Create a class constructor
   1. A class constructor is vital, it allows you to pass parameters into the class when you create it to make it initialize effectively as shown below
   2. You will need to make it take the value of a HardwareMap if you would like to do it this way as well which I would **highly** recommend.

   ```java
   public DriveSubsystem(HardwareMap ahwMap) {
       if (motor == null){
           // initialize motor like in your regular code
       }
   }
   ```

5. Create class functions that you will call in your teleOp
   1. Some ideas for these functions are shown below

   ```java 
   public void driveByGamepads( OpMode myOpMode) {
       yControl = -myOpMode.gamepad1.left_stick_y;
       xControl = myOpMode.gamepad1.left_stick_x;
       if (reverse) {
           yControl = -yControl;
           xControl = -xControl;
       }
       double turn = -myOpMode.gamepad1.right_stick_x;
       slowPower = slowModeIsOn ? slowMult : 1;
       frontRightPower = (yControl - xControl + turn) / slowPower;
       backRightPower = (yControl + xControl + turn) / slowPower;
       frontLeftPower = (yControl + xControl - turn) / slowPower;
       backLeftPower = (yControl - xControl - turn) / slowPower;
       
   
   
   public void stop() {
       motorFrontLeft.setPower(0.0);
       motorBackLeft.setPower(0.0);
       motorFrontRight.setPower(0.0);
       motorBackRight.setPower(0.0);
   }
   
   private void power() {
       motorFrontLeft.setPower(frontLeftPower);
       motorBackLeft.setPower(backLeftPower);
       motorFrontRight.setPower(frontRightPower);
       motorBackRight.setPower(backRightPower);
   }
   
   public void update() {
       power();
   }
   ```

6. Initialize your class in your teleOp
   1. It is incredibly important to make sure you have an instance of your class running in your teleOp or nothing else will work correctly.
   2. You do this by creating a new variable, and then assigning it the subsystem as a value

   ```java
   driveSubsystemName = DriveSubsystem(hardwareMap)
   ```

7. Once you have made your initialization, all public functions and variables are available through driveSubsystemName. (function or variable name)
   1. This is essentially saying, driveSubsystemName (which is a class) and you want a property of it. The . allows us to access these properties directly.

8. Access and call the functions where they need to be called. I cannot give you much instruction on this part but this is where you need to be creative and make the variables and functions that you need. In my code, I call the driveByGamepads function and update function in my main teleOp loop. These are the two functions that completely control the drivetrain for me, but it will usually be different with other robots.

   ```java
   package org.firstinspires.ftc.teamcode.subsystems;
   
   import com.qualcomm.robotcore.hardware.HardwareMap;
   import com.qualcomm.robotcore.hardware.Servo;
   import org.firstinspires.ftc.teamcode.UtilClass.ServoUtil;
   import org.firstinspires.ftc.teamcode.UtilClass.varStorage.AutoServoPositions;
   import org.firstinspires.ftc.teamcode.UtilClass.varStorage.PastAngle;
   import org.firstinspires.ftc.teamcode.extensions.SensorExtensions;
   import org.firstinspires.ftc.teamcode.extensions.ServoExtensions;
   
   import static org.firstinspires.ftc.teamcode.UtilClass.ServoUtil.closeClaw;
   import static org.firstinspires.ftc.teamcode.UtilClass.ServoUtil.openClaw;
   import static org.firstinspires.ftc.teamcode.extensions.ServoExtensions.initServo;
   
   public class ClawSubsystem {
       public enum ClawStates {
           OPEN,
           CLOSED
       }
   
       public enum FlipStates {
           HIGH,
           BACK,
           ZERO,
           UP,
           DOWN
       }
   
       private Servo claw1;
       private Servo claw2;
       private Servo flipServo;
   
       private ClawStates[] states = {ClawStates.OPEN, ClawStates.OPEN}; //left //right
       private FlipStates flipState = FlipStates.BACK;
   
       public ClawSubsystem(HardwareMap ahwMap) {
           claw1 = initServo(ahwMap, "claw1");
           claw2 = initServo(ahwMap, "claw2");
           flipServo = initServo(ahwMap, "flipServo");
           closeBoth();
           update();
       }
   
       public void openBoth() {
           states[0] = ClawStates.OPEN;
           states[1] = ClawStates.OPEN;
       }
   
       public void openLeft() {
           states[0] = ClawStates.OPEN;
       }
   
       public void openRight() {
           states[1] = ClawStates.OPEN;
       }
   
       public void closeBoth() {
           states[0] = ClawStates.CLOSED;
           states[1] = ClawStates.CLOSED;
       }
   
       public void closeLeft() {
           states[0] = ClawStates.CLOSED;
       }
   
       public void closeRight() {
           states[1] = ClawStates.CLOSED;
       }
   
       public void flipHigh() {
           flipState = FlipStates.HIGH;
       }
   
       public void flipUp() {
           flipState = FlipStates.UP;
       }
   
       public void flipBack() {
           flipState = FlipStates.BACK;
       }
   
       public void flipDown() {
           flipState = FlipStates.DOWN;
       }
   
       public void flipZero() {
           flipState = FlipStates.ZERO;
       }
   
       public void update() {
           switch (states[0]) {
               case OPEN:
                   openClaw(claw1);
                   break;
               case CLOSED:
                   closeClaw(claw1);
                   break;
           }
   
           switch (states[1]) {
               case OPEN:
                   openClaw(claw2);
                   break;
               case CLOSED:
                   closeClaw(claw2);
                   break;
           }
   
           switch (flipState) {
               case HIGH:
                   flipServo.setPosition(70.0);
                   break;
               case BACK:
                   flipServo.setPosition(ServoUtil.backClaw);
                   break;
               case ZERO:
                   flipServo.setPosition(0.0);
                   break;
               case UP:
                   flipServo.setPosition(AutoServoPositions.flipUp);
                   break;
               case DOWN:
                   flipServo.setPosition(AutoServoPositions.flipDown - 10);
                   break;
           }
   
           if (PastAngle.pastAngleVal != SensorExtensions.potentiometer.potentAngle()) {
               flipServo.setPosition(ServoExtensions.lastSetVal);
           }
       }
   }
   
   // You could then switch the position by running
   clawSubsystem.flipDown()
   clawSubsystem.update()
   ```

To create your own:

1. Create your enums with all states that could be needed
2. Create variables to contain the values of these enums
3. Create setter functions to set values differently
4. Create an update function that sets the values requested by the states
5. All done, now just make sure to call your subsystem functions correctly and initialize everything well

OR

Use this handy website I created to generate code for a subsystem! [Subsystem Generator](https://gramgra07.github.io/gg-web/content/ftcUtils/subsystem_maker/index.html)

### Another option is to use my abstract class

Basically, this forces you to have several functions that will be necessary for your subsystem to work. This is a good way to make sure you have everything you need in your subsystem. Obviously everything extra that you need you will need to do yourself, and this does not actually implement anything for you, but it is a good structuring tool for your usage.

```java
public class ArmSub extends Subsystem {

    public ArmSub(HardwareMap hwMap) {
        super(hwMap);
    }
   
    @Override
    public void init() {
        // Implementation here
    }

    @Override
    public void update() {
        // Implementation here
    }

    @Override
    public void telemetry(Telemetry telemetry) {
        // Implementation here
    }
}
```