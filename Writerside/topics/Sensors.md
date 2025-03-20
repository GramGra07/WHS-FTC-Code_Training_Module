# Sensors

### Touch Sensors - Same as motors, just different syntax.

`import com.qualcomm.robotcore.hardware.TouchSensor;`

`public TouchSensor touchSensor;`

`touchSensor = hardwareMap.get(TouchSensor.class, ("touchSensor"));`

### Distance Sensors

`import com.qualcomm.robotcore.hardware.DistanceSensor;`

`public DistanceSensor distance;`

`distance = hardwareMap.get(DistanceSensor.class, "name");`

### Color Sensors

```java
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
```

`NormalizedColorSensor colorSensor;`

`colorSensor = hardwareMap.get(NormalizedColorSensor.class, "name");`

Example opMode [](SensorColor.md) to use color sensors

### IMU

The IMU or Internal Measurement Unit, is a very useful tool to find the robot orientation

```java
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
```

```java
public BNO055IMU imu;    //imu module inside expansion hub
public Orientation angles;     //imu uses these to find angles and classify them
public Acceleration gravity;    //Imu uses to get acceleration
```

```java
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

Example opMode [](SensorBNO055IMU.md)

### Indicators

Digital LED Indicators are a very good way to get feedback from your robot. It is helpful because it can show you what is happening inside the robot and code.

`import com.qualcomm.robotcore.hardware.DigitalChannel;`

```java
public DigitalChannel red1;
public DigitalChannel green1;
```

This will follow the same pattern of all the sensors

```java
red1 = hardwareMap.get(DigitalChannel.class, "red1");
green1 = hardwareMap.get(DigitalChannel.class, "green1");
```

```java
red1.setMode(DigitalChannel.Mode.OUTPUT);//required to use indicators
green1.setMode(DigitalChannel.Mode.OUTPUT);
```

Call it in your code with `green1.setState(false); red1.setState(true);` or the inverse, setting green to true and red to false.


#### Built-in functions

```java
red1.setMode(DigitalChannel.Mode.OUTPUT);//required to use indicators
green1.setMode(DigitalChannel.Mode.OUTPUT);
green1.setState(false);
red.setState(true);
distance.getDistance(DistanceUnit.CM)//this is how you would call to get a distance, other options are MM, M, and INCHES
NormalizedRGBA color = colorSensor.getNormalizedColors();//this and the one below are how you get colors from the color sensors
Color.colorToHSV(color.toColor(), hsvValues);
touchSensor.isPressed()//will return true if it is pressed
```