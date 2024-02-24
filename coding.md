# Coding

### Fatal Errors <a href="#fatal" id="fatal"></a>

**Null Pointer Exception** - Can't find whatever you are calling such as a motor. You can get this if the motor or object is not initialized or setup correctly.

When updating or upgrading your control hub, you may get an error saying something like, could not find a file, in some random folder that you can't find. This is caused by an error in your gradle code. If you can't find another way to fix it I would recommend this method, it is a little complicated but will solve it. First, create a new repository **DO NOT ADD ANYTHING AUTOMATICALLY** not even a read me we will call this repository our bridge. Then scroll down to the bottom and tap import from repository, grab the URL of your old repository and make sure it finished importing. Then go into the old repositories settings and delete the repository. Then go to the FTC Robot Controller and fork it. You will want to clone both the bridge repository and the new one we just forked. Now you will copy over all of your working files from the bridge repo and put them in your new repository. As soon as that is finished and committed you should be good to go, you can then delete the bridge repository.

### Coding <a href="#code" id="code"></a>

The java coding language that we use is not incredibly hard to learn once you figure it all out. It follows all of the coding fundamentals you may already know.

## **IMPORTANT** when editing your code, only edit it in the **team code** section, you will have to copy and paste the files from the external samples. **DO NOT** edit the ftc robot controller sample code

### There are a lot of really good info and sample opModes [here](https://github.com/FIRST-Tech-Challenge/FtcRobotController)

#### Getting started <a href="#start2" id="start2"></a>

* General Knowledge
  * `;` must be at the end of every line except if it ends in `{` or `}`
  * `{` is used to begin the code for the function, `}` ends the function
* Configuration

`DcMotor name = hardwareMap.get(DcMotor.class, "name");`

The second name is the one you will use in the configuration guide in your driver station. The first name is the one you will use to set powers and other functions.

#### Setting up your files <a href="#files" id="files"></a>

Refer to the blank examples [TeleOp](examples/exampleTeleOpBlank) and [Auto](examples/exampleAutoBlank.txt). These both have the proper setup and code to get started coding both of these modes. I will get into more detail into what everything means in TeleOp and auto.

#### Using variables <a href="#usevar" id="usevar"></a>

Variables in java consist of:

```
boolean  True or False
int  Integer, a whole number
double  Floating point number
float  Decimal (up to 7 digits)
String  Text value
```

Boolean is used to determine whether a value is true or not, an on/off switch

Int is used for a constant value like your team number, a certain value to multiple etc.

Double is used for your motors, this is the best method because it supports all numbers so you can use it for storing game-pad inputs.

Float is most commonly used to store color values

Strings are used to store common strings or text values like a status of initialization

* When to use public vs. private variables?
  * You generally want to always use public unless it is something that you don't want to share with other opModes, like a runtime.

#### TeleOp <a href="#tele" id="tele"></a>

