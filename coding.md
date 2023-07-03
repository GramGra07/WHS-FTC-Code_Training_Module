## Fatal Errors <a name="fatal"></a>

**Null Pointer Exception** - Can't find whatever you are calling such as a motor. You can get this if the motor or object is not initialized or setup correctly.

When updating or upgrading your control hub, you may get an error saying something like, could not find a file, in some random folder that you can't find. This is caused by an error in your gradle code. If you can't find another way to fix it I would recommend this method, it is a little complicated but will solve it. First, create a new repository **DO NOT ADD ANYTHING AUTOMATICALLY** not even a read me we will call this repository our bridge. Then scroll down to the bottom and tap import from repository, grab the URL of your old repository and make sure it finished importing. Then go into the old repositories settings and delete the repository. Then go to the FTC Robot Controller and fork it. You will want to clone both the bridge repository and the new one we just forked. Now you will copy over all of your working files from the bridge repo and put them in your new repository. As soon as that is finished and committed you should be good to go, you can then delete the bridge repository.

## Coding <a name="code"></a>

The java coding language that we use is not incredibly hard to learn once you figure it all out. It follows all of the coding fundamentals you may already know.

# **IMPORTANT** when editing your code, only edit it in the **teamcode** section, you will have to copy and paste the files from the external samples. **DO NOT** edit the ftc robot controller sample code

## There are a lot of really good info and sample opModes [here][ftcpage]

### Getting started <a name="start2"></a>
- General Knowledge
    - ```;``` must be at the end of every line except if it ends in ```{``` or ```}```
    - ```{``` is used to begin the code for the function, ```}``` ends the function

- Configuration <a name = "config"></a>

```DcMotor name = hardwareMap.get(DistanceSensor.class, "name");```

The second name is the one you will use in the configuration guide in your driver station. The first name is the one you will use to set powers and other functions.

### Setting up your files <a name="files"></a>
Refer to the blank examples [TeleOp][beTele] and [Auto][beAuto]. These both have the proper setup and code to get started coding both of these modes. I will get into more detail into what everything means in TeleOp and auto.

### Using variables <a name="usevar"></a>
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

Double is used for your motors, this is the best method because it supports all numbers so you can use it for storing gamepad inputs.

Float is most commonly used to store color values

Strings are used to store common strings or text values like a status of initialization

- When to use public vs. private variables?
    - You generally want to always use public unless it is something that you don't want to share with other opmodes, like a runtime.

### TeleOp <a name="tele"></a>
Here is the [FTC BasicOpMode (21-22)][lop] it uses 2 motors.
In the [blank TeleOp Example][beTele] you will find that there are 20 lines
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
First, comments are indicated by ```//```

Imports are how you get the references and all the different pieces to the code.

Next we have ```@TeleOp(name="exampleTeleOpBlank",group="Pushbot")```, this means that this opmode is being classified under the teleop section, with the name "exampleTeleOpBlank" and it is being placed in the Pushbot group

Now we have the ```public class exampleTeleOpBlank extends LinearOpMode{``` this means that this opmode can now be used as a base opmode, extending an opmode means that all variables and functions are shared between the opmodes. In this case the file is extending the Linear Op Mode file which you will be able to find in your forked repository.

Next we have our ``` HardwarePushbot robot = new HardwarePushbot(); ``` and ```private ElapsedTime   runtime = new ElapsedTime();``` the first part declares the robot as a robot, we will be using pushbot software for the season. Elapsed time is a very important thing to consider, it times the round as it is going. You can use this for a lot of things including having an endgame timer and restricting your auto time to 30 seconds.

Next we have the function ```public void runOpMode(){``` this runs when you press Init it will run that part. Remember, when you hit Init, it is not running the whole program yet, just the small part in between runOpMode and opModeIsActive.

Now we will run ```runtime.reset();``` and ```getRuntime()```, these are required in order for your runtime to be correct.

```waitForStart();``` tells the opmode to wait until the user presses go, when this happens, everything inside this function runs.

```telemetry.addData("Time:", String.valueOf(runtime));```, telemetry is your equivalent of printing data in python and other languages, using this will print onto your phone, "Time: 60(or what the time is).


### Autonomous <a name="auto"></a>
In the [Blank Autonomous Example][beAuto] you will find 18 lines.
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

