---
description: >-
  Many teams find it extremely useful to connect their robot over WIFI, this
  allows you to connect and run code on your robot from anywhere in the room
  which is so useful
layout:
  title:
    visible: true
  description:
    visible: true
  tableOfContents:
    visible: true
  outline:
    visible: true
  pagination:
    visible: true
---

# Hub Connect Over Wifi

This is somewhat of a complex process and will require a lot of steps:

* Make sure ADB is installed on your computer
  * Check that it is installed by typing adb in your terminal and hitting enter, if it reports anything you are good to go, if it says "adb command not found", continue with setting it up
    * [https://www.xda-developers.com/install-adb-windows-macos-linux/](https://www.xda-developers.com/install-adb-windows-macos-linux/)
* Open Android Studio Settings
*   Open up the external tools portion

    ![](<.gitbook/assets/Screenshot 2024-07-25 at 10.14.02 PM.png>)
* Hit the + button to add an external tool

![](<.gitbook/assets/Screenshot 2024-07-25 at 10.15.40 PM.png>)

* Fill out the description and activities for the tool
  * Name: HUB connect over Wifi direct
  * Program: $ModuleSdkPath$/platform-tools/adb
  * Arguments: connect 192.168.43.1:5555
  * Working Directory: $ProjectFileDir$
* Then hit OK and Apply and then you can close the settings

Now we will add this tool to your tool bar for ease of use:&#x20;

* Right click on your tool bar

![](<.gitbook/assets/Screenshot 2024-07-25 at 10.18.01 PM.png>)

* Click customize toolbar
* Click + and "add action..." ![](<.gitbook/assets/Screenshot 2024-07-25 at 10.19.23 PM.png>)
* Select the external tool we just made and choose the icon you want

![](<.gitbook/assets/Screenshot 2024-07-25 at 10.20.21 PM.png>)

* Hit OK and move it to where you want it to be ordered in your tool bar
* Simply connect to your robot's wifi and hit the button to connect to it wirelessly!