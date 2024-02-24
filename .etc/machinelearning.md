# Machine learning

**Note this is no longer supported in FTC SDK 8.0.0**

In FTC we typically use machine learning an AI's to detect images. In the FTC sample code in concept tensor flow object detection or TFOD, this is exactly what this does, it uses a tensorflow lite model in order for the robot to detect certain images, FTC has already trained some of it for us, but if you want to create your own AI it will take a little bit more work. [Here is the FTC object detection software](https://github.com/FIRST-Tech-Challenge/FtcRobotController/blob/master/FtcRobotController/src/main/java/org/firstinspires/ftc/robotcontroller/external/samples/ConceptTensorFlowObjectDetectionWebcam.java) To start, make sure your team is registered and you have roles set up correctly, this [website](https://ftc-docs.firstinspires.org/ftc\_ml/logging\_on/logging-on.html#adding-students-to-your-teams-ftc-ml-workspace) will show you exactly how that is possible. Note that only coaches can put video into the recognition so either arrange for a time or have your coach sign in for you _wink_. Then you will take your videos, I would recommend (for Power Play season) to have 6 videos, all 3 sides on both color cones, this will allow for the most accurate design. I just used wevideo to combine these videos into one. Once your coach or you have uploaded the video to the [Machine learning site](https://ftc-ml.firstinspires.org/), you will have to wait for it to "extract" the frames. Then you will click on the description and get to work, you will get a picture of your video, make your object detection by dragging your box over the part you want it to detect and name it. Then click start tracking. This might take a while and you will have to watch it like a hawk. It might think some of your images are the same label in which case go to the first frame it messes up and simply change the label and hit start tracking. Once you have labeled all of your frames, you will select your video and click produce dataset, all of the default settings should be good and this is the shortest part of the process. Next you will have to select the dataset and click start training. This part will take as long as you want it to take, I would recommend 3000 steps as this will give you the highest accuracy. Once you download your model, place it into your assets folder and change `private static final String TFOD_MODEL_ASSET = "PowerPlay.tflite";` in your code to `private static final String TFOD_MODEL_ASSET = "your file name.tflite";`. Now you will have to go back to the datasets and look at your labels, put these labels into the FTC sample code and you are good to go.

* Getting a VuForia key

Go to [this website](https://developer.vuforia.com/license-manager) and log in, and create a new key.

Video showing entire process:

https://user-images.githubusercontent.com/101433010/199403553-69995287-3eaf-4af7-b74c-d8ae17b0868a.mp4

[Next up: OpenCV](../opencv.md)

[Go back home](../)