Next we have ```@TeleOp(name="exampleAutoBlank",group="Autonomous")```, this means that this opmode is being classified under the autonomous section, with the name "exampleAutoBlank" and it is being placed in the autonomous group

Now we have the ```public class exampleAutoBlank extends exampleTeleOpBlank{``` this means that this opmode can now be used as a secondary opmode. In this case the file is extending the exampleTeleOpBlank file.

Now we don't have to use ``` HardwarePushbot robot = new HardwarePushbot(); ``` because it has been shared through extension but we have to do ```private ElapsedTime   runtime = new ElapsedTime();``` because it is private.

Next we have the function ```public void runOpMode(){``` this runs when you press Init it will run that part. Remember, when you hit Init, it is not running the whole program yet, just the small part in between runOpMode and opModeIsActive.

Now we will run ```runtime.reset();``` and ```getRuntime()```, these are required in order for your runtime to be correct.

```waitForStart();``` tells the opmode to wait until the user presses go, when this happens, everything inside this function runs.

```
while (getRuntime()<=30) {
       getRuntime();
       telemetry.addData(String.valueOf(runtime), "Working");
  } 
```

This gets the runtime, checks it and if it is less than or equal to 30 seconds, it keeps running. If it is over or equal to 30, it stops.

### Editing your code <a name="edit"></a>
One major part is editing your code, to do this you will open your project in android studio, then tap FTC Robot Controller/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples to get to the samples, you will need to find the teamcode part to edit your code correctly.

### Functions <a name="functions"></a>
- What is the format?
 ``` 
  public void imaginaryFunction(){
    //code
  }
  ```
- What about parameters?
 ```
 public void imaginaryFunction2(int hi, boolean hello){
    if (hello == true){
      //do something
      int hi+=1;
    }
  }
  ```
- What about calling a function?
```
  imaginaryFunction(6,false);
```
- Returning values?
```
 public int imaginaryFunction3(int hi, boolean hello){
    if (hello == true){
      //do something
      int hi+=1;
      return hi;
    }
  }
```
You will see that this is saying public int, you use void if you are returning nothing, and the proper variable type if you are returning something. This would be called as, ```telemetry.addData("Number",String(imaginaryFunction3(9,true)))```

Hint: Int() puts the string into int form

## Hardware <a name="ware"></a>

Hardware is what FTC gives us, we call all of these things in order to use some useful built in functions. It also allows us to call all of the devices possible in order to make sure we can use all of these devices to their full ability.

### Motors and Servos <a name="motor"></a>

```import com.qualcomm.robotcore.hardware.DcMotor;  import com.qualcomm.robotcore.hardware.Servo;```

You will use these to import the class files needed to use DcMotors and Servos.

```public DcMotor name = null; public Servo name = null;```

Place this after the declaration of the class ```public class name extends name { ``` You will use these to declare the name as a DcMotor or as a Servo whichever it may be. Make sure you change the name as this will be how you call the motor or servo further in your code.

Then use ```name = hardwareMap.get(DcMotor.class, "name2");```. Place this after ```void runOpMode(){```This will allow the robot to find the device. You will need to put name2 in the configuration of the Driver Station. Name will be the same as in the first part.

### Sensors <a name="sense"></a>

Touch Sensors - Same as motors, just different syntax.

```import com.qualcomm.robotcore.hardware.TouchSensor;```

```public TouchSensor touchSensor;```

```touchSensor = hardwareMap.get(TouchSensor.class, ("touchSensor"));```

Distance Sensors

```import com.qualcomm.robotcore.hardware.DistanceSensor;```

```public DistanceSensor distance;```

```distance = hardwareMap.get(DistanceSensor.class, "name");```

Color Sensors

```
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
```

```NormalizedColorSensor colorSensor;```

```colorSensor = hardwareMap.get(NormalizedColorSensor.class, "name");```

[Example opMode][Color] to use color sensors

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

[Example opMode][IMU].

### Indicators <a name="indicator"></a>

Digital LED Indicators are a very good way to get feedback from your robot. It is helpful because it can show you what is happening inside the robot and code.

```import com.qualcomm.robotcore.hardware.DigitalChannel;```

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

Call it in your code with ```green1.setState(false); red1.setState(true);``` or the inverse, setting green to true and red to false.

## Built in Functions <a name="built"></a>

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

