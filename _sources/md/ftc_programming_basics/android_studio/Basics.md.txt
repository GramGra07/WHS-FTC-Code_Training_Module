# Basics

To get started with GitHub, Android Studio, and Java Programming, you will need to follow these steps:

1. Create a GitHub account if you haven't already
2. Fork the [FTC Robot Controller](https://github.com/FIRST-Tech-Challenge/FtcRobotController) repository
3. Download Android Studio
4. Clone your forked repository
5. Open the project in Android Studio
6. Code
7. Send the robot your updated code
8. Set up a config on your robot
9. Start controlling your robot!

## Android Studio Tutorial

### Android Studio Setup

Android Studio Setup Video Tutorial:

<div class="video-container">
        <video width="720" controls>
            <source src="/docs/build/html/_static/videos/Android Studio Setup Tutorial.mp4" type="video/mp4">
            Your browser does not support the video tag. <a href="/docs/build/html/_static/videos/Android Studio Setup Tutorial.mp4">Download</a>.
        </video>
</div>

Android studio is one of the easier IDEs in terms of setup and usability. There are a lot of things that you can get lost with easily though.

**Gradle** - The gradle is the way your app (robot) will run

**ADB** - Android Debug Bridge is the way your computer will connect to the control hub and build the application

### How does everything work?

* Basically, when you hit upload, it runs and installs an app to the robot's control hub. What this does is allow it to run effectively while connected to the driver station. The **gradle** is the way that this app gets built. This is also why it is so important to fork the FTC Robot Controller. They make the onboarding steps so much easier just because all the work for setup is done for you.

### Plugins

I have encountered a bunch of plugins for AS that make the experience so much better. None of these are mandatory but may improve your experience. You access this page in the settings for AS.

* ADB Idea - Allows you to effectively use ADB with your computer to make sure everything is working properly.
* Better Comments - Changes your comments to different colors with different tags. This is extremely beneficial because it catches your eye more so you can leave notes for yourself.
* CodeGlance Pro - This improves the normal sidebar you will see when scrolling, it shows you the color of all of your code so you can easily see where you might need to be looking.
* Discord Integration - Definitely not necessary but very fun to use and show everyone which project you are working on in Discord.
* Dracula Theme - My personal favorite theme for AS because it looks very nice and the color coding makes a lot of sense to me.
* GitHub Copilot - A very useful companion when you are coding. It is a **subscription** that you can get free with GitHub Student Developer but basically allows you to have an AI "copilot" built in to your IDE for code completion and general help.
* Star Wars Progress Bar - My personal favorite plugin I have. All it really does is change your progress bars to Star Wars ships. It adds a lot of fun to the IDE.
