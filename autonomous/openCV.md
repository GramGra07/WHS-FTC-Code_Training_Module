### Open CV (Computer Vision) 

OpenCV is a very good method for color and edge detection. It can be used for a lot of things if used correctly.
It is personally my choice for vision recognition and detection because of the thorough documentation and ease of use.
It can also be used in Python so if you find examples online, make sure to read and figure out what language it is in.

### Installation

This [website][eocv] has some very good instructions on how to install OpenCV to Android Studio and OnBotJava.
I would recommend following the instructions on the website, but I will also include some instructions here.

#### Android Studio

Open ```build.gradle``` in the TeamCode Module and at the bottom add this:

```dependencies { implementation 'org.openftc:easyopencv:1.7.0' }```

Then sync the gradle and you should be good to go. It should have a pop-up asking if you want to sync it.

#### OnBotJava

Go to this [link](https://github.com/OpenFTC/EasyOpenCV/releases) and download the latest .aar file from the assets section.

In the OnBotJava menu select Upload Files and upload the file you just downloaded.

### Using OpenCV

OpenCV is pretty easy to use, but can be hard to retrieve data from. The [EasyOpenCV][eocv] website has some good examples and documentation on how to use it.

#### Example

Here is the code for a sample pipeline that will strictly draw a box in the middle of the screen.

```
class SamplePipeline extends OpenCvPipeline{
        @Override
        public Mat processFrame(Mat input){
            Imgproc.rectangle(
                    input,
                    new Point(
                            input.cols()/4,
                            input.rows()/4),
                    new Point(
                            input.cols()*(3f/4f),
                            input.rows()*(3f/4f)),
                    new Scalar(0, 255, 0), 4);
            return input;
        }
```

The first line is a class declaration which can have any name but must extend OpenCvPipeline for it to work.

The second and third line are required for any class instance of OpenCvPipeline. 
This means that the processFrame method will always be called through OpenCvPipeline. 
The processFrame method is where you will put all of your code for the pipeline.

Next, we see Imgproc.rectangle. This is the method that actually draws the rectangle.
The parameters are, image to draw on, top left point, bottom right point, color, and thickness.

Then, OpenCV requires you to return the final processed image, in this case input.

### Terms to know

#### Pipeline

A pipeline is a class that uses OpenCv dependencies to show images, draw on them, and give back data on the image.

#### Point

A Point is a class used for setting an x,y coordinate.

To create a Point you can use ```Point point = new Point(x,y);```

#### HSV

HSV stands for Hue, Saturation, and Value. It is the most common for color detection.

Hue is the color, saturation is how much of the color, and value is the brightness of the color.

Here is a [picture][hsv] that shows what each value does.

#### Scalar

Scalar is a class that is used to store color values. It is used in OpenCV to set the color of things as well as for low and high values for color detection.
Scalars generally follow the same color type as the image.

To create a Scalar you can use ```Scalar scalar = new Scalar(hue, saturation, value);``` or ```Scalar scalar = new Scalar(red, green, blue);``` depending on the color type.

#### Mat

Mat stands for matrix and is where you will process images. It is used in OpenCV to store images and process them.

To create a Mat you can use ```Mat mat = new Mat();```

#### Placing Text

Placing text is a very useful tool for debugging and displaying information. It is very easy to do and can be done in one line.

```Imgproc.putText(mat, text, new Point(x,y), fomt(Imgproc.FONT_HERSHEY_SIMPLEX), fontScale, scalarValue, thickness);```

### Running OpenCV as an OpMode

[EasyOpenCV][eocv] WebcamExample is the perfect way to run OpenCV through an opMode. 
First, they create the webcam instance ```OpenCvWebcam webcam;```

And set up the camera 

```
int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
```

Then they set the pipeline ```webcam.setPipeline(new SamplePipeline());```
You can also change the name of the pipeline to your own pipeline.

That is all the major parts of running OpenCv as an OpMode although I would definitely refer teo the WebcamExample a lot as you are setting up your own OpMode.

### Detection using OpenCV

#### Color Detection

This pipeline is very useful because it will isolate the color you are trying to detect and will return a black and white image with only the color you are trying to detect.

```
public static class ColorDetection extends OpenCvPipeline {//isolation of color
        Mat hsv = new Mat();  //create hsv mat
        Mat mask1, mask2 = new Mat();  //create masks
        Mat end = new Mat();   //create output mat

        String color;  // create the color string

        public ColorDetection(String color) { // creates this class with a parameter of color
            this.color = color;
        }

        @Override
        public Mat processFrame(Mat input) {
            Scalar scalarLow, scalarHigh; //create scalars for high and low values
            if (color == "yellow") {
                scalarLow = new Scalar(20, 100, 100);
                scalarHigh = new Scalar(30, 255, 255);
            } else if (color == "blue") {
                scalarLow = new Scalar(90, 100, 100);
                scalarHigh = new Scalar(140, 255, 255);
            } else if (color == "green") {
                scalarLow = new Scalar(40, 100, 100);
                scalarHigh = new Scalar(75, 255, 255);
            } else {
                scalarLow = new Scalar(0, 0, 0);
                scalarHigh = new Scalar(0, 0, 0);
            }
            Imgproc.cvtColor(input, hsv, Imgproc.COLOR_RGB2HSV);//change to hsv
            if (!color.equals("red"))
                Core.inRange(hsv, scalarLow, scalarHigh, end);//detect color, output to end
            if (color == "red") {
                Core.inRange(hsv, new Scalar(0, 70, 50), new Scalar(8, 255, 255), mask1);
                Core.inRange(hsv, new Scalar(172, 70, 50), new Scalar(180, 255, 255), mask2);
                Core.bitwise_or(mask1, mask2, end);//takes both masks and combines them
            }
            return end;
        }
    }
```

You might notice that detecting red makes it harder. You can see that on this [image][hsv] that red is split into two parts.
To compensate for this you have to detect it twice essentially and combine the two created masks into one.

#### Edge Detection

Edge detection is a useful tool to outline things and it will show you a black and white image, with the white parts being edges.

```
    public static class EdgeDetection extends OpenCvPipeline {
        Mat gray = new Mat(); //create grayscale mat
        Mat edges = new Mat(); // create edges mat
        @Override
        public Mat processFrame(Mat input) {
            Imgproc.cvtColor(input, gray, Imgproc.COLOR_BGR2GRAY);  //takes the input Mat, converts it to grayscale, and outputs it to gray Mat
            Imgproc.Canny(gray, edges, 50, 100); // uses canny edge detection on the gray Mat and outputs it to edges Mat
            return edges;
        }
    }
```

There is so much you can do with OpenCV and practice but I would recommend reading through more of the Easy Open CV library to see how they do things.

[Next up: Road Runner][rr]

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
[beAuto]: /examples/exampleAutoBlank.txt
[feAuto]: /examples/exampleAutoFull.txt
[code]: /images/code.png
[zip]: /images/zip.png
[vcs]: /images/vcs.png
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
[eDemo]: /examples/RobotAutoDriveByEncoder_Linear.txt
[color]: /examples/SensorColor.txt
[IMU]: /examples/SensorBNO055IMU.txt

[blcP]: /baseLevelCode.md
[cP]: /coding.md
[mlP]: /autonomous/machineLearning.mdd/machineLearning.md
[gbP]: /basics/githubBasics.md
[laP]: /.etc/linksAndAcknowledgements.md
[eP]: /autonomous/encoders.md
[hP]: /README.md
[rr]: /autonomous/roadRunner.mdvanced/roadRunner.md
[cv]: /autonomous/openCV.mds/advanced/openCV.md