## Gamepad Input <a name="gp"></a>

Gamepad inputs are the base of teleOp. You can use ```if(gamepad1.left_bumper){``` to check if it has been pressed. Other gamepad buttons give different inputs. Some will give floats back while some are boolean. You can also use gamepad2 to use a second one. Below is a list of every input and what type it will give back to the robot.

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

[Next up: encoders][eP]

[Go back home][hP]

[rhc]: https://docs.revrobotics.com/rev-hardware-client/getting-started/installation-instructions
[ftcpage]: https://github.com/FIRST-Tech-Challenge/FtcRobotController
[user]: https://github.com/GramGra07
[team]: https://github.com/WindsorHSRobotics/Team_Resources
[rev]: https://www.revrobotics.com/
[clineuser]: https://github.com/stcline
[aslink]: https://developer.android.com/studio
[ggl]: https://www.google.com/
[lop]: https://github.com/FIRST-Tech-Challenge/FtcRobotController/blob/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples/BasicOpMode_Linear.java
[cuser]: https://github.com/ctimmons25
[juser]: https://github.com/JohnMayfield
[buser]: https://github.com/sangerb19
[gm0]: https://gm0.org/en/latest/
[lib]: https://www.firstinspires.org/resource-library/ftc/game-and-season-info
[web]: https://gist.github.com/jagrosh/5b1761213e33fc5b54ec7f6379034a22
[mlguide]: https://ftc-docs.firstinspires.org/ftc_ml/
[ml]: https://ftc-ml.firstinspires.org/
[mlset]: https://ftc-docs.firstinspires.org/ftc_ml/logging_on/logging-on.html#adding-students-to-your-teams-ftc-ml-workspace
[tfodweb]: https://github.com/FIRST-Tech-Challenge/FtcRobotController/blob/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples/ConceptTensorFlowObjectDetectionWebcam.java
[vu]: https://developer.vuforia.com/license-manager
[3D]: https://docs.google.com/presentation/d/1MeLkA9mCI4vZMiejlqMZpAhZvbV2ThvSf6oZBzhQGdo/edit?usp=sharing
[qm]: https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html
[qt]: https://docs.revrobotics.com/kickoff-concepts/freight-frenzy-2021-2022/programming-teleoperated
[bb]: https://www.firstinspires.org/sites/default/files/uploads/resource_library/ftc/blocks-programming-guide.pdf
[page]: https://gramgra07.github.io/WHS-FTC-GramGra07-Code_Training_Module/
[repo]: https://github.com/GramGra07/WHS-FTC-GramGra07-Code_Training_Module/blob/main/README.md
[feed]: https://gramgra07.github.io/CTMWeb/
[eocv]: https://github.com/OpenFTC/EasyOpenCV
[hsv]: https://i.stack.imgur.com/gyuw4.png
[lrr]: https://learnroadrunner.com/#frequently-asked-questions
[dash]: http://192.168.43.1:8080/dash

[fork]: /images/fork.png
[gitcommit]: /images/gitCommit.png
[commit]: /images/commit.png
[push]: /images/push.png
[pull]: /images/pull.png
[run]: /images/run.png
[setting]: /images/settings.png
[beTele]: /examples/exampleTeleOpBlank
[feTele]: /examples/exampleTeleOpFull
[beAuto]: /examples/exampleAutoBlank.java
[feAuto]: /examples/exampleAutoFull.java
[code]: /images/code.png
[zip]: /images/zip.png
[vcs]: /images/vcs.png
[at]: /images/at.png
[step1]: /images/step1.png
[step2]: /images/step2.png
[step3]: /images/step3.png
[step4]: /images/step4.png
[step5]: /images/step5.png
[step6]: /images/step6.png
[file]: /images/file.png
[open]: /images/open.png
[new]: /images/new.png
[import]: /examples/import.txt
[eDemo]: /examples/RobotAutoDriveByEncoder_Linear.java
[color]: /examples/SensorColor.java
[IMU]: /examples/SensorBNO055IMU.java

[blcP]: /baseLevelCode.md
[cP]: /coding.md
[mlP]: /machineLearning.md
[gbP]: /githubBasics.md
[laP]: /linksAndAcknowledgements.md
[eP]: /encoders.md
[hP]: /README.md
[rr]: /roadRunner.md
[cv]: /openCV.md