Here is the [FTC BasicOpMode (21-22)](https://github.com/FIRST-Tech-Challenge/FtcRobotController/blob/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples/BasicOpMode\_Linear.java) it uses 2 motors. In the [blank TeleOp Example](examples/exampleTeleOpBlank) you will find that there are 20 lines

```
//imports
@TeleOp(name="exampleTeleOpBlank",group="Pushbot")
//@Disabled
public class exampleTeleOpBlank extends LinearOpMode {
    HardwarePushbot robot = new HardwarePushbot();
    private ElapsedTime   runtime = new ElapsedTime();
    @Override
    public void runOpMode(){
        runtime.reset();
        getRuntime();
        waitForStart();
        while (opModeIsActive()){
            getRuntime();
            telemetry.addData("Time:", String.valueOf(runtime));
        }
    }
}
```

First, comments are indicated by `//`

Imports are how you get the references and all the different pieces to the code.

Next we have `@TeleOp(name="exampleTeleOpBlank",group="Pushbot")`, this means that this opmode is being classified under the teleOp section, with the name "exampleTeleOpBlank" and it is being placed in the Push-bot group

Now we have the `public class exampleTeleOpBlank extends LinearOpMode{` this means that this opmode can now be used as a base opmode, extending an opmode means that all variables and functions are shared between the opModes. In this case the file is extending the Linear Op Mode file which you will be able to find in your forked repository.

Next we have our `HardwarePushbot robot = new HardwarePushbot();` and `private ElapsedTime runtime = new ElapsedTime();` the first part declares the robot as a robot, we will be using push-bot software for the season. Elapsed time is a very important thing to consider, it times the round as it is going. You can use this for a lot of things including having an endgame timer and restricting your auto time to 30 seconds.

Next we have the function `public void runOpMode(){` this runs when you press Init it will run that part. Remember, when you hit Init, it is not running the whole program yet, just the small part in between runOpMode and opModeIsActive.

Now we will run `runtime.reset();` and `getRuntime()`, these are required in order for your runtime to be correct.

`waitForStart();` tells the opmode to wait until the user presses go, when this happens, everything inside this function runs.

`telemetry.addData("Time:", String.valueOf(runtime));`, telemetry is your equivalent of printing data in python and other languages, using this will print onto your phone, "Time: 60(or what the time is).

#### Autonomous <a href="#auto" id="auto"></a>

In the [Blank Autonomous Example](examples/exampleAutoBlank.txt) you will find 18 lines.

```
//imports
@Autonomous(name="exampleAutoBlank", group="Autonomous")
//@Disabled
public class exampleAutoBlank extends exampleTeleOpBlank {  //your doc name *extends* your main code branch
    private ElapsedTime   runtime = new ElapsedTime();
    @Override
    public void runOpMode(){
        runtime.reset();
        getRuntime();
        waitForStart();
        //actual code
        while (getRuntime()<=30) {
            getRuntime();
            telemetry.addData(String.valueOf(runtime), "Working");
        }
    }
}
```

Imports are how you get the references and all the different pieces to the code.

Next we have `@TeleOp(name="exampleAutoBlank",group="Autonomous")`, this means that this opmode is being classified under the autonomous section, with the name "exampleAutoBlank" and it is being placed in the autonomous group

Now we have the `public class exampleAutoBlank extends exampleTeleOpBlank{` this means that this opmode can now be used as a secondary opmode. In this case the file is extending the exampleTeleOpBlank file.

Now we don't have to use `HardwarePushbot robot = new HardwarePushbot();` because it has been shared through extension but we have to do `private ElapsedTime runtime = new ElapsedTime();` because it is private.

Next we have the function `public void runOpMode(){` this runs when you press Init it will run that part. Remember, when you hit Init, it is not running the whole program yet, just the small part in between runOpMode and opModeIsActive.

Now we will run `runtime.reset();` and `getRuntime()`, these are required in order for your runtime to be correct.

`waitForStart();` tells the opmode to wait until the user presses go, when this happens, everything inside this function runs.

```
while (getRuntime()<=30) {
       getRuntime();
       telemetry.addData(String.valueOf(runtime), "Working");
  } 
```

This gets the runtime, checks it and if it is less than or equal to 30 seconds, it keeps running. If it is over or equal to 30, it stops.

#### Editing your code <a href="#edit" id="edit"></a>

One major part is editing your code, to do this you will open your project in android studio, then tap FTC Robot Controller/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples to get to the samples, you will need to find the team code part to edit your code correctly.

#### Functions <a href="#functions" id="functions"></a>

* What is the format?

```
 public void imaginaryFunction(){
   //code
 }
```

* What about parameters?

```
public void imaginaryFunction2(int hi, boolean hello){
   if (hello == true){
     //do something
     int hi+=1;
   }
 }
```

* What about calling a function?

```
  imaginaryFunction(6,false);
```

* Returning values?

```
 public int imaginaryFunction3(int hi, boolean hello){
    if (hello == true){
      //do something
      int hi+=1;
      return hi;
    }
  }
```

You will see that this is saying public int, you use void if you are returning nothing, and the proper variable type if you are returning something. This would be called as, `telemetry.addData("Number",String(imaginaryFunction3(9,true)))`

Hint: Int() puts the string into int form

### Hardware <a href="#ware" id="ware"></a>

Hardware is what FTC gives us, we call all of these things in order to use some useful built in functions. It also allows us to call all of the devices possible in order to make sure we can use all of these devices to their full ability.

#### Motors and Servos <a href="#motor" id="motor"></a>

`import com.qualcomm.robotcore.hardware.DcMotor; import com.qualcomm.robotcore.hardware.Servo;`

You will use these to import the class files needed to use DcMotors and Servos.

`public DcMotor name = null; public Servo name = null;`

Place this after the declaration of the class `public class name extends name {` You will use these to declare the name as a DcMotor or as a Servo whichever it may be. Make sure you change the name as this will be how you call the motor or servo further in your code.

Then use `name = hardwareMap.get(DcMotor.class, "name2");`. Place this after `void runOpMode(){`This will allow the robot to find the device. You will need to put name2 in the configuration of the Driver Station. Name will be the same as in the first part.

#### Sensors <a href="#sense" id="sense"></a>

Touch Sensors - Same as motors, just different syntax.

`import com.qualcomm.robotcore.hardware.TouchSensor;`

`public TouchSensor touchSensor;`

`touchSensor = hardwareMap.get(TouchSensor.class, ("touchSensor"));`

Distance Sensors

`import com.qualcomm.robotcore.hardware.DistanceSensor;`

`public DistanceSensor distance;`

`distance = hardwareMap.get(DistanceSensor.class, "name");`

Color Sensors

```
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
```

`NormalizedColorSensor colorSensor;`

`colorSensor = hardwareMap.get(NormalizedColorSensor.class, "name");`

[Example opMode](examples/SensorColor.txt) to use color sensors

IMU

The IMU or Internal Measurement Unit, is a very useful tool to find the robot orientation

```
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
```

```
public BNO055IMU imu;    //imu module inside expansion hub
public Orientation angles;     //imu uses these to find angles and classify them
public Acceleration gravity;    //Imu uses to get acceleration
```

```
BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
parameters.loggingEnabled = true;
parameters.loggingTag = "IMU";
parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
imu = hardwareMap.get(BNO055IMU.class, "imu");
imu.initialize(parameters);
angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
gravity = imu.getGravity();
imu.startAccelerationIntegration(new Position(), new Velocity(), 1000);
```

To get the heading, use angles.firstAngle for most control hub configurations. You might have to change this based on how your control hub is mounted.

[Example opMode](examples/SensorBNO055IMU.txt).

#### Indicators <a href="#indicator" id="indicator"></a>

Digital LED Indicators are a very good way to get feedback from your robot. It is helpful because it can show you what is happening inside the robot and code.

`import com.qualcomm.robotcore.hardware.DigitalChannel;`

```
public DigitalChannel red1;
public DigitalChannel green1;
```

This will follow the same pattern of all of the sensors

```
red1 = hardwareMap.get(DigitalChannel.class, "red1");
green1 = hardwareMap.get(DigitalChannel.class, "green1");
```

```
red1.setMode(DigitalChannel.Mode.OUTPUT);//required to use indicators
green1.setMode(DigitalChannel.Mode.OUTPUT);
```

Call it in your code with `green1.setState(false); red1.setState(true);` or the inverse, setting green to true and red to false.

### Built in Functions <a href="#built" id="built"></a>

A lot of devices in FTC have some very useful built in functions. This list will only include a few as I haven't actually looked into the depth of these but these should be most of the skim level ones everyone will use.

```
motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);//sets the motor to reset encoder
motor.setDirection(DcMotor.Direction.REVERSE);//sets the direction as reverse, it assumes it will be FORWARD if you don't put this in
motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);//sets the motor to give encoder output back to the user
motor.setZeroPowerBehavior(BRAKE);//sets the motor to brake when no power is sent, other option is FLOAT, the motor will allow for outside influence
red1.setMode(DigitalChannel.Mode.OUTPUT);//required to use indicators
green1.setMode(DigitalChannel.Mode.OUTPUT);
servo.setPosition(0-1);//will set the position of the servo, 0-1
green1.setState(false);
red.setState(true);
motor.getCurrentPosition()//gets current encoder position
motor.setPower(0-1)
motor.setTargetPosition(target);//this will set the target to run to in run to position
motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);//will make the robot go to the position and get to the position no matter the direction
motor.isBusy()//checks to see if the motor is still running to a position
distance.getDistance(DistanceUnit.CM)//this is how you would call to get a distance, other options are MM, M, and INCHES
NormalizedRGBA color = colorSensor.getNormalizedColors();//this and the one below are how you get colors from the color sensors
Color.colorToHSV(color.toColor(), hsvValues);
touchSensor.isPressed()//will return true if it is pressed
```

### Game-pad Input <a href="#gp" id="gp"></a>

Game-pad inputs are the base of teleOp. You can use `if(gamepad1.left_bumper){` to check if it has been pressed. Other game-pad buttons give different inputs. Some will give floats back while some are boolean. You can also use game-pad2 to use a second one. Below is a list of every input and what type it will give back to the robot.

```
.a boolean
.b boolean
.y boolean
.x boolean
.left_stick_y or x or right float
.right_stick_x or y or left float
.dpad_down boolean
.dpad_up boolean
.dpad_right boolean
.dpad_left boolean
.back boolean
.start boolean
.left_bumper boolean
.right_bumper boolean
.left_stick_button or right boolean
.right_trigger or left float
.touchpad_finger_1_x or y float
```
